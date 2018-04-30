/**   
 * @Title: AppConfiguation.java 
 * @Package com.midea.smart.ouer.config 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author A18ccms A18ccms_gmail_com   
 * @date 2018年4月17日 上午10:44:55 
 * @version V1.0   
 */
package com.alibaba.dubbo.demo.conf;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;


@Configuration
@EnableConfigurationProperties({DatasourceConfig.class/*,RedisConfig.class*/})
@ImportResource({"classpath:dubbo-demo-provider.xml"})
@PropertySource(value = { "classpath:redis.properties" })
public class AppConfiguation {

}
