package com.eiffage.pingnetwork.entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author olicl
 */
public class Camera {

    private List<String> listeAdresseMacHanwha = new ArrayList<>();
    private List<String> listeAdresseMacUniview = new ArrayList<>();
    private List<String> listeAdresseMacAntenne = new ArrayList<>();
    private List<String> listeCarteReseau = new ArrayList<>();
    private String carteReseau;

    public Camera() {
        this.listeAdresseMacHanwha.add("e4-30-22");
        this.listeAdresseMacHanwha.add("00-09-18");
        this.listeAdresseMacHanwha.add("00-16-6c");
    }

    public List<String> getListeAdresseMacHanwha() {
        return listeAdresseMacHanwha;
    }

    public String getCarteReseau() {
        return carteReseau;
    }

    public void setCarteReseau(String carteReseau) {
        this.carteReseau = carteReseau;
    }

    public List<String> getListeCarteReseau() {
        return listeCarteReseau;
    }

    public void setListeCarteReseau(List<String> listeAllIPNetwork) {
        this.listeCarteReseau = listeAllIPNetwork;
    }

    public List<String> getListeAdresseMacUniview() {
        return listeAdresseMacUniview;
    }

    public List<String> getListeAdresseMacAntenne() {
        return listeAdresseMacAntenne;
    }
    
    

}
