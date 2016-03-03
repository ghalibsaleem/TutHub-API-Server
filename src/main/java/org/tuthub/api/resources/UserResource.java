package org.tuthub.api.resources;




import entities.restricted.RestrictedUser;
import helper.DatabaseOperation;
import entities.User;

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

    @GET
    public User getUser(@QueryParam("username") String username, @QueryParam("password") String password){
        //UserOperation userOperation = new UserOperation();
        //User user = userOperation.getUser(username,password);
        DatabaseOperation<User> userDatabaseOperation = new DatabaseOperation<User>(User.class);
        User user = userDatabaseOperation.login(username,password);
        return user;
    }

    //for restricted access and User Search access
    @GET
    @Path("/{username}")
    public RestrictedUser getUser(@PathParam("username") String username){
        DatabaseOperation<User> userDatabaseOperation = new DatabaseOperation<User>(User.class);
        RestrictedUser user = new RestrictedUser(userDatabaseOperation.getbyID(username));
        return user;
    }

    @GET
    @Path("search/{username}")
    public List<RestrictedUser> getUsers(@QueryParam("start") int start,
                               @QueryParam("size") int size,
                               @PathParam("username") String username){
        // TODO: 2/27/2016  
        return null;
    }

    @POST
    public User addUser(User user){
        DatabaseOperation<User> userDatabaseOperation = new DatabaseOperation<User>(User.class);
        userDatabaseOperation.add(user);
        return user;
    }

    @PUT
    public User updateUser(User user){
        DatabaseOperation<User> userDatabaseOperation = new DatabaseOperation<User>(User.class);
        userDatabaseOperation.update(user);
        return user;
    }

    @DELETE
    public void deleteUser(User user){
        DatabaseOperation<User> userDatabaseOperation = new DatabaseOperation<User>(User.class);
        userDatabaseOperation.delete(user);
    }


    @Path("{userId}/courses")
    public CourseResource getCourse(){

        return new CourseResource();
    }
}
