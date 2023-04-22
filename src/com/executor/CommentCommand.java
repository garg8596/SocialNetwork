package com.executor;

import com.command.Command;
import com.commons.Session;
import com.controller.CommentController;
import com.controller.FeedController;

public class CommentCommand extends Command {

    FeedController feedController;

    public CommentCommand(){
        this.feedController = new FeedController();
    }


    @Override
    public void execute(String[] args, Session session) {
        String postId = args[0];
        String comment = args[1];
        feedController.comment(postId, comment, session);
    }
}
