package org.tuthub.api.resources;




import entities.User;
import entities.restricted.RestrictedUser;
import helper.UserOperation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Root resource (exposed at "users" path)
 */

@Path("users")
@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
public class UserResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "application/xml or application/json" media type.
     *
     * @return String that will be returned as a application/xml or application/json response.
     */

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public User login(@FormParam("username") String username, @FormParam("password") String password){
        UserOperation userOperation = new UserOperation();
        User user = userOperation.getUser(username,password);
        return user;
    }

    //for restricted access and User Search access
    @GET
    @Path("/{username}")
    public RestrictedUser getUser(@PathParam("username") String username){
        UserOperation userOperation = new UserOperation();
        RestrictedUser user = new RestrictedUser(userOperation.getById(username));
        return user;
    }

    @GET
    @Path("search/{username}")
    public List<User> getUsers(@QueryParam("start") int start,
                               @QueryParam("size") int size,
                               @PathParam("username") String username){
        UserOperation userOperation = new UserOperation();
        return userOperation.getByName(username);
    }


    @POST
    public User addUser(User user){
        UserOperation userOperation = new UserOperation();
        return userOperation.addUser(user);
    }

    @PUT
    @Path("{username}")
    public User updateUser(User user){
        UserOperation userOperation = new UserOperation();
        return userOperation.updateUser(user);
    }

    @DELETE
    @Path("{username}")
    public void deleteUser(User user){
        UserOperation userOperation = new UserOperation();
        userOperation.deleteUser(user);
    }


    @Path("{username}/courses")
    public CourseResource getCourse(){
        // FIXME: 3/5/2016 
        return new CourseResource();
    }
}
