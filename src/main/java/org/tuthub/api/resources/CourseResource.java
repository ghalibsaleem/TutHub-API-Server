package org.tuthub.api.resources;

import entities.Course;
import helper.CourseOperations;
import org.tuthub.api.authorizationmodel.AuthCourse;
import org.tuthub.api.filterbeans.CourseFilterBean;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by ghalib on 2/26/2016.
 */
@Path("/{a:courses|}")
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class CourseResource {

    @GET
    @Path("/{courseid}")
    public Course getCourse(@PathParam("courseid") String courseid,@BeanParam CourseFilterBean courseFilterBean){
        if (courseFilterBean != null && (courseFilterBean.getTutorId() != null
                || courseFilterBean.getUsername()!= null
                || courseFilterBean.getUriInfo().getPath().contains("courses"))){
            CourseOperations courseOperations = new CourseOperations();
            return courseOperations.getById(courseid);
        }
        return null;
    }

    @GET
    public List<Course> getCourseByUserOrTuror(
            @PathParam("username") String username,
            @PathParam("tutorId") String tutorId){
        if (username != null){
            CourseOperations courseOperations = new CourseOperations();
            return courseOperations.getCoursesByUser(username);
        }else if (tutorId != null){
            CourseOperations courseOperations = new CourseOperations();
            return courseOperations.getCoursesByTutor(tutorId);
        }
        return null;
    }

    @GET
    @Path("courses/search/{queryString}")
    public List<Course> getCourseBySearch(@PathParam("queryString") String queryString){
        CourseOperations courseOperations = new CourseOperations();
        return courseOperations.getByName(queryString);
    }

    @POST
    public Course updateCourse(AuthCourse authCourse, @BeanParam CourseFilterBean courseFilterBean)
    {
        if (courseFilterBean != null && courseFilterBean.getTutorId() != null){
            CourseOperations courseOperations = new CourseOperations();
            return courseOperations.updateCourse(authCourse.getCourse(),authCourse.getTutor());
        }
        return null;
    }

    @PUT
    public Course addCourse(AuthCourse authCourse,@BeanParam CourseFilterBean courseFilterBean){
        if (courseFilterBean != null && courseFilterBean.getTutorId() != null){
            CourseOperations courseOperations = new CourseOperations();
            return courseOperations.addCourse(authCourse.getCourse(),authCourse.getTutor());
        }
        return null;
    }

    @DELETE
    public  void deleteCourse(AuthCourse authCourse,@BeanParam CourseFilterBean courseFilterBean){
        if (courseFilterBean != null && courseFilterBean.getTutorId() != null){
            CourseOperations courseOperations = new CourseOperations();
            courseOperations.deleteCourse(authCourse.getCourse(),authCourse.getTutor());
        }
    }

    @Path("{courseId}/videos")
    public VideoResource getVideos(){
        return new VideoResource();
    }

    @Path("{courseId}/reviews")
    public ReviewResource getReviews(){
        return new ReviewResource();
    }
}
