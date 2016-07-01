/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client.App;

import Client.View.LogonUI;

/**
 *
 * @author co075oh
 */
public class YouthOnCallClient {

    // Define Server and Socket
    public static final String SERVER = "127.0.0.1";
    public static final int PORT = 7890;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Start Logon process
        new LogonUI().setVisible(true);
        
    }
    
}
