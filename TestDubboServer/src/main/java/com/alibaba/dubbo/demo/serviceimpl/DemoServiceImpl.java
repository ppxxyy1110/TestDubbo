package com.alibaba.dubbo.demo.serviceimpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.demo.DemoService;


@Service(protocol="dubbo-jvm",registry="test2")
public class DemoServiceImpl implements DemoService{

	public String sayHello(String name) {
		return "hi i am here " + name;
	}

}
