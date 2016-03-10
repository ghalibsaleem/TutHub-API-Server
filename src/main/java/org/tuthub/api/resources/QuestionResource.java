package org.tuthub.api.resources;

import entities.Answer;
import entities.Question;
import helper.QuestionOperations;

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
public class QuestionResource {
    @GET
    public List<Question> getQuestions(@PathParam("videoId") String videoId){
        if (videoId!=null){
            QuestionOperations questionOperations = new QuestionOperations();
            return questionOperations.getQuestionByVideo(videoId);
        }
        return new ArrayList<Question>();
    }

    @POST
    public Question addQuestion(Question question, @Context UriInfo uriInfo){
        if (uriInfo.getPath().contains("questions")){
            QuestionOperations questionOperations = new QuestionOperations();
            return questionOperations.addQuestion(question);
        }
        return null;
    }

    @Path("{questionId}/answers")
    public AnswerResource getAnswers(){return new AnswerResource();}
}
