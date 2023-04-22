package com.executor;

import com.command.Command;
import com.commons.Session;
import com.controller.AuthenticationController;
import com.controller.UserController;
import com.validations.InputValidator;

public class SignUpCommand extends Command {
    AuthenticationController authenticationController;

    public SignUpCommand(){
        this.authenticationController = new AuthenticationController();
    }

    @Override
    public void execute(String[] args, Session session) {
        InputValidator.validateLoginAttempts(args);
        String userId = args[0];
        String userPassword = args[1];
        authenticationController.signup(userId, userPassword, session);
    }
}
