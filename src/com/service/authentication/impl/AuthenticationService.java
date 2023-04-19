package com.service.authentication.impl;

import com.commons.Messages;
import com.commons.HttpStatusCode;
import com.commons.Session;
import com.model.User;
import com.service.authentication.interfaces.IAuthenticationService;
import com.validations.ValidationException;

import java.util.HashMap;

public class AuthenticationService implements IAuthenticationService {
    private static AuthenticationService instance;
    private HashMap<String, User> userHashMap;

    private AuthenticationService() {
        userHashMap = new HashMap<>();
    }

    public static AuthenticationService getInstance() {
        if (instance == null) {
            synchronized (AuthenticationService.class) {
                if (instance == null) {
                    instance = new AuthenticationService();
                }
            }
        }
        return instance;
    }

    @Override
    public User login(String userId, String password, Session session) {
        if(session.getLoggedInUser()!=null && session.getLoggedInUser().getUserName().equals(userId)){
            System.out.println("You are already loggedIn...");
            return null;
        }
        if (userId == null || userId.isEmpty() || password == null || password.isEmpty()) {
            System.out.println(Messages.USER_PASSWORD_NOT_NULL);
        }

        if(!userHashMap.containsKey(userId)){
            System.out.println(Messages.USER_NOT_FOUND);
        }
        else{
            User user = userHashMap.get(userId);
            if(!user.getPassword().equals(password)){
                System.out.println(Messages.INCORRECT_PASSWORD);
            }
            session.setLoggedInUser(user);
            System.out.println(Messages.LOGIN_SUCCESSFUL);
            return user;
        }
        return null;
    }

    @Override
    public void signup(String userId, String password, Session session) {
        if(session.getLoggedInUser()!=null && session.getLoggedInUser().getUserName().equals(userId)){
            System.out.println("You are already loggedIn...");
            return ;
        }

        if (userId == null || userId.isEmpty() || password == null || password.isEmpty()) {
            throw new ValidationException(Messages.USER_PASSWORD_NOT_NULL);
        }
        if(userHashMap.containsKey(userId)){
            throw new ValidationException(HttpStatusCode.CONFLICT, Messages.USER_ALREADY_EXISTS + userId);
        }
        else{
            User newUser = new User(userId, password);
            userHashMap.put(userId, newUser);
            System.out.println(Messages.SIGN_UP_SUCCESSFUL);
        }
    }
}
