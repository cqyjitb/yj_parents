package com.yj.core.user.service;

import com.yj.core.user.api.IUserService;
import com.yj.core.user.mapper.UserMapper;
import com.yj.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public String getUserById(Integer id) {
        return JsonUtil.getJson(userMapper.getUserById(id));
    }

    @Override
    public String getUserByName(String name) {
        return JsonUtil.getJson(userMapper.getUserByName(name));
    }

    @Override
    public String getUserList() {
        return JsonUtil.listToJson(userMapper.getUserList());
    }
}
