package com.alibaba.dubbo.demo.service;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.demo.DemoService;

@Service
public class TestConsumerService {
	// 使用dubbo原生注入
	@Reference
	public DemoService demoService;
	
	
	public String test(){
		return demoService.sayHello("test on ");
	}
}
