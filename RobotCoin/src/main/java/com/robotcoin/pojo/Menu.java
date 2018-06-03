package com.robotcoin.pojo;

import org.springframework.stereotype.Component;

/**
 * 菜单表
 * @author tngou@tngou.net
 *
 */
@Component
public class Menu extends POJO{

	 private String name 	;//		菜单名称 	
	 private String	url 	;//	 		菜单URL 	
	 private long	pid 	;//		上级菜单ID 	
	 private int type 	;//	 	菜单等级 1-一级 2-二级 	
	 private int role 	;//	 	用户角色 0-普通 1-管理员 	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public long getPid() {
		return pid;
	}
	public void setPid(long pid) {
		this.pid = pid;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	
}
