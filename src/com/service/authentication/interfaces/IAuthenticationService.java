package com.service.authentication.interfaces;

import com.commons.Session;
import com.model.User;

public interface IAuthenticationService {
    User login(String userId, String password, Session session);
    void signup(String userId, String password, Session session);
}
