package com.robotcoin.pojo;

import org.springframework.stereotype.Component;

/**
 * 周期表
 * @author tngou@tngou.net
 *
 */
@Component
public class Period extends POJO{

 	private int value 	;//	周几值 	
 	private int unit ;// 	周期单位 0-分钟 1-小时 2-日 3-周 4-月 	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getUnit() {
		return unit;
	}
	public void setUnit(int unit) {
		this.unit = unit;
	}
	
}
