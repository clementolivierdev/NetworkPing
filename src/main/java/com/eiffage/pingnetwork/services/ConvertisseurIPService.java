package com.eiffage.pingnetwork.services;

/**
 * Classe De convertisseur IP
 *
 * @author clement olivier
 * @date 25-05-2023
 */
public class ConvertisseurIPService {

    /**
     * Permet d'obtenir l'adresse de sous réseau en fonction de l'adresse IPv4
     *
     * @param ip Adresse IPv4
     * @return Adresse de Sous Réseau
     */
    public String getIPv4Mask(String ip) {
        String checkclass = ip.substring(0, 3);
        int cc = Integer.parseInt(checkclass);
        String mask = null;
        if (cc > 0 && cc < 224) { // CLASSE A
            if (cc < 128) {
                mask = "255.0.0.0";
            }
            if (cc > 127 && cc < 192) { // CLASSE B
                mask = "255.255.0.0";
            }
            if (cc > 191) { // CLASSE C
                mask = "255.255.255.0";
            }
        }
        return mask;
    }
}
