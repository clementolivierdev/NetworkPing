package com.eiffage.pingnetwork.vue;

import com.eiffage.pingnetwork.entities.Camera;
import com.eiffage.pingnetwork.services.*;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Fenêtre graphique
 *
 * @author clement olivier
 * @date 30-05-2023
 */
public class IHM extends javax.swing.JFrame {

    private CommandLineInterfaceService commandLineInterfaceService;
    private ConvertisseurIPService convertisseurIPService;
    private Camera camera;
    private RegexService regex;
    private final Image icon = Toolkit.getDefaultToolkit().getImage("eiffageLogo.png");

    private final List<String> listeIPReseau = new ArrayList<>();

    private String modelEquipement = "";
    private String nouvelleAdresse = "";
    private int compteurInterface = 0;

    //Constructeur
    public IHM() {
        initComponents();
        this.setIconImage(icon);
        jButtonScan.setEnabled(false);
        jButtonDHCP.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldIP = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButtonScan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaAffichage = new javax.swing.JTextArea();
        jButtonDefinirCarte = new javax.swing.JButton();
        jButtonQuitter = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxEquipement = new javax.swing.JComboBox<>();
        jButtonDHCP = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("IP SCANNER");

        jTextFieldIP.setText("192.168.10.63");
        jTextFieldIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIPActionPerformed(evt);
            }
        });

        jLabel1.setText("adresse ip :");

        jButtonScan.setText("Scanner");
        jButtonScan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonScanActionPerformed(evt);
            }
        });

        jTextAreaAffichage.setColumns(20);
        jTextAreaAffichage.setRows(5);
        jScrollPane1.setViewportView(jTextAreaAffichage);

        jButtonDefinirCarte.setText("definir carte");
        jButtonDefinirCarte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDefinirCarteActionPerformed(evt);
            }
        });

        jButtonQuitter.setText("Quitter");
        jButtonQuitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuitterActionPerformed(evt);
            }
        });

        jLabel2.setText("type d'équipements :");

        jComboBoxEquipement.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tout", "Hanwha", "Uniview", "Planet", "Antenne" }));

        jButtonDHCP.setText("DHCP");
        jButtonDHCP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDHCPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonDHCP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonQuitter)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldIP, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                            .addComponent(jComboBoxEquipement, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonDefinirCarte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonScan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(27, 27, 27))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jComboBoxEquipement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonDefinirCarte))
                        .addGap(74, 74, 74))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonScan)
                            .addComponent(jTextFieldIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonDHCP)
                    .addComponent(jButtonQuitter))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonScanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonScanActionPerformed
        scannerSonReseau();
    }//GEN-LAST:event_jButtonScanActionPerformed

    private void jTextFieldIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIPActionPerformed
    }//GEN-LAST:event_jTextFieldIPActionPerformed

    private void jButtonDefinirCarteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDefinirCarteActionPerformed
        modelEquipement = jComboBoxEquipement.getItemAt(jComboBoxEquipement.getSelectedIndex());
        choisirSaCarteReseau(true);
        definirSonIP();
    }//GEN-LAST:event_jButtonDefinirCarteActionPerformed

    private void jButtonQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuitterActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButtonQuitterActionPerformed

    private void jButtonDHCPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDHCPActionPerformed
        revenirDHCP();
    }//GEN-LAST:event_jButtonDHCPActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IHM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IHM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IHM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IHM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IHM().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDHCP;
    private javax.swing.JButton jButtonDefinirCarte;
    private javax.swing.JButton jButtonQuitter;
    private javax.swing.JButton jButtonScan;
    private javax.swing.JComboBox<String> jComboBoxEquipement;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaAffichage;
    private javax.swing.JTextField jTextFieldIP;
    // End of variables declaration//GEN-END:variables

    /*
    * Affiche les adresses IPv4 de chaque carte réseau
    *
    * @param p 
     */
    private void affichageCmd(Process p) {
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
                            camera.getListeCarteReseau().add(line.substring(15, line.length() - 2));
                            jTextAreaAffichage.append("------------------------------------------------\n" + line + " " + compteurInterface + "\n");
                            compteurInterface++;
                        } else if (line.contains("sans fil Wi-Fi")) {
                            lecture = true;
                            compteur = 0;
                            camera.getListeCarteReseau().add("Wi-fi");
                            jTextAreaAffichage.append("------------------------------------------------\n" + line + " " + compteurInterface + "\n");
                            compteurInterface++;
                        }

                        if (lecture) {
                            compteur++;
                        }

                        if (line.contains("Adresse IPv4") && lecture == true) {
                            listeIPReseau.add(line.substring(44, line.length()));
                            jTextAreaAffichage.append(line + "\n");
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

    /*
    * Affiche les équipements connectés à notre réseau
    *
    * @param p 
     */
    private void affichageCmdArp(Process p) {
        Thread t = new Thread() {
            @Override
            public void run() {
                BufferedReader input = null;
                input = new BufferedReader(new InputStreamReader(p.getInputStream(), StandardCharsets.UTF_8));
                String line = "";
                boolean lecture = false;
                try {
                    while ((line = input.readLine()) != null) {
                        if (line.contains(nouvelleAdresse) && line.startsWith("Interface")) {
                            lecture = true;
                            jTextAreaAffichage.append(line + "\n");
                        }

                        if (lecture == true) {
                            switch (modelEquipement) {
                                case "Hanwha" -> {
                                    for (String s : camera.getListeAdresseMacHanwha()) {
                                        if (line.toLowerCase().contains(s.toLowerCase())) {
                                            jTextAreaAffichage.append(line + "\n");
                                        }
                                    }//FIN FOR
                                }
                                case "Uniview" -> {
                                    for (String s : camera.getListeAdresseMacUniview()) {
                                        if (line.toLowerCase().contains(s.toLowerCase())) {
                                            jTextAreaAffichage.append(line + "\n");
                                        }
                                    }//FIN FOR
                                }
                                case "Antenne" -> {
                                    for (String s : camera.getListeAdresseMacAntenne()) {
                                        if (line.toLowerCase().contains(s.toLowerCase())) {
                                            jTextAreaAffichage.append(line + "\n");
                                        }
                                    }//FIN FOR
                                }
                                case "Planet" -> {
                                    for (String s : camera.getListeAdresseMacPlanet()) {
                                        if (line.toLowerCase().contains(s.toLowerCase())) {
                                            jTextAreaAffichage.append(line + "\n");
                                        }
                                    }//FIN FOR
                                }
                                case "Tout" ->
                                    jTextAreaAffichage.append(line + "\n");
                                default -> {
                                }
                            }

                        }

                        if (line.contains(".255") && line.contains("-ff-") && lecture == true) {
                            lecture = false;
                        }

                    }
                    input.close();
                } catch (IOException e) {
                    System.out.println("Trouver mon ip : " + e);
                }
            }
        };
        t.start();
    }

    /*
    * Permet de détecter les cartes réseaux et leur adresses IPv4 associés (alias compris)
    *
     */
    private void choisirSaCarteReseau(boolean choisirCarte) {
        jTextAreaAffichage.setText("");
        //1 Choisir sa carte reseau
        final Process p_ipconfig = commandLineInterfaceService.executeCommand("cmd /c ipconfig");
        //Lecture Ethernet puis 6 lgnes apres stop
        //Chaque Adresse IP v4 dans une Liste au cas où l'utilisateur a des alias
        compteurInterface = 0;
        affichageCmd(p_ipconfig);
        //Choisir la carte reseau a changer
        if (choisirCarte) {
            String numeroCarteReseau = JOptionPane.showInputDialog(this, "Entrez le numéro de carte à modifier : [0,1,..]");
            if (regex.verifierNombre(numeroCarteReseau) && Integer.parseInt(numeroCarteReseau) <= camera.getListeCarteReseau().size()) {
                compteurInterface = Integer.parseInt(numeroCarteReseau);
                camera.setCarteReseau(camera.getListeCarteReseau().get(compteurInterface));
                jTextAreaAffichage.append("------------------------------------------------\nCarte définie : " + camera.getCarteReseau() + "\n");
                jButtonScan.setEnabled(true);
                jButtonDHCP.setEnabled(true);
                definirSonIP();
            } else {
                jTextAreaAffichage.append("------------------------------------------------\nAucune Carte sélectionnée");
            }
        }
    }

    /*
    * Permet de ping les 40 premières adresses du réseau et la dernière .255 puis affiche les équipements connectés
    *
     */
    private void scannerSonReseau() {
        try {
            modelEquipement = jComboBoxEquipement.getItemAt(jComboBoxEquipement.getSelectedIndex());
            //2 Choisir une adresse IP
            jTextAreaAffichage.setText("");
            if (regex.verifierIP(jTextFieldIP.getText())) {
                nouvelleAdresse = jTextFieldIP.getText();
                //Détermine le masque automatiquement
                String mask = convertisseurIPService.getIPv4Mask(nouvelleAdresse);
                //Détermine l'ip reseau
                String[] splitIP = nouvelleAdresse.split("\\.");
                StringBuilder monReseau = new StringBuilder();
                monReseau.append(splitIP[0]).append(".").append(splitIP[1]).append(".").append(splitIP[2]).append(".");
                //Changer son adresse IP
                String commande = "elevate.exe powershell.exe netsh interface ip set address “" + camera.getCarteReseau() + "” static " + nouvelleAdresse + " " + mask;
                commandLineInterfaceService.executeCommand(commande);
                Thread.sleep(4000);
                //3 ping son reseau
                commandLineInterfaceService.executeCommand("cmd.exe /C FOR /L %i in (1,1,40) do @ping " + monReseau + "%i -w 1 -n 1");
                Thread.sleep(10000);
                commandLineInterfaceService.executeCommand("cmd /C ping " + monReseau + "255 -w 1 -n 1");
                Thread.sleep(500);
                final Process ping_arp = commandLineInterfaceService.executeCommand("arp -a");
                affichageCmdArp(ping_arp);
                Thread.sleep(500);
                definirSonIP();
            } else {
                jTextAreaAffichage.append("------------------------------------------------\nVérifiez l'adresse IP inscrite");
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(IHM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*
    * Permet de passer d'une adresse ip statique à dynamique
    *
     */
    private void revenirDHCP() {
        try {
            //Changer son adresse IP
            String commande = "elevate.exe powershell.exe netsh interface ip set address “" + camera.getCarteReseau() + "” dhcp";
            commandLineInterfaceService.executeCommand(commande);
            Thread.sleep(3500);
            choisirSaCarteReseau(false);
            definirSonIP();
        } catch (InterruptedException ex) {
            Logger.getLogger(IHM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*
    * Permet de ré-initialiser le jtexteField à la bonne adresse IPv4
    *
     */
    private void definirSonIP() {
        jTextFieldIP.setText(listeIPReseau.get(compteurInterface));
    }

    public void setClasses(CommandLineInterfaceService commandLineInterfaceService, ConvertisseurIPService convertisseurIPService, Camera camera, RegexService regex) {
        this.convertisseurIPService = convertisseurIPService;
        this.commandLineInterfaceService = commandLineInterfaceService;
        this.camera = camera;
        this.regex = regex;
    }
}
