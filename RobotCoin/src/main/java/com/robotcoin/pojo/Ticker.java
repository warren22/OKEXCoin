package com.robotcoin.pojo;

import org.springframework.stereotype.Component;

/**
 * 货币行情表"
 * @author tngou@tngou.net
 *
 */
@Component
public class Ticker extends POJO{

 	private int buy ;// 	买价 	
 	private int high  ;// 	最高价格 	
 	private int last 	 ;// 	最新价格 	
 	private int low 	 ;// 	最低价格 	
 	private int sell 	 ;//  	卖价 	
 	private int vol 	 ;// 	成交量 	
	public int getBuy() {
		return buy;
	}
	public void setBuy(int buy) {
		this.buy = buy;
	}
	public int getHigh() {
		return high;
	}
	public void setHigh(int high) {
		this.high = high;
	}
	public int getLast() {
		return last;
	}
	public void setLast(int last) {
		this.last = last;
	}
	public int getLow() {
		return low;
	}
	public void setLow(int low) {
		this.low = low;
	}
	public int getSell() {
		return sell;
	}
	public void setSell(int sell) {
		this.sell = sell;
	}
	public int getVol() {
		return vol;
	}
	public void setVol(int vol) {
		this.vol = vol;
	}
	
}
