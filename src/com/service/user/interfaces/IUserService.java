package com.service.user.interfaces;

import com.model.User;

public interface IUserService {
    void follow(String userName, User curentUser);
    void showProfile(User currentUser);
}
