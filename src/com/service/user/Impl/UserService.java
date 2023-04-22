package com.service.user.Impl;

import com.commons.Messages;
import com.db.UserDatabase;
import com.model.Comment;
import com.model.Post;
import com.model.Reply;
import com.model.User;
import com.service.user.interfaces.IUserService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserService implements IUserService {

    @Override
    public void follow(String userName, User currentUser) {
        User userToFollow = UserDatabase.getInstance().getUserByUserName(userName);

        if(userToFollow==null){
            System.out.println(Messages.USER_NOT_EXIST + userName);
            return ;
        }
        else if(!currentUser.getUserName().equalsIgnoreCase(userName)){
            userToFollow.addFollower(currentUser);
            currentUser.addFollowing(userToFollow);
        }
        UserDatabase.getInstance().saveUser(userToFollow);
        UserDatabase.getInstance().saveUser(currentUser);
        System.out.println(Messages.FOLLOWED+userName);
    }

    @Override
    public void showProfile(User currentUser) {
        if(currentUser!=null){
            List<Post> posts = currentUser.getPosts();
            List<User> userFollower = currentUser.getFollowers();
            List<User> userFollowing = currentUser.getFollowing();
            List<Comment> commentList = currentUser.getComments();
            List<List<Reply>> replyList = new ArrayList<>();

            for(Comment comment: commentList){
                List<Reply> replies = comment.getReplyList();
                replyList.add(replies);
            }


            System.out.println(Messages.POSTS + posts.stream().map(Post::toString).collect(Collectors.joining(", ")));
            System.out.println(Messages.FOLLOWERS + userFollower.stream().map(User::getUserName).collect(Collectors.joining(", ")));
            System.out.println(Messages.FOLLOWING + userFollowing.stream().map(User::getUserName).collect(Collectors.joining(", ")));
            System.out.println(Messages.COMMENTS + commentList.stream().map(Comment::toString).collect(Collectors.joining(", ")));
            System.out.println(Messages.COMMENTS + commentList.stream().map(Comment::toString).collect(Collectors.joining(", ")));
            System.out.println(Messages.REPLIES);
            replyList.forEach(replies -> {
                System.out.println(Messages.COMMENTS + (replyList.indexOf(replies) + 1) + ": " + replies.stream().map(Reply::toString).collect(Collectors.joining(", ")));
            });
        }
    }
}
