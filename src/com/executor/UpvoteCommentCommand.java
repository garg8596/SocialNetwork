package com.executor;

import com.command.Command;
import com.commons.Session;
import com.controller.CommentController;

public class UpvoteCommentCommand extends Command {
    CommentController commentController;

    public UpvoteCommentCommand(){
        this.commentController = new CommentController();
    }

    @Override
    public void execute(String[] args, Session session) {
        String commentId = args[0];
        commentController.upvote(commentId, session);
    }
}
