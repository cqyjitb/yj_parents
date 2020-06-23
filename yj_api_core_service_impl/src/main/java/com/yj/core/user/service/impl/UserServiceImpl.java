package com.yj.core.user.service.impl;

import com.yj.core.api.service.IUserService;
import com.yj.core.user.mapper.UserMapper;
import com.yj.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public String getUserInfo(String username) {

        if (userMapper.getUserInfo(username) == null ){
            return "";
        }else{
            return JsonUtil.getJson(userMapper.getUserInfo(username));
        }
    }



    @Value("${server.port}")
    private String port;
    @Value("${spring.application.name}")
    private String appname;
    @Override
    public String getApiInfo() {
        return "端口："+port+"appname:"+appname;
    }


}
