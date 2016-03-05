package helper;

import entities.Course;
import entities.Tutor;
import entities.User;
import entities.UserCourseRel;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ghalib on 2/10/2016.
 * Course Operation
 */
public class CourseOperations {

    public Course addCourse(Course course,Tutor tutor) {
        if (Helper.sessionFactory == null)
            Helper.init();
        Session session = Helper.sessionFactory.openSession();
        try {
            TutorOperations tutorOperations = new TutorOperations();
            if (tutorOperations.tutorLogin(tutor.getTutorId(),tutor.getPassword())){
                course.setTutor(tutor);
                session.beginTransaction();
                session.save(course);
                session.getTransaction().commit();
                return course;
            }
        }catch (Exception e){
            session.getTransaction().rollback();
        }
        finally {
            if (session!=null && session.isOpen())
                session.close();
        }
        return null;
    }

    public Course updateCourse(Course course,Tutor tutor) {
        if (Helper.sessionFactory == null)
            Helper.init();
        Session session = Helper.sessionFactory.openSession();
        try {
            TutorOperations tutorOperations = new TutorOperations();
            if (tutorOperations.tutorLogin(tutor.getTutorId(),tutor.getPassword())){
                course.setTutor(tutor);
                session.beginTransaction();
                session.update(course);
                session.getTransaction().commit();
                return course;
            }
        }catch (Exception e){
            session.getTransaction().rollback();
        }
        finally {
            if (session!=null && session.isOpen())
                session.close();
        }
        return null;
    }

    public Course deleteCourse(Course course,Tutor tutor) {
        if (Helper.sessionFactory == null)
            Helper.init();
        Session session = Helper.sessionFactory.openSession();
        try {
            TutorOperations tutorOperations = new TutorOperations();
            if (tutorOperations.tutorLogin(tutor.getTutorId(),tutor.getPassword())){
                course.setTutor(tutor);
                session.beginTransaction();
                session.delete(course);
                session.getTransaction().commit();
                return course;
            }
        }catch (Exception e){
            session.getTransaction().rollback();
        }
        finally {
            if (session!=null && session.isOpen())
                session.close();
        }
        return null;
    }

    public Course getById(String id){
        if (Helper.sessionFactory == null)
            Helper.init();
        Session session = Helper.sessionFactory.openSession();
        try {
            session.beginTransaction();
            return (Course) session.get(Course.class,id);
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            if (session!=null && session.isOpen())
                session.close();
        }
        return null;
    }

    public List<Course> getByName(String subString){
        if (Helper.sessionFactory == null)
            Helper.init();
        Session session = Helper.sessionFactory.openSession();
        try {
            Query query = session.createQuery("from Course where name like :param").setParameter("param","%"+subString+"%");
            return query.list();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (session!=null && session.isOpen())
                session.close();
        }
        return null;
    }

    public List<Course> getCoursesByTutor(String tutor_id){
        if (Helper.sessionFactory == null)
            Helper.init();
        Session session = Helper.sessionFactory.openSession();
        try {
            Query query = session.createQuery("from Tutor where tutorId = :tutorid");
            query.setParameter("tutorid",tutor_id);
            Tutor tutor = (Tutor) query.uniqueResult();
            return tutor!= null ? tutor.getCourses():null;
        }catch (Exception e){

        }
        finally {
            if (session!=null && session.isOpen())
                session.close();
        }
        return null;
    }

    public List<Course> getCoursesByUser(String username){
        if (Helper.sessionFactory == null)
            Helper.init();
        Session session = Helper.sessionFactory.openSession();
        try {
            Query query = session.createQuery("from User where username = :username");
            query.setParameter("username",username);
            User user = (User) query.uniqueResult();
            List<UserCourseRel> userCourseRelList = user.getUser_course_rels();
            List<Course> courseList = new ArrayList<>();
            for (UserCourseRel userCourseRel:userCourseRelList) {
                courseList.add(userCourseRel.getCourse());
            }
            return courseList;
        }catch (Exception e){
            e.printStackTrace();
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
            Query query = session.createQuery("from Course where tags like in (:tags)");
            String finaltag = "";
            for (String tag:tags) {
                finaltag += "%"+tag+"%,";
            }
            finaltag  = finaltag.substring(0,finaltag.length()-2);
            query.setParameter("tags",finaltag);
            return query.list();
        }catch (Exception e){

        }finally {
            if (session!=null && session.isOpen())
                session.close();
        }
        return null;
    }

    public List<Course> getCoursesByType(String type){
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
