package com.controller;

import com.commons.Session;
import com.model.User;
import com.service.authentication.impl.AuthenticationService;
import com.service.authentication.interfaces.IAuthenticationService;

public class UserController {
    IAuthenticationService authenticationService;

    public UserController(){
        authenticationService = AuthenticationService.getInstance();
    }
    public void login(String userId, String userPassword, Session session) {
        authenticationService.login(userId, userPassword, session);
    }

    public void signup(String userId, String userPassword, Session session){
        authenticationService.signup(userId, userPassword, session);
    }
}
