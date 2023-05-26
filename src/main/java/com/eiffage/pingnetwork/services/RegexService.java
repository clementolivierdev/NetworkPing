package com.eiffage.pingnetwork.services;

import java.util.regex.Pattern;

/**
 * Classe de Regex
 *
 * @author Clément Olivier
 * @date 26-06-2023
 */
public class RegexService {

    /**
     * Permet de vérifier si le String utilisé contient uniquement des Chiffres et des points
     * @param ip Adresse IP
     * @return Boolean vérification
     */
    public boolean verifierIP(String ip) {
        String[] splitIP = ip.split("\\.");
        return Pattern.matches("[0-9.]+", ip) && splitIP.length==4;
    }

    /**
     * Permet de vérifier si le String utilisé contient uniquement des Chiffres
     * @param nombre Chiffre correspondant à une carte réseau
     * @return Boolean vérification
     */
    public boolean verifierNombre(String nombre) {
        return Pattern.matches("[0-9]+", nombre);
    }

}