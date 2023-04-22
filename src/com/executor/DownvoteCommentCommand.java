package com.executor;

import com.command.Command;
import com.commons.Session;
import com.controller.CommentController;

public class DownvoteCommentCommand extends Command {
    CommentController commentController;

    public DownvoteCommentCommand(){
        this.commentController = new CommentController();
    }

    @Override
    public void execute(String[] args, Session session) {
        String commentId = args[0];
        commentController.downvote(commentId, session);
    }
}
