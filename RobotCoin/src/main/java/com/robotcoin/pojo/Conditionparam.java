package com.robotcoin.pojo;

import org.springframework.stereotype.Component;

/**
 * 策略条件参数表
 * @author tngou@tngou.net
 *
 */
@Component
public class Conditionparam extends POJO{

	 private String unit 	;//		单位 	
	 private int value 	;//	 	参数值 	
	 private String paramname 	;//			参数名称 	
	 private String remark 	;//	 		备注 	
	 private long  conditionid 	;//	 	策略条件表id 	
	 private long strategy 	;//		策略id 	
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getParamname() {
		return paramname;
	}
	public void setParamname(String paramname) {
		this.paramname = paramname;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public long getConditionid() {
		return conditionid;
	}
	public void setConditionid(long conditionid) {
		this.conditionid = conditionid;
	}
	public long getStrategy() {
		return strategy;
	}
	public void setStrategy(long strategy) {
		this.strategy = strategy;
	}
	
}
