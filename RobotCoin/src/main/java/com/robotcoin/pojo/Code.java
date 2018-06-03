package com.robotcoin.pojo;

import org.springframework.stereotype.Component;

/**
 * 数据字典信息表
 * @author tngou@tngou.net
 *
 */
@Component
public class Code extends POJO{

	 private long fcodeid 	;//	父ID 	
	 private String field 	;//		对照字段 	
	 private String	fieldname 	;//		对照字段名称 	
	 private String	code 	;//		代码 	
	 private String	codedesc 	;//		代码描述（中文） 	
	 private int	enabled 	;//	(0:禁用;1:启用) 	
	 private int	seq 	;//	排序 0-1-2…… 	
	public long getFcodeid() {
		return fcodeid;
	}
	public void setFcodeid(long fcodeid) {
		this.fcodeid = fcodeid;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getFieldname() {
		return fieldname;
	}
	public void setFieldname(String fieldname) {
		this.fieldname = fieldname;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCodedesc() {
		return codedesc;
	}
	public void setCodedesc(String codedesc) {
		this.codedesc = codedesc;
	}
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	
}
