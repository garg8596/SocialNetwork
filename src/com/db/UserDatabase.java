package com.db;

import com.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserDatabase {
    public static UserDatabase instance = new UserDatabase();
    public Map<String, User> users;

    private UserDatabase(){
        users = new HashMap<>();
    }


    public static UserDatabase getInstance() {
        return instance;
    }

    public void addUser(User user) {
        users.put(user.getUserName(), user);
    }

    public void saveUser(User user) {
        users.put(user.getUserName(), user);
    }

    public User getUserByUserName(String userName) {
        return users.get(userName);
    }
}
