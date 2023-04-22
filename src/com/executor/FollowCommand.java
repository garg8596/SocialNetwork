package com.executor;

import com.command.Command;
import com.commons.Session;
import com.controller.UserController;
import com.model.User;

public class FollowCommand extends Command {
    UserController userController;

    public FollowCommand(){
        this.userController = new UserController();
    }
    @Override
    public void execute(String[] args, Session session) {
        String userName = args[0];
        userController.follow(userName, session);
    }
}
