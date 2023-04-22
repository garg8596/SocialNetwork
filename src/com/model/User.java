package com.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String userName;
    private String password;
    private List<Post> postList;
    private List<Comment> commentList;

    private List<User> followers;
    private List<User> following;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.postList = new ArrayList<>();
        this.commentList = new ArrayList<>();
        this.followers = new ArrayList<>();
        this.following = new ArrayList<>();
    }

    public void addFollower(User follower) {
        if (followers == null) {
            followers = new ArrayList<>();
        }
        followers.add(follower);
    }

    public void removeFollower(User follower) {
        if (followers != null) {
            followers.remove(follower);
        }
    }

    public void addFollowing(User user) {
        if (following == null) {
            following = new ArrayList<>();
        }
        following.add(user);
    }

    public void removeFollowing(User follower) {
        if (followers != null) {
            followers.remove(follower);
        }
    }

    public List<User> getFollowers() {
        return followers;
    }
    public List<User> getFollowing() {
        return following;
    }

    public void addComments(Comment comment){
        commentList.add(comment);
    }
    public List<Comment> getComments(){
        return commentList;
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


    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    public void setFollowing(List<User> following) {
        this.following = following;
    }

//    @Override
//    public String toString() {
//        return "User{" +
//                "userName='" + userName + '\'' +
//                ", password='" + password + '\'' +
//                ", postList=" + postList +
//                ", commentList=" + commentList +
//                ", followers=" + followers +
//                ", following=" + following +
//                '}';
//    }
}
