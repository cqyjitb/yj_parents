package com.yj.api.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface IEquptService {

    @RequestMapping(value = "/getEquptInfo/{equptId}",method = {RequestMethod.GET})
    public String getEquptInfo(@PathVariable("equptId") Integer equptId);
}
