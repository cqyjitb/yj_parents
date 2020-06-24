package com.yj.ui.feign;

import com.yj.core.user.api.IUserService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("app-yj-user")
public interface IUserServiceFeign extends IUserService{
}
