package com.db;

import com.model.Comment;

import java.util.HashMap;

public class CommentDatabase {
    public static CommentDatabase instance = new CommentDatabase();
    private HashMap<String, Comment> commentHashMap;

    private CommentDatabase(){
        this.commentHashMap = new HashMap<>();
    }

    public static CommentDatabase getInstance() {
        return instance;
    }

    public static void setInstance(CommentDatabase instance) {
        CommentDatabase.instance = instance;
    }

    public HashMap<String, Comment> getCommentHashMap() {
        return commentHashMap;
    }

    public void setCommentHashMap(Comment comment) {
        this.commentHashMap.put(comment.getCommentId(), comment);
    }
}
