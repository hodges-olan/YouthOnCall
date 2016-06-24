/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.App;

import Client.Control.MembersControl;
import Server.Control.JobsControl;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author co075oh
 */
public class YouthOnCallServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
            JobsControl jobsControl = new JobsControl();
            MembersControl membersControl = new MembersControl();
        }
    }
    
}
