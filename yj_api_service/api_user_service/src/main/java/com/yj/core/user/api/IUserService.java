package com.yj.core.user.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface IUserService {
    @RequestMapping(value = "/getUserById",method = {RequestMethod.POST})
    public String getUserById(Integer id);


    @RequestMapping(value = "/getUserByName",method = {RequestMethod.POST})
    public String getUserByName(String name);


}