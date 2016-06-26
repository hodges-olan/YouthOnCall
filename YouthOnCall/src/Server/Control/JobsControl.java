/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.Control;

import Server.Model.Jobs;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author co075oh
 */
public class JobsControl {
    
    public Integer createJob(SessionFactory sessionFactory, Jobs job) {
        Integer jobID;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            jobID = (Integer) session.save(job);
            session.getTransaction().commit();
        }
        return jobID;
    }
    
    public void updateJob(SessionFactory sessionFactory, Jobs job) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(job);
            session.getTransaction().commit();
        }
    }
    
    public Jobs retrieveJob(SessionFactory sessionFactory, Integer search) {
        Jobs job;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            job = session.get(Jobs.class, search);
        }
        return job;
    }
    
    public List<Jobs> retrieveAllJobs(SessionFactory sessionFactory) {
        List<Jobs> jobs;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            jobs = session.createCriteria(Jobs.class).list();
        }
        return jobs;
    }
    
}
