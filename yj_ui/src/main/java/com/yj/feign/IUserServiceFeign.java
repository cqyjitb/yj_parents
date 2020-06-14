package com.yj.feign;

import com.yj.api.service.IUserService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("app-yj-core")
public interface IUserServiceFeign extends IUserService {
}
