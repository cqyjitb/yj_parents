package com.yj.core.user.controller;

import com.yj.core.user.dto.User;
import com.yj.core.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private IUserService userService;
    @RequestMapping("/getUserInfo")
    public String getUserInfo(String username){
        User user = userService.getUserInfo(username);
        return user.toString();
    }
}
