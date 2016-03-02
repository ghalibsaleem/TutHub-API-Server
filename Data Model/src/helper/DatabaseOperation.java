package helper;

import entities.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.usertype.ParameterizedType;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;

/**
 * Created by ghalib on 3/2/2016.
 */
public class DatabaseOperation<T extends Object> {
    private final Class<T> type;
    public DatabaseOperation(Class<T> type) {
        this.type = type;
    }
    public T add(T t){
        if (Helper.sessionFactory == null)
            Helper.init();
        Session session = Helper.sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(t);
            session.getTransaction().commit();
            return t;
        }catch (Exception e){
            session.getTransaction().rollback();
        }
        finally {
            if (session!=null && session.isOpen())
                session.close();
        }
        return null;
    }

    public T update(T t){
        if (Helper.sessionFactory == null)
            Helper.init();
        Session session = Helper.sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(t);
            session.getTransaction().commit();
            return t;
        }catch (Exception e){
            session.getTransaction().rollback();
        }
        finally {
            if (session!=null && session.isOpen())
                session.close();
        }
        return null;
    }

    public boolean delete(T t){
        if (Helper.sessionFactory == null)
            Helper.init();
        Session session = Helper.sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(t);
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


    /**
     *This method is only for User or Tutor class. If anything called by another type of class then it will return null
     * @param username username, tutor id, email
     * @param password as name described give me passsword
     * @return
     */
    public T login(String username, String password){
        if (Helper.sessionFactory == null)
            Helper.init();
        Session session = Helper.sessionFactory.openSession();
        try {

            Query query = null;
            if(User.class == type){
                if (username.contains("@"))
                    query = session.createQuery("from User where email = :username and password = :password");
                else
                    query = session.createQuery("from User where username = :username and password = :password");
            }else
                if (Tutor.class == type){
                    if (username.contains("@"))
                        query = session.createQuery("from Tutor where email = :username and password = :password");
                    else
                        query = session.createQuery("from Tutor where tutorId = :username and password = :password");
                }else return null;

            query.setParameter("username",username);
            query.setParameter("password",password);
            List<T> userList = query.list();
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

    public T getbyID(String id){
        if (Helper.sessionFactory == null)
            Helper.init();
        Session session = Helper.sessionFactory.openSession();
        try{
            Query query = getQueryForID(id);
            return (T)query.uniqueResult();
        }catch (Exception e){
           e.printStackTrace();
        }finally {
            if (session!=null && session.isOpen())
                session.close();
        }
        return null;
    }
    private Query getQueryForID(String id){
        if (Helper.sessionFactory == null)
            Helper.init();
        Session session = Helper.sessionFactory.openSession();
        Query query = null;
        if(Answer.class == type){
            return session.createQuery("from Answer where answerId = :param").setParameter("param",id);
        }
        if(Course.class == type){
            return session.createQuery("from Course where courseId = :param").setParameter("param",id);
        }
        if(Question.class == type){
            return session.createQuery("from Question where questionId = :param").setParameter("param",id);
        }
        if(Review.class == type){
            return session.createQuery("from Review where reviewsId = :param").setParameter("param",id);
        }
        if(Tutor.class == type){
            return session.createQuery("from Tutor where tutorId = :param").setParameter("param",id);
        }
        if(User.class == type){
            return session.createQuery("from User where username = :param").setParameter("param",id);
        }
        if(Video.class == type){
            return session.createQuery("from Video where videoId = :param").setParameter("param",id);
        }
        return null;
    }

    public List<T> getByName(String name){
        try{
            Query query = getQueryForName(name);
            return query.list();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    private Query getQueryForName(String name){
        if (Helper.sessionFactory == null)
            Helper.init();
        Session session = Helper.sessionFactory.openSession();
        Query query = null;

        if(Course.class == type){
            return session.createQuery("from Course where name like :param").setParameter("param","%"+name+"%");
        }
        if(Question.class == type){
            return session.createQuery("from Question where data like :param").setParameter("param","%"+name+"%");
        }

        if(Tutor.class == type){
            return session.createQuery("from Tutor where name like :param").setParameter("param","%"+name+"%");
        }
        if(User.class == type){
            return session.createQuery("from User where name like :param").setParameter("param","%"+name+"%");
        }
        return null;
    }
}
