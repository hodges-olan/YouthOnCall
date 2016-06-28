/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.App;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author co075oh
 */
public class ClientConnThread implements Runnable {

    // Declare attributes
    Socket socket;
    Scanner inputStream;
    PrintStream outputStream;
    
    // Default Constructor
    public ClientConnThread (Socket socket) throws IOException {
        this.socket = socket;
        this.inputStream = new Scanner(socket.getInputStream());
        this.outputStream = new PrintStream(socket.getOutputStream());
    }
    
    // Run Method
    @Override
    public void run() {
        boolean done = false;
        String command, data;
        
        while (!done) {
            // Gather information from client
            command = inputStream.nextLine();
            switch(command) {
                case "createMember":
                    data = inputStream.nextLine();
                    this.createMember(data);
                    break;
                case "updateMember":
                    data = inputStream.nextLine();
                    this.updateMember(data);
                    break;
                case "retrieveMember":
                    data = inputStream.nextLine();
                    this.retrieveMember(data);
                    break;
                case "retrieveAllMembers":
                    data = inputStream.nextLine();
                    this.retrieveAllMembers(data);
                    break;
                case "retrieveAllYouth":
                    data = inputStream.nextLine();
                    this.retrieveAllYouth(data);
                    break;
                case "authMember":
                    data = inputStream.nextLine();
                    this.authMember(data);
                    break;
                case "bye":
                    done = true;
                    this.inputStream.close();
                    this.outputStream.close();
                    try {
                        this.socket.close();
                    } catch (IOException ex) {
                        Logger.getLogger(ClientConnThread.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
        }
    }

    // Create member method
    private void createMember(String data) {
        this.outputStream.println("createMember called!");
    }

    // Update member method
    private void updateMember(String data) {
        this.outputStream.println("updateMember called!");
    }

    // Retrieve member method
    private void retrieveMember(String data) {
        this.outputStream.println("retrieveMember called!");
    }

    // Retrieve all members method
    private void retrieveAllMembers(String data) {
        this.outputStream.println("retrieveAllMembers called!");
    }

    // Retrieve all youth method
    private void retrieveAllYouth(String data) {
        this.outputStream.println("retrieveAllYouth called!");
    }

    // Authenticate member method
    private void authMember(String data) {
        this.outputStream.println("authMember called!");
    }
    
}
