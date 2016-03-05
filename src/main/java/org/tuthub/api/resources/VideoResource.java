package org.tuthub.api.resources;

import entities.Video;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

/**
 * Created by ghalib on 2/27/2016.
 */
@Path(value = "/")
public class VideoResource {

    @GET
    public List<Video> getVideos(){
        // TODO: 2/27/2016
        return null;
    }

    @GET
    @Path("{videoid}")
    public Video getVideo(@PathParam("videoid") String videoid){
        // TODO: 2/27/2016
        return null;
    }


}
