package com.alibaba.dubbo.demo.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.demo.RedisService;
import com.alibaba.dubbo.entity.redis.Cityredis;

@Service
public class RedisServiceImpl implements RedisService{

	public static String KEY_CITYREDIS = "Cityredis";
	@Autowired
	private RedisTemplate<Object,Object> redisTemplate;
	
	@Override
	public Cityredis getCitybyId(String id) {
		return (Cityredis)redisTemplate.opsForHash().get(KEY_CITYREDIS, id);
	}

	@Override
	public boolean insertCity(Cityredis city) {
		String id = city.getId();
		redisTemplate.opsForHash().put(KEY_CITYREDIS,id,city);
		Cityredis returnCity = (Cityredis) redisTemplate.opsForHash().get(KEY_CITYREDIS, id);
		if(returnCity == null || returnCity.getId()==null){
			return false;
		}else{
			return true;
		}
	}

}
