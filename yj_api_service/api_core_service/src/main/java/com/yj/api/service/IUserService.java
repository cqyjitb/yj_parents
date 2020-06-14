package com.yj.api.service;

import org.springframework.web.bind.annotation.RequestMapping;

public interface IUserService {
    @RequestMapping("/getUserInfo")
    public String getUserInfo(String username);
}
