package com.robotcoin.pojo;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

/**
 * 
 * @author tngou@tngou.net
 *
 */
@Component
public class Robot extends POJO{

 	private String name 	;//	名称 	
 	private long account 	;//	账号 	
 	private long strategy 	;//	策略 	
 	private String currency ;//		货币 	
 	private int cash 	;//		现金 	
 	private int state 	;//	状态 0-未启用，1-启用 	
 	private long user 	;//	否 	0 	用户 	
 	private Timestamp time 		;//		时间 	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getAccount() {
		return account;
	}
	public void setAccount(long account) {
		this.account = account;
	}
	public long getStrategy() {
		return strategy;
	}
	public void setStrategy(long strategy) {
		this.strategy = strategy;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public int getCash() {
		return cash;
	}
	public void setCash(int cash) {
		this.cash = cash;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
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
