package org.tuthub.api.resources;

import entities.Tutor;
import entities.restricted.RestrictedTutor;
import helper.TutorOperations;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by ghalib on 2/26/2016.
 *
 */
@Path("tutors")
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class TutorResource {

    @GET
    @Path("{tutorId}")
    public RestrictedTutor getTutor(@PathParam("tutorId") String tutorId){
        TutorOperations tutorOperations = new TutorOperations();
        return new RestrictedTutor(tutorOperations.getById(tutorId));
    }

    @GET
    @Path("search/{tutorId}")
    public List<Tutor> getTutors(@QueryParam("start") int start,
                               @QueryParam("size") int size,
                               @PathParam("tutorId") String tutorId){
        TutorOperations tutorOperations = new TutorOperations();
        return tutorOperations.getByName(tutorId);
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Tutor getTutor(@FormParam("tutorId") String tutorId, @FormParam("password") String password){
        TutorOperations tutorOperations = new TutorOperations();
        return tutorOperations.getTutor(tutorId,password);
    }

    @POST
    @Path("{tutorId}")
    public Tutor updateTutor(@PathParam("tutorId") String tutorId,Tutor tutor){
        TutorOperations tutorOperations = new TutorOperations();
        return tutorOperations.updateTutor(tutor);
    }

    @PUT
    public Tutor addTutor(Tutor tutor){
        TutorOperations tutorOperations = new TutorOperations();
        return tutorOperations.addTutor(tutor);
    }

    @DELETE
    @Path("{tutorId}")
    public void deleteTutor(@PathParam("tutorId") String tutorId,Tutor tutor){
        TutorOperations tutorOperations = new TutorOperations();
        tutorOperations.deleteTutor(tutor);
    }

    @Path("{tutorId}/courses")
    public CourseResource getCourse(){
        return new CourseResource();
    }
}
