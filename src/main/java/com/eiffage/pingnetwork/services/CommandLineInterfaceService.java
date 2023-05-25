package com.eiffage.pingnetwork.services;

import java.io.IOException;

/**
 * Classe d'Execution de commandes cmd
 *
 * @author Clément Olivier
 * @date 24-05-2023
 */
public class CommandLineInterfaceService {

    /**
     * Permet de lancer une commande cmd
     *
     * @param command Nom de la commande
     * @return Resultat lignes
     */
    public Process executeCommand(String command) {
        Process p = null;
        try {
            p = Runtime.getRuntime().exec(command);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return p;
    }
}
