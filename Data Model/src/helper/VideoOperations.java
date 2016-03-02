package helper;

import entities.Video;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by ghalib on 2/10/2016.
 */
public class VideoOperations {
    public List<Video> getQuestionByVideo(String courseId){
        if (Helper.sessionFactory == null)
            Helper.init();
        Session session = Helper.sessionFactory.openSession();
        try {
            Query query = session.createQuery("from Video where courseId = :courseId");
            query.setParameter("courseId",courseId);
            return query.list();
        }catch (Exception e){

        }
        finally {
            if (session!=null && session.isOpen())
                session.close();
        }
        return null;
    }
}
