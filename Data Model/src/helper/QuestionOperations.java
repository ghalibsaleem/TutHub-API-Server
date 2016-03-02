package helper;

import entities.Question;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by ghalib on 3/3/2016.
 */
public class QuestionOperations {
    public List<Question> getQuestionByVideo(String videoId){
        if (Helper.sessionFactory == null)
            Helper.init();
        Session session = Helper.sessionFactory.openSession();
        try {
            Query query = session.createQuery("from Question where videoId = :videoId");
            query.setParameter("videoId",videoId);
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
