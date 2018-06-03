package com.robotcoin.pojo;

import org.springframework.stereotype.Component;

/**
 * 货币表
 * @author tngou@tngou.net
 *
 */
@Component
public class Currency extends POJO{

	private String symbol 	;// 		币对 	
	private long 	mintradesize 	;//	最小交易单位 	
	private long  	quoteincrement ;//	下单精度 	
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public long getMintradesize() {
		return mintradesize;
	}
	public void setMintradesize(long mintradesize) {
		this.mintradesize = mintradesize;
	}
	public long getQuoteincrement() {
		return quoteincrement;
	}
	public void setQuoteincrement(long quoteincrement) {
		this.quoteincrement = quoteincrement;
	}
	
}
