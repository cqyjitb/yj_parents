package com.yj.cj.equpt.service.impl;

import com.yj.core.api.service.IEquptService;
import com.yj.cj.equpt.mapper.EquptMapper;
import com.yj.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EquptServiceImpl implements IEquptService {
    @Autowired
    private EquptMapper equptMapper;
    @Override
    public String getEquptInfo(Integer equptId) {
        return JsonUtil.getJson(equptMapper.getEquptInfo(equptId));
    }

    @Value("${server.port}")
    private String port;
    @Value("${spring.application.name}")
    private String appname;
    @Override
    public String getApiInfo() {
        return "端口："+port+"appname:"+appname;
    }


}
