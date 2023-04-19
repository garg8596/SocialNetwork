package com.model;

public class Comment {
    private String commentId;
    private String content;
    private User user;
    private int upvotes;
    private int downvotes;

    public Comment(String commentId, String content, User user, int upvotes, int downvotes) {
        this.commentId = commentId;
        this.content = content;
        this.user = user;
        this.upvotes = upvotes;
        this.downvotes = downvotes;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
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
}
