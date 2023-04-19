package com.command;

import com.commons.Session;
import com.controller.UserController;
import com.validations.InputValidator;

public class LoginCommand extends Command{
    UserController userController;

    public LoginCommand(){
        this.userController = new UserController();
    }

    @Override
    public void execute(String[] args, Session session) {
        InputValidator.validateLoginAttempts(args);
        String userId = args[0];
        String userPassword = args[1];
        userController.login(userId, userPassword, session);
    }
}
