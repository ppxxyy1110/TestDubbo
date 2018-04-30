package com.alibaba.dubbo.demo;

import com.alibaba.dubbo.entity.redis.Cityredis;

public interface RedisService {
	Cityredis getCitybyId(String id);
	
	boolean insertCity(Cityredis city);
}
