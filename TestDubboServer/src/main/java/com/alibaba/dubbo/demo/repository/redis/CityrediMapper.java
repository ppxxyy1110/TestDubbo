package com.alibaba.dubbo.demo.repository.redis;

import com.alibaba.dubbo.entity.redis.Cityredis;

public interface CityrediMapper {
	Cityredis selectById(Integer id);
	int insert(Cityredis city);
	int update(Cityredis city);
}
