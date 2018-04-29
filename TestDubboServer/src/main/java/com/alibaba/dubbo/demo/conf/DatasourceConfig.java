/**   
 * @Title: DatasourceConfig.java 
 * @Package com.midea.smart.ouer.config 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author A18ccms A18ccms_gmail_com   
 * @date 2018年4月18日 下午1:54:44 
 * @version V1.0   
 */
package com.alibaba.dubbo.demo.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;

/** 
 * @ClassName: DatasourceConfig 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author yu.liu
 * @date 2018年4月18日 下午1:54:44 
 *  
 */
@ConfigurationProperties(prefix="spring.datasource")
public class DatasourceConfig {

	private String driverClassName;
	private String url;
	private String username;
	private String password;
	public String getDriverClassName() {
		return driverClassName;
	}
	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
