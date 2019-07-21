package com.inspur.service.impl;

import com.inspur.entity.UserEntity;
import com.inspur.service.MemberService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: YANG
 * Date: 2019/7/19-13:20
 * Description: No Description
 */
@RestController
public class MemberServiceImpl implements MemberService {


	@Value("${server.port}")
	private String serverPort;

	@Override
	@RequestMapping("/getMember")
	public UserEntity getMember(@RequestParam("name") String name) {
		UserEntity entity = new UserEntity();
		entity.setName(name + ",serverPort:" + serverPort);
		entity.setAge(28);
		System.out.println("MemberServiceImpl entity :" + entity.toString() + ", serverPort is :" + serverPort);
		return entity;
	}
}
