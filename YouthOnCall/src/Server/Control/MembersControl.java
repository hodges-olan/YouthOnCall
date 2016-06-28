/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.Control;

import Server.App.YouthOnCallServer;
import Server.Model.Members;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author co075oh
 */
public class MembersControl {

    public Integer createMember(Members member) {
        SessionFactory sessionFactory = YouthOnCallServer.getSessionFactory();
        Integer memberID;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            memberID = (Integer) session.save(member);
            session.getTransaction().commit();
        }
        return memberID;
    }
    
    public void updateMember(Members member) {
        SessionFactory sessionFactory = YouthOnCallServer.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(member);
            session.getTransaction().commit();
        }
    }
    
    public Members retrieveMember(Integer search) {
        Members member;
        SessionFactory sessionFactory = YouthOnCallServer.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            member = session.get(Members.class, search);
        }
        return member;
    }
    
    public List<Members> retrieveAllMembers() {
        List<Members> members;
        SessionFactory sessionFactory = YouthOnCallServer.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            members = session.createCriteria(Members.class).add( Restrictions.eq("youth", false) ).list();
        }
        return members;
    }
    
    public List<Members> retrieveAllYouth() {
        List<Members> youth;
        SessionFactory sessionFactory = YouthOnCallServer.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            youth = session.createCriteria(Members.class).add( Restrictions.eq("youth", true) ).list();
        }
        return youth;
    }
    
    public String authMember(String data) {
        SessionFactory sessionFactory = YouthOnCallServer.getSessionFactory();
        String returnData = "authMember method called!";
        return returnData;
    }
}
