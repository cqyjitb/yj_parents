package com.yj.core.user.service.impl;

import com.yj.api.service.IUserService;
import com.yj.core.user.mapper.UserMapper;
import com.yj.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
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
}
