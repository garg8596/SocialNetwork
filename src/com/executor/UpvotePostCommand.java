package com.executor;

import com.command.Command;
import com.commons.Session;
import com.controller.FeedController;

public class UpvotePostCommand extends Command {

    FeedController feedController;

    public UpvotePostCommand(){
        feedController = new FeedController();
    }
    @Override
    public void execute(String[] args, Session session) {
        String postId = args[0];
        feedController.upvote(postId, session);
    }
}
