package com.db;

import com.model.Post;

import java.util.HashMap;

public class PostDatabase {
    public static PostDatabase instance = new PostDatabase();

    private HashMap<String, Post> postHashMap;

    private PostDatabase(){
        this.postHashMap = new HashMap<>();
    }

    public static PostDatabase getInstance() {
        return instance;
    }

    public static void setInstance(PostDatabase instance) {
        PostDatabase.instance = instance;
    }

    public HashMap<String, Post> getPostHashMap() {
        return postHashMap;
    }

    public void setPostHashMap(Post post) {
        this.postHashMap.put(post.getPostId(), post);
    }
}
