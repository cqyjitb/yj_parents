package com.yj.core.api.service;

import com.yj.base.ResponseBase;
import org.springframework.web.bind.annotation.RequestMapping;

public interface IOrderService {

    @RequestMapping("/orderToMember")
    public String orderToMember(String name);
    @RequestMapping("/orderToMemberUserInfo")
    public ResponseBase orderToMemberUserInfo();
}
