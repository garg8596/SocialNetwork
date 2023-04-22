package com.service.comment.interfaces;

import com.model.User;

public interface ICommentService {
    void replyToComment(String commentId, String replyText, User user);

    void upvote(String commentId, User loggedInUser);

    void downvote(String commentId, User loggedInUser);
}
