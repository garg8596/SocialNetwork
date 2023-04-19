package com.commons;

import com.model.User;

public class Session {
    private User loggedInUser;

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(User user) {
        this.loggedInUser = user;
    }
}

