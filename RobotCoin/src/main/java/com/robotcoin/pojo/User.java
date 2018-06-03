package com.robotcoin.pojo;

import java.sql.Date;
import java.sql.Timestamp;

import org.springframework.stereotype.Component;

/**
 * 用户表
 * @author tngou@tngou.net
 *
 */
@Component
public class User extends POJO{

	 private String name 	;//	用户姓名 	
	 private int role 	;//	人员类型 0-普通 1-管理员 	
	 private String account;//			登陆手机 手机号 	
	 private String password ;//			密码 	
	 private String nick 	;//			昵称 	
	 private int sex 	;//		性别 0-未知 1-男 2-女 	
	 private String idnum 	;//	 		身份证 	
	 private Date birthday ;//		出生日期 	
	 private String phone 	;//			电话 	
	 private String wechat ;//			微信 	
	 private String qq 	;//			QQ 	
	 private String email 	;//		电子邮箱 	
	 private String address 	;//			地址 	
	 private String headportrait 	;//	 		头像 	
	 private Timestamp time 	 	;//	添加时间 	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getIdnum() {
		return idnum;
	}
	public void setIdnum(String idnum) {
		this.idnum = idnum;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getWechat() {
		return wechat;
	}
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHeadportrait() {
		return headportrait;
	}
	public void setHeadportrait(String headportrait) {
		this.headportrait = headportrait;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	
}
