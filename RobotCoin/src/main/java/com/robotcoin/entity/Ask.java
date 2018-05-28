package com.robotcoin.entity;

import java.io.Serializable;


/**
 * 常用的接受数据对象
 * @author tngou@tngou.net
 *
 */
public class Ask  implements Serializable
{
	 private static final long serialVersionUID = 1L;
	 private long id;
	 private String callback;//Jsonp返回数据
	 private int page =1;//当前页
	 private int rows=20;//其他分页
	 private String keywords; //搜索关键词
	 public String getCallback() {
		return callback;
	 }
	 public void setCallback(String callback) {
		this.callback = callback;
	 }
	 public int getPage() {
		return page;
	 }
	 public void setPage(int page) {
		this.page = page;
	 }
	 public int getRows() {
		return rows;
	 }
	 public void setRows(int rows) {
		this.rows = rows;
	 }
	 public long getId() {
		return id;
	 }
	 public void setId(long id) {
		this.id = id;
	 }
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
 
	 
}
