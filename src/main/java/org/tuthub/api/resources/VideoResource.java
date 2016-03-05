package org.tuthub.api.resources;

import entities.Tutor;
import entities.User;
import entities.Video;
import helper.VideoOperations;
import org.tuthub.api.authorizationmodel.TutorVideo;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import java.util.List;

/**
 * Created by ghalib on 2/27/2016.
 * all the video resources
 */
@Path(value = "/")
public class VideoResource {

    @GET
    public List<Video> getVideos(@PathParam("courseId") String courseId){
        if (courseId != null){
            VideoOperations videoOperations = new VideoOperations();
            return videoOperations.getVideoByCourse(courseId);
        }
        return null;
    }

    @POST
    @Path("{videoId}")
    public Video getVideo(@PathParam("videoId") String videoId, User user , @Context UriInfo uriInfo){
        if (uriInfo.getPath().contains("courses")){
            VideoOperations videoOperations = new VideoOperations();
            return videoOperations.getByID(videoId,user,null);
        }
        return null;
    }

    @POST
    @Path("tutor/{videoId}")
    public Video getVideo(@PathParam("videoId") String videoId, Tutor tutor , @Context UriInfo uriInfo){
        if (uriInfo.getPath().contains("courses")){
            VideoOperations videoOperations = new VideoOperations();
            return videoOperations.getByID(videoId,null,tutor);
        }
        return null;
    }

    @POST
    public Video addVideo(TutorVideo tutorVideo, @Context UriInfo uriInfo){
        if (uriInfo.getPath().contains("video")){
            VideoOperations videoOperations = new VideoOperations();
            return videoOperations.addVideo(tutorVideo.getVideo(),tutorVideo.getTutor());
        }
        return null;
    }

    @PUT
    public Video updateVideo(TutorVideo tutorVideo, @Context UriInfo uriInfo){
        if (uriInfo.getPath().contains("video")){
            VideoOperations videoOperations = new VideoOperations();
            return videoOperations.updateVideo(tutorVideo.getVideo(),tutorVideo.getTutor());
        }
        return null;
    }

    @DELETE
    public void deleteVideo(TutorVideo tutorVideo, @Context UriInfo uriInfo){
        if (uriInfo.getPath().contains("video")){
            VideoOperations videoOperations = new VideoOperations();
            videoOperations.deleteVideo(tutorVideo.getVideo(),tutorVideo.getTutor());
        }
    }

    @Path("/question")
    public QuestionResource getQuestion(){
        return new QuestionResource();
    }
}
