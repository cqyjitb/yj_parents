package com.yj.core.user.mapper;


import com.yj.core.user.dto.User;
import org.apache.ibatis.annotations.Param;
public interface UserMapper {

    public User getUserInfo(@Param("username") String username);
}
