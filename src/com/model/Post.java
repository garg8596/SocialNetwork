package com.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Post {
    private String postId;
    private String content;
    private User user;
    private int upvotes;
    private int downvotes;
    private List<Comment> commentList;
    private LocalDateTime timestamp;
    private HashMap<String, String> votedUser;


    public Post(String postId, String content, User user) {
        this.postId = postId;
        this.content = content;
        this.user = user;
        this.upvotes = 0;
        this.downvotes = 0;
        this.commentList = new ArrayList<>();
        this.votedUser = new HashMap<>();
        this.timestamp = LocalDateTime.now();
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getUpvotes() {
        return upvotes;
    }

    public void incUpvotes() {
        this.upvotes++;
    }

    public int getDownvotes() {
        return downvotes;
    }

    public void incDownvotes() {
        this.downvotes++;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(Comment comment) {
        this.commentList.add(comment);
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public HashMap<String, String> getVotedUser() {
        return votedUser;
    }

    public void addVotedUser(String votedUser, String action) {
        this.votedUser.put(votedUser, action);
    }
}
