/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client.App;

import Client.View.LogonUI;
import Client.View.MainMenuUI;

/**
 *
 * @author co075oh
 */
public class YouthOnCallClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new LogonUI().setVisible(true);
        new MainMenuUI().setVisible(true);
    }
    
}
