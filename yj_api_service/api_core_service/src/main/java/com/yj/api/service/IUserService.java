package com.yj.api.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface IUserService {
    @RequestMapping(value = "/getUserInfo",method = {RequestMethod.POST})
    public String getUserInfo(String username);
}
