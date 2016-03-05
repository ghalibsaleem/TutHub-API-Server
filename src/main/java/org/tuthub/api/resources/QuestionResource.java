package org.tuthub.api.resources;

import entities.Question;
import helper.QuestionOperations;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ghalib on 2/27/2016.
 *
 */
@Path("/")
public class QuestionResource {
    @GET
    public List<Question> getQuestions(@PathParam("questions") String videoId){
        if (videoId!=null){
            QuestionOperations questionOperations = new QuestionOperations();
            return questionOperations.getQuestionByVideo(videoId);
        }
        return new ArrayList<Question>();
    }
    @POST
    public Question addQuestion(){

        return null;
    }
}
