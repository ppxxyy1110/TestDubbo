package com.alibaba.dubbo.entity.redis;

import java.io.Serializable;

public class Cityredis implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5177927116418693768L;
	private String id;
	private String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
