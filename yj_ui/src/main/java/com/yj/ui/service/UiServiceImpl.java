package com.yj.ui.service;

import com.yj.ui.api.IUIService;
import com.yj.ui.feign.IUserServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UiServiceImpl implements IUIService {

    @Value("${server.port}")
    private String port;
    @Value("${spring.application.name}")
    private String appname;
    @Override
    public String getApiInfo() {
        return "端口："+port+"appname:"+appname;
    }

}
