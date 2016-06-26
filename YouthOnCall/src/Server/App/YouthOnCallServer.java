/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.App;

import Server.Control.MembersControl;
import Server.Control.JobsControl;
import Server.Model.Jobs;
import Server.Model.Members;
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
            
            Members member = new Members(1, "Olan Hodges", "olanhodges@gmail.com", "3312 Westview Drive", "McKinney", "TX", 75070, "214-585-2561", false, "Test123!");
            member.setId(membersControl.createMember(sessionFactory, member));
            
            Jobs job = new Jobs(1, "Mowing and Edging", "Mow and edge both the front and back yard.", 20, member.getId(), 1, 0, "Active");
            jobsControl.createJob(sessionFactory, job);
            
        }
    }
    
}
