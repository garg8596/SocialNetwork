package com.model;

import java.time.LocalDateTime;

public class Reply {
    private String replyId;
    private String replyText;
    private User user;
    private LocalDateTime timestamp;

    public Reply(String replyId, String replyText, User user){
        this.replyId = replyId;
        this.replyText = replyText;
        this.user = user;
        this.timestamp = LocalDateTime.now();
    }

    public String getReplyId() {
        return replyId;
    }

    public void setReplyId(String replyId) {
        this.replyId = replyId;
    }

    public String getReplyText() {
        return replyText;
    }

    public void setReplyText(String replyText) {
        this.replyText = replyText;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "replyId='" + replyId + '\'' +
                ", replyText='" + replyText + '\'' +
                ", user=" + user +
                ", timestamp=" + timestamp +
                '}';
    }
}
