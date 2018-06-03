package com.robotcoin.pojo;

import java.sql.Time;
import java.sql.Timestamp;

import org.springframework.stereotype.Component;

/**
 * 策略表
 * @author tngou@tngou.net
 *
 */
@Component
public class Strategy extends POJO{

 	private String name 	;//		名称 	
 	private int lperiod 	;//	轮询周期 	
 	private int currency 	;//		币对id 	
 	private long period 	;//		K线周期 	
 	private int tprice 	;//		成交价格 	
 	private int exchange 	;//		交易所 	
 	private int initialfunds 	;//		起始资金 	
 	private Time tstarttime 	;//		开始交易时间 	
 	private Time tendtime 	;//		开始结束时间 	
 	private int mtposition 	;//	 	单次最大买卖仓位 	
 	private long account 	;//		账号 	
 	private long user 	;//	 	用户 	
 	private Timestamp time 	;//	时间 	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLperiod() {
		return lperiod;
	}
	public void setLperiod(int lperiod) {
		this.lperiod = lperiod;
	}
	public int getCurrency() {
		return currency;
	}
	public void setCurrency(int currency) {
		this.currency = currency;
	}
	public long getPeriod() {
		return period;
	}
	public void setPeriod(long period) {
		this.period = period;
	}
	public int getTprice() {
		return tprice;
	}
	public void setTprice(int tprice) {
		this.tprice = tprice;
	}
	public int getExchange() {
		return exchange;
	}
	public void setExchange(int exchange) {
		this.exchange = exchange;
	}
	public int getInitialfunds() {
		return initialfunds;
	}
	public void setInitialfunds(int initialfunds) {
		this.initialfunds = initialfunds;
	}
	public Time getTstarttime() {
		return tstarttime;
	}
	public void setTstarttime(Time tstarttime) {
		this.tstarttime = tstarttime;
	}
	public Time getTendtime() {
		return tendtime;
	}
	public void setTendtime(Time tendtime) {
		this.tendtime = tendtime;
	}
	public int getMtposition() {
		return mtposition;
	}
	public void setMtposition(int mtposition) {
		this.mtposition = mtposition;
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
