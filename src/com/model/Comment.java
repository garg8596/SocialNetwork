package com.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Comment {
    private String commentId;
    private String content;
    private User user;
    private List<Reply> replyList;

    private HashMap<String, String> votedUser;

    private int upvote;
    private int downvote;

    public Comment(String commentId, String content, User user) {
        this.commentId = commentId;
        this.content = content;
        this.user = user;
        this.replyList = new ArrayList<>();
        this.votedUser = new HashMap<>();
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

    public List<Reply> getReplyList(){
        return this.replyList;
    }

    public HashMap<String, String> getVotedUser() {
        return votedUser;
    }

    public void setVotedUser(HashMap<String, String> votedUser) {
        this.votedUser = votedUser;
    }

    public void addReplyList(Reply reply) {
        this.replyList.add(reply);
    }

    public int getUpvote() {
        return upvote;
    }

    public void incUpvote() {
        this.upvote++;
    }

    public int getDownvote() {
        return downvote;
    }

    public void incDownvote() {
        this.downvote++;
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Comment{")
                .append("commentId='").append(commentId).append('\'')
                .append(", content='").append(content).append('\'')
                .append(", user=").append(user.getUserName()).append('\'')
                .append(", replyList=[");
        for (int i = 0; i < replyList.size(); i++) {
            sb.append(replyList.get(i).getReplyText());
            if (i < replyList.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]")
                .append(", upvote=").append(upvote)
                .append(", downvote=").append(downvote)
                .append('}');
        return sb.toString();
    }
}
