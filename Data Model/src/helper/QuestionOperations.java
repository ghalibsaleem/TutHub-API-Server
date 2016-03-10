package helper;

import entities.Question;
import entities.Video;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by ghalib on 3/3/2016.
 *
 */
public class QuestionOperations {
    public List<Question> getQuestionByVideo(String videoId){
        if (Helper.sessionFactory == null)
            Helper.init();
        Session session = Helper.sessionFactory.openSession();
        try {
            Query query = session.createQuery("from Video where videoId = :videoId");
            query.setParameter("videoId",videoId);
            Video video = (Video) query.uniqueResult();
            return video.getQuestions();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (session!=null && session.isOpen())
                session.close();
        }
        return null;
    }
    public Question addQuestion(Question question){
        if (Helper.sessionFactory == null)
            Helper.init();
        Session session = Helper.sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.save(question);
            session.getTransaction().commit();
            return question;
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
