package com.yj.api.feign;

import com.yj.api.service.IMemberService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("app-yj-member")
public interface MemberServiceFeign extends IMemberService {

}
