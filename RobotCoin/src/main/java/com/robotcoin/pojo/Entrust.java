package com.robotcoin.pojo;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

/**
 * 委托表
 * @author tngou@tngou.net
 *
 */
@Component
public class Entrust extends POJO{

 	private String type 	;//	委托类型 	
 	private int enprice 	;// 	委托价格 	
 	private int encount 	;// 	委托总量 	
 	private int ensum 	;// 	委托金额 	
 	private int dealprice 	;//	成交均价 	
 	private int dealcount 	;// 	成交数量 	
 	private String direction 	;//		方向 	
 	private String coin 	;//		币对 	
 	private int state 	;//	委托状态 	
 	private long user 	;// 	添加用户 	
 	private Timestamp time ;//	时间 	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getEnprice() {
		return enprice;
	}
	public void setEnprice(int enprice) {
		this.enprice = enprice;
	}
	public int getEncount() {
		return encount;
	}
	public void setEncount(int encount) {
		this.encount = encount;
	}
	public int getEnsum() {
		return ensum;
	}
	public void setEnsum(int ensum) {
		this.ensum = ensum;
	}
	public int getDealprice() {
		return dealprice;
	}
	public void setDealprice(int dealprice) {
		this.dealprice = dealprice;
	}
	public int getDealcount() {
		return dealcount;
	}
	public void setDealcount(int dealcount) {
		this.dealcount = dealcount;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getCoin() {
		return coin;
	}
	public void setCoin(String coin) {
		this.coin = coin;
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
