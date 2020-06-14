package com.yj.core.user.controller;

import com.yj.api.service.IUserService;
import com.yj.core.user.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private IUserService userService;
    @RequestMapping("/getUserInfo")
    public String getUserInfo(@RequestBody String username){

        return userService.getUserInfo(username);
    }
}
