package com.alibaba.dubbo.demo;

import java.util.List;

import com.alibaba.dubbo.entity.redis.Cityredis;

public interface RedisService {
	List<Cityredis> getCitybyId(Integer id);
	
	boolean insertCity(Cityredis city);
}
