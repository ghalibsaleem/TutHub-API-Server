package org.tuthub.api.services;



import entities.User;
import helper.UserOperation;

/**
 * Created by ghalib on 2/24/2016.
 *
 */

public class UserServices {
    public User getUser(){
        UserOperation userOperation = new UserOperation();
        return userOperation.getUser("ghaliblucky","ghalib.123");

    }
}
