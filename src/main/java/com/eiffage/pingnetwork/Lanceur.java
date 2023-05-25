package com.eiffage.pingnetwork;

import com.eiffage.pingnetwork.services.CommandLineInterfaceService;
import com.eiffage.pingnetwork.services.ConvertisseurIPService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author clement olivier
 * @date 24-05-2023
 */
public class Lanceur {

    private static List<String> ip_reseau = new ArrayList<>();
    private static Scanner scan = new Scanner(System.in);

    private static String Nomrs = "";
    private static String nouvelleAdresse = "";

    public static void main(String[] args) {
        CommandLineInterfaceService commandLineInterfaceService = new CommandLineInterfaceService();
        ConvertisseurIPService convertisseurIPService = new ConvertisseurIPService();
        do {
            System.out.println("*** MENU ***\n"
                    + "1. Choisir sa carte Reseau\n"
                    + "2. Scanner son Reseau\n"
                    + "3. Quitter l'application");
            int choix = scan.nextInt();
            switch (choix) {
                case 1:
                    choisirSaCarteReseau(commandLineInterfaceService);
                    break;
                case 2:
                    scannerSonReseau(commandLineInterfaceService, convertisseurIPService);
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        } while (true);
    }

    private static void affichageCmd(Process p) {
        Thread t = new Thread() {
            @Override
            public void run() {
                BufferedReader input = null;
                input = new BufferedReader(new InputStreamReader(p.getInputStream(), StandardCharsets.UTF_8));
                String line = "";
                boolean lecture = false;
                int compteur = 10;
                try {
                    while ((line = input.readLine()) != null) {
                        if (line.contains("Ethernet Ethernet")) {
                            lecture = true;
                            compteur = 0;
                            ip_reseau.add(line.substring(15, line.length() - 2));
                        }

                        if (lecture) {
                            compteur++;
                        }

                        if (compteur == 1 || line.contains("Adresse IPv4") && lecture == true) {
                            System.out.println(line);
                        }

                        if (line.contains("Passerelle par d") && lecture == true) {
                            lecture = false;
                            compteur = 10;
                        }

                    }
                } catch (IOException e) {
                    System.out.println("Trouver mon ip : " + e);
                }
                try {
                    input.close();
                } catch (IOException ex) {
                    System.out.println("Trouver mon ip : " + ex);
                }
            }
        };
        t.start();
    }

    private static void affichageCmdArp(Process p, StringBuilder ipreseau) {
        System.out.println("*** AFFICHAGE EQUIPEMENTS ***\n" + "nouvelle addresse : " + nouvelleAdresse);
        Thread t = new Thread() {
            @Override
            public void run() {
                BufferedReader input = null;
                input = new BufferedReader(new InputStreamReader(p.getInputStream(), StandardCharsets.UTF_8));
                String line = "";
                boolean lecture = false;
                try {
                    while ((line = input.readLine()) != null) {
                        System.out.println(line);
                        /*if (line.contains(nouvelleAdresse) && line.startsWith("Interface")) {
                            lecture = true;
                        }

                        if (line.startsWith("Interface") && lecture == true || line.contains("dynamique") && lecture == true) {
                            System.out.println(line);
                        }

                        if (line.contains(".255") && line.contains("-ff-") && lecture == true) {
                            lecture = false;
                        }*/

                    }
                } catch (IOException e) {
                    System.out.println("Trouver mon ip : " + e);
                }
                try {
                    input.close();
                } catch (IOException ex) {
                    System.out.println("Trouver mon ip : " + ex);
                }
            }
        };
        t.start();
    }

    private static void choisirSaCarteReseau(CommandLineInterfaceService commandLineInterfaceService) {
        //1 Choisir sa carte reseau
        final Process p_ipconfig = commandLineInterfaceService.executeCommand("cmd /c ipconfig");
        //Lecture Ethernet puis 6 lgnes apres stop
        //Chaque Adresse IP v4 dans une Liste au cas où l'utilisateur a des alias
        affichageCmd(p_ipconfig);

        //Choisir la carte reseau a changer
        System.out.println("Entrez le numéro de carte a modifier : [0,1,..]");
        int reseauName = scan.nextInt();
        Nomrs = ip_reseau.get(reseauName);
        System.out.println("Carte définie : " + Nomrs + "\n");
    }

    private static void scannerSonReseau(CommandLineInterfaceService commandLineInterfaceService, ConvertisseurIPService convertisseurIPService) {
        try {
            //2 Choisir une adresse IP
            System.out.println("Entre l'adresse IP a modifier :");
            nouvelleAdresse = scan.next();
            //Détermine le masque automatiquement ainsi que la passerelle si besoin
            String mask = convertisseurIPService.getIPv4Mask(nouvelleAdresse);
            //Détermine l'ip reseau
            String[] splitIP = nouvelleAdresse.split("\\.");
            StringBuilder monReseau = new StringBuilder();
            monReseau.append(splitIP[0]).append(".").append(splitIP[1]).append(".").append(splitIP[2]).append(".");
            //Changer son adresse IP

            String commande = "elevate.exe powershell.exe netsh interface ip set address “" + Nomrs + "” static " + nouvelleAdresse + " " + mask;

            final Process p_changeIP = commandLineInterfaceService.executeCommand(commande);
            Thread.sleep(4000);

            //3 ping son reseau
            final Process pAll = commandLineInterfaceService.executeCommand("cmd.exe /C FOR /L %i in (1,1,20) do @ping " + monReseau + "%i -w 1 -n 1");
            final Process p255 = commandLineInterfaceService.executeCommand("cmd /C ping " + monReseau + "255 -w 1 -n 1");

            final Process ping_arp = commandLineInterfaceService.executeCommand("cmd /C arp -a");
            affichageCmdArp(ping_arp, monReseau);
            Thread.sleep(6000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Lanceur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
