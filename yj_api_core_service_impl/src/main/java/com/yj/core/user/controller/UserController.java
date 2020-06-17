package com.yj.core.user.controller;

import com.yj.api.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Api("用户接口")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Value("${server.port}")
    private String port;
    @Autowired
    private IUserService userService;

    @ApiOperation(value = "用户获取", notes = "根据用户名获取用户信息")
    @ApiImplicitParam(name = "username",value = "用户名",required = true,paramType = "body",example = "tom")
    @RequestMapping(value = "/getUserInfo",method = {RequestMethod.POST})
    public String getUserInfo(@RequestBody String username){
        logger.info("username:"+username);
        String userinfo = "";
        userinfo = userService.getUserInfo(username);
        return userinfo;
    }


    @ApiOperation(value = "计算+", notes = "加法")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "a", paramType = "path", value = "数字a", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "b", paramType = "path", value = "数字b", required = true, dataType = "Long")
    })
    @RequestMapping(value = "/test/{a}/{b}",method = {RequestMethod.GET})
    public Integer get(@PathVariable Integer a, @PathVariable Integer b) {
        return a + b;
    }


}
