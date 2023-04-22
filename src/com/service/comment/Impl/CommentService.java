package com.service.comment.Impl;

import com.commons.Messages;
import com.db.CommentDatabase;
import com.db.PostDatabase;
import com.model.Comment;
import com.model.Post;
import com.model.Reply;
import com.model.User;
import com.service.comment.interfaces.ICommentService;
import com.utils.SocialMediaUtils;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class CommentService implements ICommentService {

    SocialMediaUtils socialMediaUtils;

    public CommentService(){
        socialMediaUtils = new SocialMediaUtils();
    }

    @Override
    public void replyToComment(String commentId, String replyText, User user){
        Comment comment = CommentDatabase.getInstance().getCommentHashMap().get(commentId);
        Reply reply = new Reply(UUID.randomUUID().toString(), replyText, user);
        comment.addReplyList(reply);
        System.out.println(Messages.REPLIED + commentId);

    }

    @Override
    public void upvote(String commentId, User loggedInUser) {
        Comment comment = CommentDatabase.getInstance().getCommentHashMap().get(commentId);
        if(comment.getVotedUser().containsKey(loggedInUser.getUserName())){
            System.out.println(Messages.ALREADY+ comment.getVotedUser().get(loggedInUser.getUserName())+ Messages.COMMENT);
            return ;
        }
        comment.incUpvote();
        comment.getVotedUser().put(loggedInUser.getUserName(), Messages.UPVOTED);
        System.out.println(Messages.UPVOTED_COMMENT+commentId);
    }

    @Override
    public void downvote(String commentId, User loggedInUser) {
        Comment comment = CommentDatabase.getInstance().getCommentHashMap().get(commentId);
        if(comment.getVotedUser().containsKey(loggedInUser.getUserName())){
            System.out.println(Messages.ALREADY + comment.getVotedUser().get(loggedInUser.getUserName())+ Messages.COMMENT);
            return ;
        }
        comment.incDownvote();
        comment.getVotedUser().put(loggedInUser.getUserName(), Messages.DOWNVOTED);
        System.out.println(Messages.DOWNVOTED_COMMENT+commentId);
    }


}
