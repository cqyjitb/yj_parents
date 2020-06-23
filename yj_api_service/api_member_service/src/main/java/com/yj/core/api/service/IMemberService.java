package com.yj.core.api.service;

import com.yj.core.api.entity.UserEneity;
import com.yj.base.ResponseBase;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface IMemberService {

    @RequestMapping("/getMember")
    public UserEneity getMember(@RequestParam("name") String name);
    @RequestMapping("/getUserInfo")
    public ResponseBase getUserInfo();

}
