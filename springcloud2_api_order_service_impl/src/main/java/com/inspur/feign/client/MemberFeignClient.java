package com.inspur.feign.client;

import com.inspur.service.MemberService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * User: YANG
 * Date: 2019/7/19-13:40
 * Description: No Description
 */
@FeignClient(name = "app-memeber", fallback = MemberFeignClientFallBack.class)
public interface MemberFeignClient extends MemberService {
}
