package com.robotcoin.pojo;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

/**
 * 订单表
 * @author tngou@tngou.net
 *
 */
@Component
public class Order extends POJO{

	 private int amount 	;//	单个购买价格 	
	 private int avgprice 	;// 	购买数量 	
	 private int dealamount 	;//	交易金额 	
	 private int price 	;//	订单金额 	
	 private int state 	;//	交易类型 -1-已取消，0-未成交，1-部分成交，2-已成交，3-撤销处理中 	
	 private String symbol 	;//		标记 	
	 private int type 	;//	订单类型 0Buy-买，1sell-卖 	
	 private long account 	;//	账号 	
	 private long user 	;//	用户 	
	 private Timestamp time 	;//	时间 	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getAvgprice() {
		return avgprice;
	}
	public void setAvgprice(int avgprice) {
		this.avgprice = avgprice;
	}
	public int getDealamount() {
		return dealamount;
	}
	public void setDealamount(int dealamount) {
		this.dealamount = dealamount;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public long getAccount() {
		return account;
	}
	public void setAccount(long account) {
		this.account = account;
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
