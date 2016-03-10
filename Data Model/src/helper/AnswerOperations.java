package helper;

import entities.Answer;
import entities.Question;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by ghalib on 3/3/2016.
 *
 */
public class AnswerOperations {
    public List<Answer> getAnswersByQuestion(String questionid){
        if (Helper.sessionFactory == null)
            Helper.init();
        Session session = Helper.sessionFactory.openSession();
        try {
            Query query = session.createQuery("from Question where questionId= :questionId");
            query.setParameter("questionId",questionid);
            Question question= (Question) query.uniqueResult();
            return question.getAnswers();
        }catch (Exception e){

        }
        finally {
            if (session!=null && session.isOpen())
                session.close();
        }
        return null;
    }
}
