package com.yj.api.feign.impl;

import com.yj.api.feign.ITestService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestService implements ITestService {
    @Override
    public String testFeign() {
        return "success";
    }
}
