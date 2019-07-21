package com.inspur.service.impl;

import com.inspur.entity.UserEntity;
import com.inspur.feign.client.MemberFeignClient;
import com.inspur.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: YANG
 * Date: 2019/7/19-13:32
 * Description: No Description
 */
@RestController
public class OrderServiceImpl implements OrderService {

	@Autowired
	private MemberFeignClient memberFeignClient;

	@Override
	@RequestMapping("/getOrder")
	public String orderToMember() {
		UserEntity entity = memberFeignClient.getMember("zhangsan");
		System.out.println("线程名称 -------------->:" + Thread.currentThread().getName() + ", OrderService调用MemberService返回值--------------:" + entity.toString());
		return entity.toString();
	}

	//没有解决Hystrix解决降级,熔断的方法
	@RequestMapping("/orderNoHystrix")
	public String orderNoHystrix() {
		return memberFeignClient.getMember("orderNoHystrix").toString();
	}

	/**
	 * 使用Hystrix解决熔断,降级,线程池隔离的接口
	 * 使用@HystrixCommand注解
	 *      @Hystrix默认的情况下就是线程池隔离的方式
	 *      @Hystrix中的 fallbackMethod就是熔断降级的方法
	 */
	@RequestMapping("/orderHystrix")
	@HystrixCommand(fallbackMethod = "orderBack")
	public String orderHystrix(){
		System.out.println("线程名称 -------------->:" + Thread.currentThread().getName());
		return memberFeignClient.getMember("orderHystrix").toString();
	}

	@RequestMapping("/getUserEntity")
	public UserEntity getUserEntity() {
		System.out.println("线程名称 -------------->:" + Thread.currentThread().getName());
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		UserEntity entity = memberFeignClient.getMember("getUserEntity");
		return entity;
	}

	//熔断降级方法,这个方法目前只在Hystrix中的fallbackMethod中指定
	public String orderBack(){
		return "处于高并发下,请稍后重试";
	}
}
