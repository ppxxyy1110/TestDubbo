package com.alibaba.dubbo.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;


//@ComponentScan(basePackages={"com.alibaba.dubbo.demo"})
//@ImportResource({"classpath:dubbo-demo-provider.xml"})
@SpringBootApplication()
public class TestDubboProviderApplication {
	public static void main(String[] args) {
		SpringApplication.run(TestDubboProviderApplication.class, args);
	}
}
