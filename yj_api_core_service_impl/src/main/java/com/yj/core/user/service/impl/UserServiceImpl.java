package com.yj.core.user.service.impl;

import com.yj.core.user.dto.User;
import com.yj.core.user.mapper.UserMapper;
import com.yj.core.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserInfo(String username) {
        return userMapper.getUserInfo(username);
    }
}
