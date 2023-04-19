package com.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String userName;
    private String password;
    private List<Post> postList;
    private List<Comment> commentList;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.postList = new ArrayList<>();
    }

    public void addComments(Comment comment){
        commentList.add(comment);
    }
    public void addPosts(Post post){
        postList.add(post);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Post> getPosts() {
        return postList;
    }

}
