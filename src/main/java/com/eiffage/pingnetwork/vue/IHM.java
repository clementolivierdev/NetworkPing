package com.eiffage.pingnetwork.vue;

import com.eiffage.pingnetwork.services.CommandLineInterfaceService;
import com.eiffage.pingnetwork.services.ConvertisseurIPService;
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
 * @date 25-05-2023
 */
public class IHM extends javax.swing.JFrame {

    private List<String> ip_reseau = new ArrayList<>();

    private CommandLineInterfaceService commandLineInterfaceService;
    private ConvertisseurIPService convertisseurIPService;

    private String Nomrs = "";
    private String nouvelleAdresse = "";
    private int compteurInterface = 0;

    //Constructeur
    public IHM() {
        initComponents();
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
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jTextFieldIP, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonDefinirCarte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonScan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonQuitter)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonDefinirCarte)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonScan)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonQuitter))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonScanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonScanActionPerformed
        scannerSonReseau();
    }//GEN-LAST:event_jButtonScanActionPerformed

    private void jTextFieldIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIPActionPerformed
    }//GEN-LAST:event_jTextFieldIPActionPerformed

    private void jButtonDefinirCarteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDefinirCarteActionPerformed
        choisirSaCarteReseau();
    }//GEN-LAST:event_jButtonDefinirCarteActionPerformed

    private void jButtonQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuitterActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButtonQuitterActionPerformed

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
    private javax.swing.JButton jButtonDefinirCarte;
    private javax.swing.JButton jButtonQuitter;
    private javax.swing.JButton jButtonScan;
    private javax.swing.JLabel jLabel1;
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
                            ip_reseau.add(line.substring(15, line.length() - 2));
                            jTextAreaAffichage.append(line + " " + compteurInterface + "\n");
                            compteurInterface++;
                        }

                        if (lecture) {
                            compteur++;
                        }

                        if (line.contains("Adresse IPv4") && lecture == true) {
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
                        }

                        if (line.startsWith("Interface") && lecture == true || line.contains("dynamique") && lecture == true) {
                            jTextAreaAffichage.append(line + "\n");
                        }

                        if (line.contains(".255") && line.contains("-ff-") && lecture == true) {
                            lecture = false;
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
    * Permet de détecter les cartes réseaux et leur adresses IPv4 associés (alias compris)
    *
     */
    private void choisirSaCarteReseau() {
        jTextAreaAffichage.setText("");
        //1 Choisir sa carte reseau
        final Process p_ipconfig = commandLineInterfaceService.executeCommand("cmd /c ipconfig");
        //Lecture Ethernet puis 6 lgnes apres stop
        //Chaque Adresse IP v4 dans une Liste au cas où l'utilisateur a des alias
        affichageCmd(p_ipconfig);

        //Choisir la carte reseau a changer
        int reseauName = Integer.parseInt(JOptionPane.showInputDialog(this, "Entrez le numéro de carte à modifier : [0,1,..]"));
        Nomrs = ip_reseau.get(reseauName);
        jTextAreaAffichage.append("Carte définie : " + Nomrs + "\n");
    }

    /*
    * Permet de ping les 20 premières adresses du réseau et la dernière .255 puis affiche les équipements connectés
    *
     */
    private void scannerSonReseau() {
        try {
            //2 Choisir une adresse IP
            jTextAreaAffichage.setText("");
            nouvelleAdresse = jTextFieldIP.getText();
            //Détermine le masque automatiquement ainsi que la passerelle si besoin
            String mask = convertisseurIPService.getIPv4Mask(nouvelleAdresse);
            //Détermine l'ip reseau
            String[] splitIP = nouvelleAdresse.split("\\.");
            StringBuilder monReseau = new StringBuilder();
            monReseau.append(splitIP[0]).append(".").append(splitIP[1]).append(".").append(splitIP[2]).append(".");
            //Changer son adresse IP
            String commande = "elevate.exe powershell.exe netsh interface ip set address “" + Nomrs + "” static " + nouvelleAdresse + " " + mask;
            commandLineInterfaceService.executeCommand(commande);
            Thread.sleep(4000);
            //3 ping son reseau
            commandLineInterfaceService.executeCommand("cmd.exe /C FOR /L %i in (1,1,20) do @ping " + monReseau + "%i -w 1 -n 1");
            Thread.sleep(4000);
            commandLineInterfaceService.executeCommand("cmd /C ping " + monReseau + "255 -w 1 -n 1");
            Thread.sleep(500);
            final Process ping_arp = commandLineInterfaceService.executeCommand("arp -a");
            affichageCmdArp(ping_arp);
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(IHM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setClasses(CommandLineInterfaceService commandLineInterfaceService, ConvertisseurIPService convertisseurIPService) {
        this.convertisseurIPService = convertisseurIPService;
        this.commandLineInterfaceService = commandLineInterfaceService;
    }
}
