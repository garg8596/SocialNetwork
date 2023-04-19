package com.command;

import com.commons.Session;
import com.controller.UserController;
import com.validations.InputValidator;

public class SignUpCommand extends Command{
    UserController userController;

    public SignUpCommand(){
        this.userController = new UserController();
    }

    @Override
    public void execute(String[] args, Session session) {
        InputValidator.validateLoginAttempts(args);
        String userId = args[0];
        String userPassword = args[1];
        userController.signup(userId, userPassword, session);
    }
}
