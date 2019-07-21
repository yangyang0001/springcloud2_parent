package com.inspur.service;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: YANG
 * Date: 2019/7/19-13:28
 * Description: No Description
 */
public interface OrderService {

	@RequestMapping("/orderToMember")
	public String orderToMember();
}
