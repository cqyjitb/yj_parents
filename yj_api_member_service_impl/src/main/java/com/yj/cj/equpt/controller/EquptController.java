package com.yj.cj.equpt.controller;

import com.yj.cj.equpt.dto.Equpt;
import com.yj.cj.equpt.service.IEquptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EquptController {
    @Autowired
    private IEquptService equptService;

    @RequestMapping("/getEquptInfo")
    public String getEquptInfo(Integer equptId){
        Equpt equpt = equptService.getEquptInfo(equptId);
        return equpt.toString();
    }
}
