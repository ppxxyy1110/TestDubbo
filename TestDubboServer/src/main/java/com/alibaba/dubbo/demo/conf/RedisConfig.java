package com.alibaba.dubbo.demo.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import redis.clients.jedis.JedisPoolConfig;

/**
 * 
 * @author Administrator
 *
 */

//@PropertySource("classpath:redis.properties")
//@PropertySource("classpath:/redis.properties")
//@PropertySource("redis.properties")
//@PropertySource(value = { "classpath:redis.properties" })
//@ConfigurationProperties(prefix="redis.")
//@ConfigurationProperties(prefix="redis")
//@ConfigurationProperties(prefix="classpath:redis.properties")
//@ConfigurationProperties
@Configuration
public class RedisConfig {

    @Value("${redis.host}")
    private String host;
    
    @Value("${redis.port}")
    private Integer port;
    
    @Value("${redis.pass:null}")
    private String pass;
    
    @Value("${redis.dbIndex}")
    private Integer dbIndex;
    
    @Value("${redis.expiration}")
    private String expiration;
    
    @Value("${redis.maxIdle}")
    private Integer maxIdle;
	
    @Value("${redis.maxActive}")
    private Integer maxActive;
    
    @Value("${redis.maxWait}")
    private Integer maxWait;
    
    @Value("${redis.testOnBorrow}")
    private Boolean testOnBorrow;
    
    
//    @Value("${host}")
//    private String host;
//    
//    @Value("${port}")
//    private Integer port;
//    
//    @Value("${pass}")
//    private String pass;
//    
//    @Value("${dbIndex}")
//    private Integer dbIndex;
//    
//    @Value("${expiration}")
//    private String expiration;
//    
//    @Value("${maxIdle}")
//    private Integer maxIdle;
//	
//    @Value("${maxActive}")
//    private Integer maxActive;
//    
//    @Value("${maxWait}")
//    private Integer maxWait;
//    
//    @Value("${testOnBorrow}")
//    private Boolean testOnBorrow;
    
    @Bean("poolConfig")
	public JedisPoolConfig jedisPoolConfig(){
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		if(maxIdle!=null){
			jedisPoolConfig.setMaxIdle(maxIdle);
		}
		if(maxActive!=null){
			jedisPoolConfig.setMaxTotal(maxActive);
		}
		if(maxWait!=null){
			jedisPoolConfig.setMaxWaitMillis(maxWait);
		}
		if(testOnBorrow!=null){
			jedisPoolConfig.setTestOnBorrow(testOnBorrow);
		}
		return jedisPoolConfig;
	}
    
    @Bean("jedisConnectionFactory")
    public JedisConnectionFactory jedisConnectionFactory(JedisPoolConfig jedisPoolConfig){
    	JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
    	jedisConnectionFactory.setHostName(host);
    	jedisConnectionFactory.setPort(port);
    	if(pass!=null && !"null".equals(pass)){
        	jedisConnectionFactory.setPassword(pass);
    	}
    	jedisConnectionFactory.setDatabase(dbIndex);
    	jedisConnectionFactory.setPoolConfig(jedisPoolConfig);
    	return jedisConnectionFactory;
    }
    
    
    @Bean("RedisTemplate")
    public RedisTemplate<Object,Object> redisTemplate(JedisConnectionFactory jedisConnectionFactory){
    	RedisTemplate<Object,Object> redisTemplate = new RedisTemplate<Object,Object>();
    	redisTemplate.setConnectionFactory(jedisConnectionFactory);
    	return redisTemplate;
    }
}
