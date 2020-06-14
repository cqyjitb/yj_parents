package com.yj.api.service.impl;

import com.yj.api.entity.UserEneity;
import com.yj.api.service.IMemberService;
import com.yj.base.BaseApiService;
import com.yj.base.ResponseBase;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberServiceImpl extends BaseApiService implements IMemberService {

    @Override
    @RequestMapping("/getMember")
    public UserEneity getMember(@RequestParam("name") String name) {
        UserEneity userEneity = new UserEneity();
        userEneity.setName(name);
        userEneity.setAge(20);
        return userEneity;
    }

    @Override
    @RequestMapping("/getUserInfo")
    public ResponseBase getUserInfo() {

        try{
            Thread.sleep(1500);
        }catch (Exception e){

        }
        return setResultSuccess("订单服务接口调用会员服务接口成功！");
    }
}
