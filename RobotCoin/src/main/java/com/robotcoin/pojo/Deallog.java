package com.robotcoin.pojo;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

/**
 * 交易日志表
 * @author tngou@tngou.net
 *
 */
@Component
public class Deallog extends POJO{

		private int tid 	;//	交易生成的id 	
		private long robot 	;//	机器人名称ID 	
		private long strategy 	;// 	策略ID 	
		private int exchange 	;//	交易所 	
		private int type 	;//	交易类型 0buy-买入 1sell-卖出 	
		private int price 	;//	交易价格 	
		private int amount 	;//	交易数量 	
		private long account ;//	账号 	
		private long user 	;// 	用户 	
		private Timestamp time ;// 	
		public int getTid() {
			return tid;
		}
		public void setTid(int tid) {
			this.tid = tid;
		}
		public long getRobot() {
			return robot;
		}
		public void setRobot(long robot) {
			this.robot = robot;
		}
		public long getStrategy() {
			return strategy;
		}
		public void setStrategy(long strategy) {
			this.strategy = strategy;
		}
		public int getExchange() {
			return exchange;
		}
		public void setExchange(int exchange) {
			this.exchange = exchange;
		}
		public int getType() {
			return type;
		}
		public void setType(int type) {
			this.type = type;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		public int getAmount() {
			return amount;
		}
		public void setAmount(int amount) {
			this.amount = amount;
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
