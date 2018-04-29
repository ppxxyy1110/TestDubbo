package com.alibaba.dubbo.demo;

import com.alibaba.dubbo.entity.mysql.City;

public interface MysqlService {

	City getCitybyId(Integer id);
	
	boolean insertCity(City city);
}
