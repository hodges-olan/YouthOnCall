/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.Control;

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

    public Integer createMember(SessionFactory sessionFactory, Members member) {
        Integer memberID = 0;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            memberID = (Integer) session.save(member);
            session.getTransaction().commit();
        }
        return memberID;
    }
    
    public void updateMember(SessionFactory sessionFactory, Members member) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(member);
            session.getTransaction().commit();
        }
    }
    
    public Members retrieveMember(SessionFactory sessionFactory, Integer search) {
        Members member;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            member = session.get(Members.class, search);
        }
        return member;
    }
    
    public List<Members> retrieveAllMembers(SessionFactory sessionFactory) {
        List<Members> members;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            members = session.createCriteria(Members.class).add( Restrictions.eq("youth", false) ).list();
        }
        return members;
    }
    
    public List<Members> retrieveAllYouth(SessionFactory sessionFactory) {
        List<Members> youth;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            youth = session.createCriteria(Members.class).add( Restrictions.eq("youth", true) ).list();
        }
        return youth;
    }
    
}
