package helper;

import entities.Course;
import entities.Video;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by ghalib on 2/10/2016.
 */
public class VideoOperations {
    public List<Video> getVideoByCourse(String courseId){
        if (Helper.sessionFactory == null)
            Helper.init();
        Session session = Helper.sessionFactory.openSession();
        try {
            Query query = session.createQuery("from Course where courseId = :courseId");
            query.setParameter("courseId",courseId);
            Course course = (Course) query.uniqueResult();
            return course.getVideos();
        }catch (Exception e){

        }
        finally {
            if (session!=null && session.isOpen())
                session.close();
        }
        return null;
    }
}
