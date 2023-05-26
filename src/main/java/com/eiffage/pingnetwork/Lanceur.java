package com.eiffage.pingnetwork;

import com.eiffage.pingnetwork.entities.Camera;
import com.eiffage.pingnetwork.services.CommandLineInterfaceService;
import com.eiffage.pingnetwork.services.ConvertisseurIPService;
import com.eiffage.pingnetwork.vue.IHM;

/**
 * Classe De démarrage
 *
 * @author clement olivier
 * @date 25-05-2023
 */
public class Lanceur {

    public static void main(String[] args) {
        CommandLineInterfaceService commandLineInterfaceService = new CommandLineInterfaceService();
        ConvertisseurIPService convertisseurIPService = new ConvertisseurIPService();
        Camera camera = new Camera();
        IHM ihm = new IHM();
        ihm.setClasses(commandLineInterfaceService, convertisseurIPService, camera);
        ihm.setVisible(true);
    }

}
