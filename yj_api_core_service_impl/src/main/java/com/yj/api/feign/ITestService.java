package com.yj.api.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "app-yj-core",url = "http://127.0.0.1:9000")
public interface ITestService {
    @RequestMapping("/test")
    public String testFeign();
}
