/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.App;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author co075oh
 */
public class YouthOnCallServer {

    // Declare Executor Service
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();
    
    // Declare Session Factory
    private static final SessionFactory SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
    
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        
        // Create Server Socket
        ServerSocket serverSocket = new ServerSocket(7890);
        
        // Await client connections
        while (true) {
            Socket socket = serverSocket.accept();
            EXECUTOR_SERVICE.submit(new ClientConnThread(socket));
        }
        
    }

    // Getter Methods

    public static ExecutorService getExecutorService() {
        return EXECUTOR_SERVICE;
    }

    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }
    
}
