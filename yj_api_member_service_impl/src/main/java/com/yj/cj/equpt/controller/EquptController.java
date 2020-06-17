package com.yj.cj.equpt.controller;

import com.yj.cj.equpt.service.IEquptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("设备相关接口")
public class EquptController {
    @Autowired
    private IEquptService equptService;
    @ApiOperation(value = "设备信息",notes = "根据设备ID查询设备信息")
    @RequestMapping(value = "/getEquptInfo/{equptId}",method = {RequestMethod.GET})
//    @ApiImplicitParam(name = "equptId",dataType = "integer",required=true,example = "1",value = "设备ID",paramType = "path")
    @ApiImplicitParam(name = "equptId", paramType = "path",
            value = "设备ID", required = true, dataType = "long",example = "1")
    public String getEquptInfo(@PathVariable Integer equptId){
        return equptService.getEquptInfo(equptId);
    }
}
