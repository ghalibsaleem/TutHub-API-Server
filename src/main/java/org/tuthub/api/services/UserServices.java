package org.tuthub.api.services;



import helper.UserOperation;
import entities.User;

/**
 * Created by ghali on 2/24/2016.
 */

public class UserServices {
    public User getUser(){
        UserOperation userOperation = new UserOperation();
        return userOperation.getUser("ghaliblucky","ghalib.123");

    }
}
