package com.controller;

import com.commons.Messages;
import com.commons.Session;
import com.model.User;
import com.service.comment.Impl.CommentService;
import com.service.comment.interfaces.ICommentService;

public class CommentController {
    ICommentService commentService;

    public CommentController(){
        commentService = new CommentService();
    }

    public void replyToComment(String commentId, String replyText, Session session) {
        User loggedInUser = session.getLoggedInUser();
        if(loggedInUser==null){
            System.out.println(Messages.LOGIN_TO_REPLY_COMMENT);
        }
        else{
            commentService.replyToComment(commentId, replyText, loggedInUser);
        }

    }

    public void upvote(String commentId, Session session) {
        User loggedInUser = session.getLoggedInUser();
        if(loggedInUser==null){
            System.out.println(Messages.LOGIN_TO_UPVOTE);
        }
        else{
            commentService.upvote(commentId, loggedInUser);
        }

    }

    public void downvote(String commentId, Session session) {
        User loggedInUser = session.getLoggedInUser();
        if(loggedInUser==null){
            System.out.println(Messages.LOGIN_TO_DOWNVOTE);
        }
        else{
            commentService.downvote(commentId, loggedInUser);
        }

    }
}
