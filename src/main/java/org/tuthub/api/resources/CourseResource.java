package org.tuthub.api.resources;

import entities.Course;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by ghalib on 2/26/2016.
 */
@Path("/{a:courses|}")
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class CourseResource {

    @GET
    @Path("/{courseid}")
    public Course getCourse(@PathParam("courseid") String courseid){
        // TODO: 2/27/2016
        return null;
    }

    @GET
    public Course getCourseByUserOrTuror(
            @PathParam("userId") String username,
            @PathParam("tutorId") String tutorId){
        if (username != null){

        }else if (tutorId != null){

        }
        // TODO: 2/27/2016
        return null;
    }

    @POST
    public Course updateCourse(Course course)
    {
        // TODO: 2/27/2016
        return null;
    }

    @PUT
    public Course addCourse(Course course){
        // TODO: 2/27/2016
        return null;
    }

    @DELETE
    public  void deleteCourse(Course course){

        // TODO: 2/27/2016
    }

    @GET
    @Path("{courseid}/videos")
    public VideoResource getVideos(){
        return new VideoResource();
    }

    @GET
    @Path("{courseid}/reviews")
    public ReviewResource getReviews(){
        return new ReviewResource();
    }
}
