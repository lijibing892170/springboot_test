package com.ljb.test.controller;

import com.ljb.test.model.BaseResponce;
import com.ljb.test.model.User;
import com.ljb.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/userRegister")
    public BaseResponce register(@RequestParam String username, @RequestParam String password) {
        User user = userService.register(username, password);
        return new BaseResponce(true, user);
    }

    @PostMapping("/login")
    public BaseResponce login(@RequestParam String username, @RequestParam String password) {
        User login = userService.login(username, password);
        return new BaseResponce(true, login);
    }

    @PostMapping("/modifyUser")
    public BaseResponce modify(@RequestBody User user) {
        System.out.println("user:" + user);
        User user1 = userService.editUserInfo(user);
        return new BaseResponce(true, user1);
    }
}
