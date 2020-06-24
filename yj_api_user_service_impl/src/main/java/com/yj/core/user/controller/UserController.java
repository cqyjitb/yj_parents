package com.yj.core.user.controller;

import com.yj.core.user.api.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value="用户controller",tags={"用户操作接口"})
public class UserController {
    @Autowired
    private IUserService userService;

//    @ApiOperation(value = "用户获取", notes = "根据用户ID获取用户信息")
//    @ApiImplicitParam(name = "userid",value = "用户ID",required = true,paramType = "body",example = "1",type = "integer")
//    @RequestMapping(value = "/getUserById",method = {RequestMethod.POST})
//    public String getUserById(@RequestBody Integer userid){
//
//        return userService.getUserById(userid);
//    }
//    @ApiOperation(value = "用户获取", notes = "根据用户名获取用户信息")
//    @ApiImplicitParam(name = "username",value = "用户名",required = true,paramType = "body",example = "tom",type = "string")
//    @RequestMapping(value = "/getUserByName",method = {RequestMethod.POST})
//    public String getUserByName(@RequestBody String username){
//        return userService.getUserByName(username);
//    }

    @ApiOperation(value = "用户列表获取", notes = "获取全部用户列表")
    @RequestMapping(value = "/getUserList",method = {RequestMethod.GET})
    public String getUserList(){
        return userService.getUserList();
    }

}
