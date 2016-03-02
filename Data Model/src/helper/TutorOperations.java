package helper;


import entities.Tutor;
import org.hibernate.Query;
import org.hibernate.Session;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Created by ghalib on 2/10/2016.
 */
public class TutorOperations {

    public boolean tutorLogin(String username, String password) {
        if (Helper.sessionFactory == null)
            Helper.init();
        Session session = Helper.sessionFactory.openSession();
        try {
            Query query = null;
            if (username.contains("@"))
                query = session.createQuery("from Tutor where email = :username and password = :password");
            else
                query = session.createQuery("from Tutor where tutorId = :username and password = :password");
            query.setParameter("username",username);
            query.setParameter("password",password);
            List<Tutor> tutorList = query.list();
            if (tutorList.size() > 0)
                return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (session!=null && session.isOpen())
                session.close();
        }
        return false;
    }

    public Tutor getTutor(String tutorId, String password) {
        if (Helper.sessionFactory == null)
            Helper.init();
        Session session = Helper.sessionFactory.openSession();
        try {
            Query query = null;
            if (tutorId.contains("@"))
                query = session.createQuery("from Tutor where email = :username and password = :password");
            else
                query = session.createQuery("from Tutor where tutorId = :username and password = :password");
            query.setParameter("username",tutorId);
            query.setParameter("password",password);
            List<Tutor> tutorList = query.list();
            return tutorList.get(0);
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (session!=null && session.isOpen())
                session.close();
        }
        return null;
    }

    public Tutor updateTutor(Tutor tutor) {
        if (Helper.sessionFactory == null)
            Helper.init();
        Session session = Helper.sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(tutor);
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
        }
        finally {
            if (session!=null && session.isOpen())
                session.close();
        }
        return null;
    }

    public Tutor addTutor(Tutor tutor) {
        if (Helper.sessionFactory == null)
            Helper.init();
        Session session = Helper.sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(tutor);
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
        }
        finally {
            if (session!=null && session.isOpen())
                session.close();
        }
        return tutor;
    }

    public boolean deleteTutor(Tutor tutor) {
        if (Helper.sessionFactory == null)
            Helper.init();
        Session session = Helper.sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(tutor);
            session.getTransaction().commit();
            return true;
        }catch (Exception e){
            session.getTransaction().rollback();
        }
        finally {
            if (session!=null && session.isOpen())
                session.close();
        }
        return false;
    }
}
