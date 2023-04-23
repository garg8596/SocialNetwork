package com.service.authentication.impl;

import com.commons.Messages;
import com.commons.Session;
import com.db.UserDatabase;
import com.model.User;
import com.service.authentication.interfaces.IAuthenticationService;
import com.validations.ValidationException;

import java.util.HashMap;

import static com.commons.Messages.PROVIDE_CORRECT_CREDENTIALS;

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
    public void login(String userId, String password, Session session) {
        if(session.getLoggedInUser()!=null && !session.getLoggedInUser().getUserName().equals(userId)){
            System.out.println(Messages.OTHER_LOGIN);
            return ;
        }
        if(session.getLoggedInUser()!=null && session.getLoggedInUser().getUserName().equals(userId)) {
            System.out.println(Messages.ALREADY_LOGIN);
            return;
        }
        if (userId == null || userId.isEmpty() || password == null || password.isEmpty()) {
            System.out.println(Messages.USER_PASSWORD_NOT_NULL);
            return;
        }
        if(!userHashMap.containsKey(userId)){
            System.out.println(Messages.USER_NOT_FOUND);
        }else{
            User user = userHashMap.get(userId);
            if(!user.getPassword().equals(password)){
                System.out.println(Messages.INCORRECT_PASSWORD);
            }
            else{
                session.setLoggedInUser(user);
                System.out.println(Messages.LOGIN_SUCCESSFUL);
            }
        }
    }

    @Override
    public void signup(String userId, String password, Session session) {
        if(session.getLoggedInUser()!=null && session.getLoggedInUser().getUserName().equals(userId)){
            System.out.println(Messages.ALREADY_LOGIN);
            return ;
        }
        if(session.getLoggedInUser()!=null && !session.getLoggedInUser().getUserName().equals(userId)){
            System.out.println(Messages.OTHER_LOGIN_SIGN_UP);
            return ;
        }
        if (userId == null || userId.isEmpty() || password == null || password.isEmpty()) {
            System.out.println(PROVIDE_CORRECT_CREDENTIALS);
        }
        if(userHashMap.containsKey(userId)){
            System.out.println(Messages.USER_ALREADY_EXISTS + userId);
        }
        else{
            User newUser = new User(userId, password);
            userHashMap.put(userId, newUser);
            UserDatabase.getInstance().addUser(newUser);
            System.out.println(Messages.SIGN_UP_SUCCESSFUL);
        }
    }
}
