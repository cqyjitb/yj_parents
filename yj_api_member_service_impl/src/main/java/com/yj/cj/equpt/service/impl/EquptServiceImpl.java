package com.yj.cj.equpt.service.impl;

import com.yj.api.service.IEquptService;
import com.yj.cj.equpt.dto.Equpt;
import com.yj.cj.equpt.mapper.EquptMapper;
import com.yj.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquptServiceImpl implements IEquptService {
    @Autowired
    private EquptMapper equptMapper;
    @Override
    public String getEquptInfo(Integer equptId) {
        return JsonUtil.getJson(equptMapper.getEquptInfo(equptId));
    }
}
