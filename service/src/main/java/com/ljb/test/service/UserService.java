package com.ljb.test.service;

import com.ljb.test.model.User;

import java.util.List;

public interface UserService {

    User register(String username,String password);

    User login(String username,String password);

    User editUserInfo(User user);
}
