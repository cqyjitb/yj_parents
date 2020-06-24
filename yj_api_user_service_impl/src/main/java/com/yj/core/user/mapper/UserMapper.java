package com.yj.core.user.mapper;

import com.yj.core.user.dto.User;

import java.util.List;

public interface UserMapper {

    public String getUserById(Integer id);

    public String getUserByName(String name);

    public List<User> getUserList();
}
