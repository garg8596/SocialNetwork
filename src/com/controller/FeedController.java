package com.controller;

import com.commons.Messages;
import com.commons.Session;
import com.model.User;
import com.service.feed.Impl.FeedService;
import com.service.feed.interfaces.IFeedService;

public class FeedController {
    IFeedService feedService;

    public FeedController(){
        feedService = new FeedService();
    }

    public void upvote(String postId, Session session){
        User loggedInUser = session.getLoggedInUser();
        feedService.upvote(postId, loggedInUser);
    }

    public void downvote(String postId, Session session){
        User loggedInUser = session.getLoggedInUser();
        feedService.downvote(postId, loggedInUser);
    }

    public void post(String content, Session session){
        if(session.getLoggedInUser()==null){
            System.out.println(Messages.LOGIN_TO_POST);
        }
        else{
            feedService.post(content, session.getLoggedInUser());
        }
    }

    public void showFeed(Session session, String sortOption){
        if(session.getLoggedInUser()==null){
            System.out.println(Messages.LOGIN_TO_SEE_FEED);
        }
        else {
            feedService.showFeed(session.getLoggedInUser(), sortOption);
        }
    }

    public void comment(String postId, String comment, Session session) {
        User user = session.getLoggedInUser();
        if(session.getLoggedInUser()==null){
            System.out.println(Messages.LOGIN_TO_C0MMENT);
        }
        else{
            feedService.comment(postId, comment, user);
        }

    }
}
