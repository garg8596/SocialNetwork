package com.executor;

import com.command.Command;
import com.commons.Session;
import com.controller.UserController;

public class ShowProfileCommand extends Command {

    UserController userController;
    public ShowProfileCommand(){
        this.userController = new UserController();
    }
    @Override
    public void execute(String[] args, Session session) {
        userController.showProfile(session);
    }
}
