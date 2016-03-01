package org.tuthub.api.resources;

import models.Tutor;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by ghalib on 2/26/2016.
 */
@Path("tutors")
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class TutorResource {

    @GET
    @Path("{tutorid}")
    public Tutor getTutor(){
        // TODO: 2/27/2016
        return null;
    }

    @POST
    public Tutor loginTutor(Tutor tutor){
        // TODO: 2/27/2016
        return null;
    }

    @POST
    @Path("{tutorid}")
    public Tutor updateTutor(@PathParam("tutorid") String tutorid,Tutor tutor){
        // TODO: 2/27/2016  
        return null;
    }

    @PUT
    public Tutor addTutor(Tutor tutor){
        // TODO: 2/27/2016
        return null;
    }

    @DELETE
    public void deleteTutor(Tutor tutor){
        // TODO: 2/27/2016
    }

    @GET
    @Path("{tutorid}/courses")
    public CourseResouce getCourse(){
        return new CourseResouce();
    }
}
