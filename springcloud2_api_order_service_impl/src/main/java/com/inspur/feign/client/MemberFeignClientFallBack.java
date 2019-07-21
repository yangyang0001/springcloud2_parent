package com.inspur.feign.client;

import com.inspur.entity.UserEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * User: YANG
 * Date: 2019/7/20-23:53
 * Description: No Description
 */
@Component
public class MemberFeignClientFallBack implements MemberFeignClient {

	/**
	 * 服务降级的另外一种写法, Class类的写法:
	 * 相当于一个接口的同一个方法,两种策略实现,本类中实现各个接口的服务降级用的方法!
	 * 1.当前Class类必须 实现接口 [当前接口必须带有@FeignClient注解]
	 * 2.当前类必须纳入到spring容器的管理范围内!    @Component
	 * @param name
	 * @return
	 */
	@Override
	public UserEntity getMember(@RequestParam("name") String name) {
		UserEntity entity = new UserEntity();
		entity.setName("服务降级");
		entity.setAge(9999);
		System.out.println("服务等待超时,进行降级策略-------------->:" + entity.toString());
		return entity;
	}

}
