package com.inspur.service;

import com.inspur.entity.UserEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * User: YANG
 * Date: 2019/7/18-23:53
 * Description: No Description
 */
public interface MemberService {

	@RequestMapping("/getMember")
	public UserEntity getMember(@RequestParam("name") String name);
}
