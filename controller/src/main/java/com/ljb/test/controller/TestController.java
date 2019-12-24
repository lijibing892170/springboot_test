package com.ljb.test.controller;

import com.ljb.test.model.BaseResponce;
import com.ljb.test.model.User;
import com.ljb.test.utils.CommonUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class TestController {

    @RequestMapping(value = "/aaa/{hello}", method = RequestMethod.GET)
    public String aaa(@PathVariable("hello") String hel, @RequestParam("aaa") String user) {
        return hel + "  /  " + user;
    }

    @RequestMapping(value = "/userRegister/{aaa}", method = RequestMethod.GET)
    public BaseResponce register(@PathVariable("aaa") String hello,
                                 @RequestParam(value = "a") String username,
                                 @RequestParam(value = "b") String password,
                                 @RequestParam(value = "token") String token,
                                 @RequestParam(value = "lang") String lang) {
        System.out.println("hello:" + hello + "   username:" + username + "     password:" + password + "     token:" + token + "      lang:" + lang);
        if (CommonUtils.isStringEmpty(username)) {
            throw new RuntimeException("the username cannot be null");
        }
        if (CommonUtils.isStringEmpty(password)) {
            throw new RuntimeException("the password cannot be null");
        }
        User user = new User();
        user.id = 1;
        user.userName = username;
        user.passWord = password;
        return new BaseResponce(true, user);
    }
}
