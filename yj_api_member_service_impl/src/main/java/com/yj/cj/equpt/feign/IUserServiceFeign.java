package com.yj.cj.equpt.feign;

import com.yj.core.api.service.IUserService;
import org.springframework.cloud.openfeign.FeignClient;


@FeignClient("app-yj-core")
public interface IUserServiceFeign extends IUserService {
}