package com.yj.core.user.api;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@Api(value="ConfigController",tags={"Swagger配置操作接口"})
public class ConfigController {

    @Value("${user.name}")
    private String username;
    @ApiOperation(value = "获取配置",notes = "获取配置文件信息")
    @RequestMapping(value = "/config",method = {RequestMethod.GET})
    public String getConfig(){
        System.out.println(username);
        return "Hello " + username;
    }

}
