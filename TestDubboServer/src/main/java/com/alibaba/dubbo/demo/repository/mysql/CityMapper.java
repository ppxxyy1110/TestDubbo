package com.alibaba.dubbo.demo.repository.mysql;

import org.apache.ibatis.annotations.Param;

import com.alibaba.dubbo.entity.mysql.City;

public interface CityMapper {

	City selectById(@Param("id") Integer id);
	int insert(City city);
	int update(City city);
}
