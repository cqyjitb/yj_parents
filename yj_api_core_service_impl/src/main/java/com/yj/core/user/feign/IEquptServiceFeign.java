package com.yj.core.user.feign;

import com.yj.api.service.IEquptService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("app-yj-member")
public interface IEquptServiceFeign extends IEquptService {
}
