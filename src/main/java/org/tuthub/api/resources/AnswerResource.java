package org.tuthub.api.resources;

import entities.Answer;
import helper.AnswerOperations;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ghalib on 2/27/2016.
 *
 */
@Path("/")
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class AnswerResource {
    @GET
    public List<Answer> getAnswers(@PathParam("questionId") String questionId){
        if (questionId !=null){
            AnswerOperations answerOperations = new AnswerOperations();
            return answerOperations.getAnswersByQuestion(questionId);
        }
        return new ArrayList<Answer>();
    }

    @POST
    public Answer addAnswer(Answer answer, @Context UriInfo uriInfo){
        if (uriInfo.getPath().contains("questions")){
            AnswerOperations answerOperations = new AnswerOperations();
            return answerOperations.addAnswer(answer);
        }
        return null;
    }
}
