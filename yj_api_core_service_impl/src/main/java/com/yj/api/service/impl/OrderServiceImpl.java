package com.yj.api.service.impl;

import com.yj.api.entity.UserEneity;
import com.yj.api.feign.MemberServiceFeign;
import com.yj.api.service.IOrderService;
import com.yj.base.ResponseBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private MemberServiceFeign memberServiceFeign;

    @Override
    @RequestMapping("/orderToMember")
    public String orderToMember(@RequestParam("name") String name) {
        UserEneity user = memberServiceFeign.getMember(name);
        return user == null ? "faild" : user.toString();
    }

    @Override
    @RequestMapping("/orderToMemberUserInfo")
    public ResponseBase orderToMemberUserInfo() {
        return memberServiceFeign.getUserInfo();
    }
}
