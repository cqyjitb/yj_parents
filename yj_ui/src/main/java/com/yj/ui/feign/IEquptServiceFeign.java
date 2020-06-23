package com.yj.ui.feign;
import com.yj.core.api.service.IEquptService;
import org.springframework.cloud.openfeign.FeignClient;
@FeignClient("app-yj-member")
public interface IEquptServiceFeign extends IEquptService {
}
