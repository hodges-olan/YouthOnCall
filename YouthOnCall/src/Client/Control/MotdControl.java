/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client.Control;

import Client.View.MessageOfTheDay;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author co075oh
 */
public class MotdControl {
    
    public static String getMotd() {
        String message = "";
        try {
            URL url = new URL("http://feeds.lds.org/lds-inspirational-messages-eng");
            URLConnection connection = url.openConnection();
            try (BufferedReader motd = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                ArrayList<String> input = new ArrayList<>();
                String inputLine;
                while ((inputLine = motd.readLine()) != null) {
                    if(inputLine.startsWith("                <title>")) {
                        input.add(inputLine);
                        input.add(motd.readLine());
                        input.add(motd.readLine());
                        break;
                    }
                }
                Iterator<String> iterator = input.iterator();
                while (iterator.hasNext()) {
                    message+=iterator.next();
                }
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(MessageOfTheDay.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MessageOfTheDay.class.getName()).log(Level.SEVERE, null, ex);
        }
        return message;
    }

}
