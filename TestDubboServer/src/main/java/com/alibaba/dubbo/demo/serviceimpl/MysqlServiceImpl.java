package com.alibaba.dubbo.demo.serviceimpl;

import com.alibaba.dubbo.demo.MysqlService;
import com.alibaba.dubbo.demo.repository.mysql.CityMapper;
import com.alibaba.dubbo.entity.mysql.City;

public class MysqlServiceImpl implements MysqlService{
	
	private CityMapper cityMapper;

	@Override
	public City getCitybyId(Integer id) {
		return cityMapper.selectById(id);
	}

	@Override
	public boolean insertCity(City city) {
		return cityMapper.insert(city) > 0;
	}

}
