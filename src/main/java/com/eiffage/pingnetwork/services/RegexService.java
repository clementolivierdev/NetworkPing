package com.eiffage.pingnetwork.services;

import java.util.regex.Pattern;

/**
 * Classe de Regex
 *
 * @author Clément Olivier
 * @date 30-06-2023
 */
public class RegexService {

    /**
     * Permet de vérifier si le String utilisé est une adresse IP
     *
     * @param ip Adresse IP
     * @return Boolean vérification
     */
    public boolean verifierIP(String ip) {
        String[] splitIP = ip.split("\\.");
        for (String split : splitIP) {
            if (split.length() > 3 || Integer.parseInt(split) <= 0 || Integer.parseInt(split) >= 255) {
                return false;
            }
        }
        return Pattern.matches("[0-9.]+", ip) && splitIP.length == 4;
    }

    /**
     * Permet de vérifier si le String utilisé contient uniquement des Chiffres
     *
     * @param nombre Chiffre correspondant à une carte réseau
     * @return Boolean vérification
     */
    public boolean verifierNombre(String nombre) {
        return Pattern.matches("[0-9]+", nombre);
    }

}
