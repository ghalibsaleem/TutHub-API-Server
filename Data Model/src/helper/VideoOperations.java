package helper;

import entities.Course;
import entities.Tutor;
import entities.User;
import entities.Video;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by ghalib on 2/10/2016.
 */
public class VideoOperations {
    public List<Video> getVideoByCourse(String courseId,ACCESS_TYPE access_type){
        if (Helper.sessionFactory == null)
            Helper.init();
        Session session = Helper.sessionFactory.openSession();
        try {
            Query query = session.createQuery("from Course where courseId = :courseId");
            query.setParameter("courseId",courseId);
            Course course = (Course) query.uniqueResult();
            List<Video> videoList = course.getVideos();
            if (access_type == ACCESS_TYPE.NONE || access_type == ACCESS_TYPE.TRAIL)
                for (Video video:videoList) {
                    video.setExcerciseUrl("");
                    video.setVideoUrl("");
                }
            return course.getVideos();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (session!=null && session.isOpen())
                session.close();
        }
        return null;
    }

    public Video getByID(String id, User user,Tutor tutor){
        if (Helper.sessionFactory == null)
            Helper.init();
        Session session = Helper.sessionFactory.openSession();
        try{
            if (user != null && (new UserOperation()).userLogin(user.getUsername(),user.getPassword()))
            {
                Query query = session.createQuery("from Video where videoId=:videoId and course in (from UserCourseRel where user =:user)");
                query.setParameter("videoId",Integer.parseInt(id));
                query.setParameter("user",user);
                return (Video) query.uniqueResult();
            }
            if (tutor!=null && (new TutorOperations()).tutorLogin(tutor.getTutorId(),tutor.getPassword()))
            {
                Query query = session.createQuery("from Video where videoId=:videoId and course.tutor in (from Tutor where tutorId =:tutorId)");
                query.setParameter("videoId",Integer.parseInt(id));
                query.setParameter("tutorId",tutor.getTutorId());
                return (Video) query.uniqueResult();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (session!=null && session.isOpen())
                session.close();
        }
        return null;
    }

    public Video getByID(String id){
        if (Helper.sessionFactory == null)
            Helper.init();
        Session session = Helper.sessionFactory.openSession();
        try {
            Query query = session.createQuery("from Video where videoId = :param").setParameter("param",Integer.parseInt(id));
            Video video = (Video) query.uniqueResult();
            video.setVideoUrl("");
            video.setExcerciseUrl("");
            return video;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (session!=null && session.isOpen())
                session.close();
        }
        return null;
    }

    public Video addVideo(Video video, Tutor tutor){
        if (Helper.sessionFactory == null)
            Helper.init();
        Session session = Helper.sessionFactory.openSession();
        try {
            TutorOperations tutorOperations = new TutorOperations();
            if (tutorOperations.tutorLogin(tutor.getTutorId(),tutor.getPassword())){
                session.beginTransaction();
                session.save(video);
                session.getTransaction().commit();
                return video;
            }
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        finally {
            if (session!=null && session.isOpen())
                session.close();
        }
        return null;
    }

    public Video updateVideo(Video video,Tutor tutor){
        if (Helper.sessionFactory == null)
            Helper.init();
        Session session = Helper.sessionFactory.openSession();
        try {
            TutorOperations tutorOperations = new TutorOperations();
            if (tutorOperations.tutorLogin(tutor.getTutorId(),tutor.getPassword())){
                session.beginTransaction();
                session.update(video);
                session.getTransaction().commit();
                return video;
            }
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        finally {
            if (session!=null && session.isOpen())
                session.close();
        }
        return null;
    }

    public boolean deleteVideo(Video video,Tutor tutor){
        if (Helper.sessionFactory == null)
            Helper.init();
        Session session = Helper.sessionFactory.openSession();
        try {
            TutorOperations tutorOperations = new TutorOperations();
            if (tutorOperations.tutorLogin(tutor.getTutorId(),tutor.getPassword())){
                session.beginTransaction();
                session.delete(video);
                session.getTransaction().commit();
                return true;
            }
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        finally {
            if (session!=null && session.isOpen())
                session.close();
        }
        return false;
    }
}
