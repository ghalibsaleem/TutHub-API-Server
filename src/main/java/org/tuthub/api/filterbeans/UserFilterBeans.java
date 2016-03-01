package org.tuthub.api.filterbeans;

import javax.ws.rs.QueryParam;

/**
 * Created by ghalib on 2/25/2016.
 */
public class UserFilterBeans {
    @QueryParam("username") String username;
    @QueryParam("password") String password;
    @QueryParam("start") int start;
    @QueryParam("size") int size;
}
