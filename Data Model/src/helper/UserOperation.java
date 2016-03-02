package helper;

import entities.User;
import org.hibernate.Query;
import org.hibernate.Session;

import java.sql.*;
import java.util.List;

/**
 * Created by ghalib on 2/10/2016.
 */
public class UserOperation {

    public boolean userLogin(String username, String password) {
        if (Helper.sessionFactory == null)
            Helper.init();
        Session session = Helper.sessionFactory.openSession();
        try {
            Query query = null;
            if (username.contains("@"))
                query = session.createQuery("from User where email = :username and password = :password");
            else
                query = session.createQuery("from User where username = :username and password = :password");
            query.setParameter("username",username);
            query.setParameter("password",password);
            List<User> userList = query.list();
            if (userList.size() > 0)
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

    public User getUser(String username, String password) {
        if (Helper.sessionFactory == null)
            Helper.init();
        Session session = Helper.sessionFactory.openSession();
        try {
            Query query = null;
            if (username.contains("@"))
                query = session.createQuery("from User where email = :username and password = :password");
            else
                query = session.createQuery("from User where username = :username and password = :password");
            query.setParameter("username",username);
            query.setParameter("password",password);
            List<User> userList = query.list();
            return userList.get(0);
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (session!=null && session.isOpen())
                session.close();
        }

        return null;
    }

    public User updateUser(User user){
        if (Helper.sessionFactory == null)
            Helper.init();
        Session session = Helper.sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(user);
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
    
    public User addUser(User user){
        if (Helper.sessionFactory == null)
            Helper.init();
        Session session = Helper.sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
        }
        finally {
            if (session!=null && session.isOpen())
                session.close();
        }
        return user;
    }
    
    public boolean deleteUser(User user){
        if (Helper.sessionFactory == null)
            Helper.init();
        Session session = Helper.sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
            return false;
        }
        finally {
            if (session!=null && session.isOpen())
                session.close();
        }
        return true;
    }

    public List<String> findUser(String subString){
        // TODO: 3/2/2016
        return null;
    }
}
