package com.alibaba.dubbo.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication()
public class TestDubboComsumerApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext  ctx = SpringApplication.run(TestDubboComsumerApplication.class, args);
		DemoService demoService = ctx.getBean(DemoService.class);
		String ss = demoService.sayHello("aaaaaaaaa");
		System.out.println(ss);
	}
}
