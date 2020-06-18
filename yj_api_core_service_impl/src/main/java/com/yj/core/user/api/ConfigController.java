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
@RefreshScope   //支持nacos的动态刷新功能
@Api(value="ConfigController",tags={"Swagger配置操作接口"})
public class ConfigController {
    @Value("${config.info}")
    private String configInfo;

    @ApiOperation(value = "获取配置", notes = "获取配置config info")
    @RequestMapping(value = "/config/info",method = {RequestMethod.GET})
    public String getConfigInfo(){
        return configInfo;
    }

}
