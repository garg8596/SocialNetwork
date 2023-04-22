package com.executor;

import com.command.Command;
import com.commons.Session;
import com.controller.CommentController;

public class ReplyCommand extends Command {

    CommentController commentController;

    public ReplyCommand(){
        this.commentController = new CommentController();
    }

    @Override
    public void execute(String[] args, Session session) {
        String commentId = args[0];
        String replyText = args[1];
        commentController.replyToComment(commentId, replyText, session);

    }
}
