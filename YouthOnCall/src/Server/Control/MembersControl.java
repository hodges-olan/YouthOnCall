/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.Control;

import Server.App.YouthOnCallServer;
import Server.Model.Members;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    public boolean authMember(String email, String password) {
        String hashedPassword = this.hashPassword(password);
        boolean authenticated = false;
        SessionFactory sessionFactory = YouthOnCallServer.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            if (session.createCriteria(Members.class).add( Restrictions.eq("email", email) ).add( Restrictions.eq("password", hashedPassword) ).list().size() == 1) {
                authenticated = true;
            }
        }
        return authenticated;
    }
    
    public String hashPassword(String password) {
        String hashedPassword = "nopassword";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes("UTF-8"));
            byte[] byteData = md.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
            hashedPassword = sb.toString();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            Logger.getLogger(Client.Model.Members.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hashedPassword;
    }
    
}
