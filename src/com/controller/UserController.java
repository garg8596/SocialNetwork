package com.controller;

import com.commons.Messages;
import com.commons.Session;
import com.model.User;
import com.service.user.Impl.UserService;
import com.service.user.interfaces.IUserService;

import java.util.Map;

public class UserController {
    IUserService userService;

    public UserController(){
        userService = new UserService();
    }

    public void follow(String userName, Session session) {
        User currentUser = session.getLoggedInUser();
        if(currentUser==null){
            System.out.println(Messages.LOGIN_FOLLOW + userName);
        }
        else{
            userService.follow(userName, currentUser);
        }

    }

    public void showProfile(Session session) {
        User currentUser = session.getLoggedInUser();
        if(currentUser==null){
            System.out.println(Messages.LOGIN_TO_SEE_PROFILE);
        }
        else{
            userService.showProfile(currentUser);
        }

    }
}
