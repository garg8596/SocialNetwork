package com.service.feed.Impl;

import com.commons.Messages;
import com.db.CommentDatabase;
import com.db.PostDatabase;
import com.model.Comment;
import com.model.Post;
import com.model.User;
import com.service.feed.interfaces.IFeedService;
import com.utils.SocialMediaUtils;

import java.util.*;

public class FeedService implements IFeedService {
    SocialMediaUtils socialMediaUtils;

    public FeedService(){
        socialMediaUtils = new SocialMediaUtils();
    }

    @Override
    public void post(String content, User loggedInUser) {
        Post post = new Post(UUID.randomUUID().toString(), content, loggedInUser);
        loggedInUser.addPosts(post);
        PostDatabase.getInstance().setPostHashMap(post);
        System.out.println(Messages.POST_CREATED + post.getPostId());
    }

    public void showFeed(User loggedInUser, String sortOption){
        List<Post> postList = loggedInUser.getPosts();

        List<Post> feed = new ArrayList<>();
        List<User> followedUsers = loggedInUser.getFollowing();
        for (User followedUser : followedUsers) {
            feed.addAll(followedUser.getPosts());
        }

        switch (sortOption){
            case Messages.SCORE:
                Collections.sort(postList, (p1, p2)-> {
                        int score1 = p1.getUpvotes()-p1.getDownvotes();
                        int score2 = p2.getUpvotes()-p2.getDownvotes();
                        return Integer.compare(score2, score1);
                });
                break;
            case Messages.COMMENT:
                Collections.sort(postList, (p1, p2) -> {
                    int numComments1 = p1.getCommentList().size();
                    int numComments2 = p2.getCommentList().size();
                    return Integer.compare(numComments2, numComments1);
                });
                break;
            case Messages.TIMESTAMP:
                Collections.sort(postList, (p1, p2) -> p2.getTimestamp().compareTo(p1.getTimestamp()));
            default:
                System.out.println(Messages.INVALID_SORTING_OPTION);
                Collections.shuffle(postList);
        }

        for(Post post: postList){
            String elapsedTime = socialMediaUtils.calculateElapsedTime(post.getTimestamp());
            System.out.print("Post - " + post.getContent());
            System.out.print(" | " + post.getUpvotes()+ Messages.UPVOTES);;
            System.out.print(", " + post.getDownvotes()+ Messages.DOWNVOTES);;
            System.out.print(" | " + post.getCommentList());
            System.out.print(" (" + elapsedTime + ")");
            System.out.println();
        }
    }

    public void comment(String postId, String commentContent, User user){
        Post post = socialMediaUtils.getPostById(postId);
        Comment comment = new Comment(UUID.randomUUID().toString(), commentContent, user);
        post.setCommentList(comment);
        user.addComments(comment);
        CommentDatabase.getInstance().setCommentHashMap(comment);
        System.out.println("Comment Done!!! " + comment.getCommentId());
    }

    @Override
    public void upvote(String postId, User user) {
        Post post = socialMediaUtils.getPostById(postId);
        if(post.getVotedUser().containsKey(user.getUserName())){
            System.out.println(Messages.ALREADY+ post.getVotedUser().get(user.getUserName())+ Messages.POST);
            return ;
        }
        post.incUpvotes();
        post.addVotedUser(user.getUserName(), Messages.UPVOTED);
        System.out.println(Messages.UPVOTE_POST+ postId);
    }

    @Override
    public void downvote(String postId, User user) {
        Post post = socialMediaUtils.getPostById(postId);
        if(post.getVotedUser().containsKey(user.getUserName())){
            System.out.println(Messages.ALREADY + post.getVotedUser().get(user.getUserName())+ Messages.POST);
            return ;
        }
        post.incDownvotes();
        post.addVotedUser(user.getUserName(), Messages.DOWNVOTED);
        System.out.println(Messages.DOWNVOTE_POST + postId);
    }
}
