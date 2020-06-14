package com.yj.cj.equpt.service.impl;

import com.yj.cj.equpt.dto.Equpt;
import com.yj.cj.equpt.mapper.EquptMapper;
import com.yj.cj.equpt.service.IEquptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquptServiceImpl implements IEquptService{
    @Autowired
    private EquptMapper equptMapper;
    @Override
    public Equpt getEquptInfo(Integer equptId) {
        return equptMapper.getEquptInfo(equptId);
    }
}
