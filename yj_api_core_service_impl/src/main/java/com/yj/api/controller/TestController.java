//package com.yj.api.controller;
//
//import com.yj.api.feign.ITestService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class TestController {
//    @Autowired
//    private ITestService testService;
//    @RequestMapping(value = "/test",method = RequestMethod.GET)
//    public String test(){
//        System.out.print(testService.toString());
//        return "success";
//    }
//
//}
