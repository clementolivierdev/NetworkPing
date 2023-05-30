package com.eiffage.pingnetwork.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe Caméra qui stocke les adresses mac & carte réseau
 *
 * @author clement olivier
 * @date 30-05-2023
 */
public class Camera {

    private final List<String> listeAdresseMacHanwha = new ArrayList<>();
    private final List<String> listeAdresseMacUniview = new ArrayList<>();
    private final List<String> listeAdresseMacAntenne = new ArrayList<>();
    private final List<String> listeAdresseMacPlanet = new ArrayList<>();
    private List<String> listeCarteReseau = new ArrayList<>();
    private String carteReseau;

    public Camera() {
        //HANWHA
        this.listeAdresseMacHanwha.add("e4-30-22");
        this.listeAdresseMacHanwha.add("00-09-18");
        this.listeAdresseMacHanwha.add("00-16-6c");
        //UNIVIEW
        this.listeAdresseMacUniview.add("6C-F1-7E");
        this.listeAdresseMacUniview.add("48-EA-63");
        //PLANET
        this.listeAdresseMacPlanet.add("00-30-4F");
        this.listeAdresseMacPlanet.add("00-12-FC");
        this.listeAdresseMacPlanet.add("00-16-4C");
        this.listeAdresseMacPlanet.add("A8-F7-E0");
    }

    public List<String> getListeAdresseMacHanwha() {
        return listeAdresseMacHanwha;
    }

    public List<String> getListeAdresseMacPlanet() {
        return listeAdresseMacPlanet;
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
