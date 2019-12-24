package com.ljb.test.service.impl;

import com.ljb.test.mapper.UserMapper;
import com.ljb.test.model.User;
import com.ljb.test.service.UserService;
import com.ljb.test.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserserviceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User register(String username, String password) {
        if (CommonUtils.isStringEmpty(username)) {
            throw new RuntimeException("the username cannot be null");
        }
        if (CommonUtils.isStringEmpty(password)) {
            throw new RuntimeException("the password cannot be null");
        }

        List<User> users = userMapper.queryUserById(Arrays.asList(15, 16, 18, 19, 20));
        CommonUtils.logI(UserserviceImpl.class.getName(), users.toString());

        User user = new User();
        user.userName = username;
        user.passWord = password;
        user.nickName = username;
        int i = userMapper.saveUser(user);
        System.out.println("user.id=" + user.id);
        if (i <= 0) {
            throw new RuntimeException("failed to save user information");
        }
        return user;
    }

    @Override
    public User login(String username, String password) {
        if (CommonUtils.isStringEmpty(username)) {
            throw new RuntimeException("the username cannot be null");
        }
        if (CommonUtils.isStringEmpty(password)) {
            throw new RuntimeException("the password cannot be null");
        }
        User user = userMapper.queryUserByNmae(username);
        if (user == null) {
            throw new RuntimeException("the user is not registered");
        }
        if (!user.passWord.equals(password)) {
            throw new RuntimeException("error password");
        }
        return user;
    }

    @Override
    public User editUserInfo(User user) {
        if (null == user) {
            throw new RuntimeException("the user cannot be null");
        }
        if (CommonUtils.isStringEmpty(user.userName)) {
            throw new RuntimeException("the userName cannot be null");
        }

        int i = userMapper.editUserInfo(user);
        if (i <= 0) {
            throw new RuntimeException("fail to modify");
        }
        return userMapper.queryUserByNmae(user.userName);
    }
}
