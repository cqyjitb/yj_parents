package com.yj.core.user.controller;

import com.yj.api.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Value("${server.port}")
    private String port;
    @Autowired
    private IUserService userService;
    @RequestMapping("/getUserInfo")
    public String getUserInfo(@RequestBody String username){
        logger.info("日志测试！！！！！！！！");
        return userService.getUserInfo(username);
    }

    @RequestMapping("/test/1")
    private String test(){

        return "yj_core_api/test:"+port;
    }

    @RequestMapping("/test2/1")
    private String test2(){
        return "yj_core_api/test";
    }
}
