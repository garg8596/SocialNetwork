package com.executor;

import com.command.Command;
import com.commons.Session;
import com.controller.FeedController;
import com.model.Post;
import com.model.User;

import java.util.UUID;

public class PostCommand extends Command {
    private FeedController feedController;

    public PostCommand(){
        this.feedController = new FeedController();
    }

    @Override
    public void execute(String[] args, Session session) {
        if (args.length < 1) {
            System.out.println("Invalid usage. Please provide post content.");
        }
        String content = args[0];
        feedController.post(content, session);
    }
}
