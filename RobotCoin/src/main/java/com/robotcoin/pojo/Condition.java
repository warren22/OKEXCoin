package com.robotcoin.pojo;

import org.springframework.stereotype.Component;

/**
 * 策略条件表
 * @author tngou@tngou.net
 *
 */
@Component
public class Condition extends POJO{

 	private long strategy 	;//	策略ID 	
 	private int  dealtype 	;//	交易类型 0-买入 1-卖出 	
	private String type 	;//		参数类型 行情、技术指标、持仓指标、日历指标、自定义 	
	private String unit 	;// 		单位 如：% 、万…… 	
	private String comparison 	;// 	默认比较符 如：大于，小于…… 	
	private int  value 	;// 	默认值 	
	public long getStrategy() {
		return strategy;
	}
	public void setStrategy(long strategy) {
		this.strategy = strategy;
	}
	public int getDealtype() {
		return dealtype;
	}
	public void setDealtype(int dealtype) {
		this.dealtype = dealtype;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getComparison() {
		return comparison;
	}
	public void setComparison(String comparison) {
		this.comparison = comparison;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
}
