package com.executor;

import com.commons.Session;
import com.command.Command;
import com.controller.FeedController;

public class DownvotePostCommand extends Command {

    FeedController feedController;


    public DownvotePostCommand(){
        feedController = new FeedController();
    }
    @Override
    public void execute(String[] args, Session session) {
        String postId = args[0];
        feedController.downvote(postId, session);
    }
}
