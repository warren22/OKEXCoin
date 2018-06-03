package com.robotcoin.pojo;


import java.sql.Timestamp;

import org.springframework.stereotype.Component;

/**
 * 消息
 * @author tngou@tngou.net
 *
 */
@Component
public class Msg extends POJO{

 	private long user 	;// 	用户 	
 	private String content 	;//  	消息内容 	
 	private int isread 		;//  	是否阅读 0-未读 1-已读 	
 	private int type 		;// 	类型 1-系统 2-普通 	
 	private Timestamp 	time	;// 	时间 	
	public long getUser() {
		return user;
	}
	public void setUser(long user) {
		this.user = user;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getIsread() {
		return isread;
	}
	public void setIsread(int isread) {
		this.isread = isread;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	
}
