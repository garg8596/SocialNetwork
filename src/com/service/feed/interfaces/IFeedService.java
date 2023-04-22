package com.service.feed.interfaces;

import com.model.Comment;
import com.model.Post;
import com.model.User;

import java.util.UUID;

public interface IFeedService {
    void post(String content, User loggedInUser);

    void showFeed(User loggedInUser, String sortOption);

    void comment(String postId, String comment, User user);

    void upvote(String postId, User user);
    void downvote(String postId, User user);
}
