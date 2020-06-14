package com.yj.cj.equpt.mapper;

import com.yj.cj.equpt.dto.Equpt;
import org.apache.ibatis.annotations.Param;

public interface EquptMapper {

    public Equpt getEquptInfo(@Param("equptid") Integer equptid);
}
