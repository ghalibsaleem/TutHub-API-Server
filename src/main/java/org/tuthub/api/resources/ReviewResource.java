package org.tuthub.api.resources;

import entities.Review;
import helper.ReviewOperations;

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
public class ReviewResource {

    @GET
    public List<Review> getQuestions(@PathParam("courseId") String courseId){
        if (courseId!=null){
            ReviewOperations reviewOperations = new ReviewOperations();
            return reviewOperations.getReviewByCourse(courseId);
        }
        return new ArrayList<Review>();
    }

    @POST
    public Review addQuestion(Review review, @Context UriInfo uriInfo){
        if (uriInfo.getPath().contains("course")){
            ReviewOperations reviewOperations = new ReviewOperations();
            return reviewOperations.addReview(review);
        }
        return null;
    }
}
