package org.tuthub.api.filterbeans;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 * Created by ghalib on 3/4/2016.
 *
 */
public class CourseFilterBean {
    @PathParam("userId")
    private String username = null;
    @PathParam("tutorId")
    private String tutorId = null;
    @Context
    private UriInfo uriInfo;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTutorId() {
        return tutorId;
    }

    public void setTutorId(String tutorId) {
        this.tutorId = tutorId;
    }

    public UriInfo getUriInfo() {
        return uriInfo;
    }

    public void setUriInfo(UriInfo uriInfo) {
        this.uriInfo = uriInfo;
    }
}
