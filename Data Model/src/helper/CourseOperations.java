package helper;

import entities.Course;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by ghalib on 2/10/2016.
 */
public class CourseOperations {

    public List<Course> getCoursesFromTutuor(String tutor_id){
        if (Helper.sessionFactory == null)
            Helper.init();
        Session session = Helper.sessionFactory.openSession();
        try {
            Query query = session.createQuery("from Course where tutorId = :tutorid");
            query.setParameter("tutorid",tutor_id);
            return query.list();
        }catch (Exception e){

        }
        finally {
            if (session!=null && session.isOpen())
                session.close();
        }
        return null;
    }

    public List<Course> getCoursesByTags(String... tags){
        if (Helper.sessionFactory == null)
            Helper.init();
        Session session = Helper.sessionFactory.openSession();
        try {
            Query query = session.createQuery("from Course where tutorId = :tutorid");
            // FIXME: 3/2/2016
            query.setParameter("tutorid",tags[0]);
            return query.list();
        }catch (Exception e){

        }finally {
            if (session!=null && session.isOpen())
                session.close();
        }
        return null;
    }

    public List<Course> getCousesByType(String type){
        if (Helper.sessionFactory == null)
            Helper.init();
        Session session = Helper.sessionFactory.openSession();
        try {
            Query query = session.createQuery("from Course where type = :type");
            query.setParameter("type",type);
            return query.list();
        }catch (Exception e){

        }finally {
            if (session!=null && session.isOpen())
                session.close();
        }
        return null;
    }

    public List<Course> getCoursesByCertification(){
        if (Helper.sessionFactory == null)
            Helper.init();
        Session session = Helper.sessionFactory.openSession();
        try {
            Query query = session.createQuery("from Course where isCertification = :is");
            query.setParameter("is",1);
            return query.list();
        }catch (Exception e){

        }finally {
            if (session!=null && session.isOpen())
                session.close();
        }
        return null;
    }

    public List<Course> getCoursesByVerification(){
        if (Helper.sessionFactory == null)
            Helper.init();
        Session session = Helper.sessionFactory.openSession();
        try {
            Query query = session.createQuery("from Course where isVerified = :is");
            query.setParameter("is",1);
            return query.list();
        }catch (Exception e){

        }finally {
            if (session!=null && session.isOpen())
                session.close();
        }
        return null;
    }
}
