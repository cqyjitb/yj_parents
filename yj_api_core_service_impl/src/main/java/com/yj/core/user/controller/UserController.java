package com.yj.core.user.controller;

import com.yj.api.service.IUserService;
import com.yj.core.user.feign.IEquptServiceFeign;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value="用户controller",tags={"用户操作接口"})
@SwaggerDefinition
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Value("${server.port}")
    private String port;
    @Autowired
    private IUserService userService;
    @Autowired
    private IEquptServiceFeign equptServiceFeign;


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
            @ApiImplicitParam(name = "a", paramType = "path", value = "数字a", required = true, dataType = "long",example = "1"),
            @ApiImplicitParam(name = "b", paramType = "path", value = "数字b", required = true, dataType = "long",example = "1")
    })
    @RequestMapping(value = "/test/{a}/{b}",method = {RequestMethod.GET})
    public Integer get(@PathVariable Integer a, @PathVariable Integer b) {
        return a + b;
    }

    @ApiOperation(value = "获取端口",notes = "获取服务所在端口")
    @RequestMapping(value = "/getPort",method = {RequestMethod.GET})
    public String getPort(){
        Integer eqptId = 1;
        String eqptinfo = equptServiceFeign.getEquptInfo(eqptId);
        return "这是端口："+ port + "" + "设备为：" + eqptinfo;
    }
}
