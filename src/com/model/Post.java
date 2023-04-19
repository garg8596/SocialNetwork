package com.model;

import java.util.List;

public class Post {
    private String postId;
    private String content;
    private User user;
    private int upvotes;
    private int downvotes;
    private List<Comment> commentList;

    public Post(String postId, String content, User user, int upvotes, int downvotes, List<Comment> commentList) {
        this.postId = postId;
        this.content = content;
        this.user = user;
        this.upvotes = upvotes;
        this.downvotes = downvotes;
        this.commentList = commentList;
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

    public void setUpvotes(int upvotes) {
        this.upvotes = upvotes;
    }

    public int getDownvotes() {
        return downvotes;
    }

    public void setDownvotes(int downvotes) {
        this.downvotes = downvotes;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
}
