package helper;

import entities.Course;
import entities.Review;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by ghalib on 3/3/2016.
 *
 */
public class ReviewOperations {
    public List<Review> getReviewByCourse(String courseId){
        if (Helper.sessionFactory == null)
            Helper.init();
        Session session = Helper.sessionFactory.openSession();
        try {
            Query query = session.createQuery("from Course where courseId = :courseId");
            query.setParameter("courseId",courseId);
            Course course = (Course) query.uniqueResult();
            return course.getReviews();
        }catch (Exception e){

        }
        finally {
            if (session!=null && session.isOpen())
                session.close();
        }
        return null;
    }

    public Review addReview(Review review){
        if (Helper.sessionFactory == null)
            Helper.init();
        Session session = Helper.sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.save(review);
            session.getTransaction().commit();
            return review;
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            if (session!=null && session.isOpen())
                session.close();
        }
        return null;
    }
}
