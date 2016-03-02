package org.tuthub.api.resources;




import helper.UserOperation;
import entities.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Root resource (exposed at "users" path)
 */

@Path("users")
@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
public class UserResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "application/xml or application/json" media type.
     *
     * @return String that will be returned as a application/xml or application/json response.
     */

    @GET
    public User getUser(@QueryParam("username") String username, @QueryParam("password") String password){
        UserOperation userOperation = new UserOperation();
        User user = userOperation.getUser(username,password);
        return user;
    }

    //for restricted access and User Search access
    @GET
    @Path("/{username}")
    public User getUser(@PathParam("username") String username){
        // TODO: 2/27/2016  
        return new User();
    }

    @GET
    @Path("search/{username}")
    public List<User> getUsers(@QueryParam("start") int start,
                               @QueryParam("size") int size,
                               @PathParam("username") String username){
        // TODO: 2/27/2016  
        return null;
    }

    @POST
    @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public User addUser(User user){
        // TODO: 2/27/2016  
        return user;
    }

    @PUT
    @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public User updateUser(User user){
        // TODO: 2/27/2016  
        return null;
    }

    @DELETE
    @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public void deleteUser(User user){
        // TODO: 2/27/2016  
    }

    @GET
    @Path("{userid}/courses")
    public CourseResouce getCourse(){
        return new CourseResouce();
    }
}
