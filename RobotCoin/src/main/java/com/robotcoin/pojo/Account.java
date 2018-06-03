package com.robotcoin.pojo;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

/**
 * 账号
 * @author tngou@tngou.net
 *
 */
@Component
public class Account extends POJO{

	 private String name 	;//		账户名称 	
	 private int institution 	;//	0 	机构类型 机构 	
	 private String apikey 	;//		Access Key 	
	 private String secretkey 	;//		Secret Key 	
	 private long	user 	;//	用户 	
	 private Timestamp	time 	;// 添加时间 	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getInstitution() {
		return institution;
	}
	public void setInstitution(int institution) {
		this.institution = institution;
	}
	public String getApikey() {
		return apikey;
	}
	public void setApikey(String apikey) {
		this.apikey = apikey;
	}
	public String getSecretkey() {
		return secretkey;
	}
	public void setSecretkey(String secretkey) {
		this.secretkey = secretkey;
	}
	public long getUser() {
		return user;
	}
	public void setUser(long user) {
		this.user = user;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	
}
