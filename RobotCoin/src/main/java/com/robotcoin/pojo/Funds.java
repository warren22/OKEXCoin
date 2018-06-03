package com.robotcoin.pojo;

import org.springframework.stereotype.Component;

/**
 * 余额表
 * @author tngou@tngou.net
 *
 */
@Component
public class Funds extends POJO{

 	private int type 	;//	余额类型 0-free（账户可用余额） 1-freezed（账户冻结余额） 	
 	private long product 	;//	币对id 	
 	private int balance 	;//	余额 	
 	private long user 	;// 	用户 	
 	private long account 	;//	账户 
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public long getProduct() {
		return product;
	}
	public void setProduct(long product) {
		this.product = product;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public long getUser() {
		return user;
	}
	public void setUser(long user) {
		this.user = user;
	}
	public long getAccount() {
		return account;
	}
	public void setAccount(long account) {
		this.account = account;
	}
	
}
