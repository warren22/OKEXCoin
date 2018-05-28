package com.robotcoin.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.robotcoin.pojo.User;
@Component
public class JdbcHelper {
	 @Autowired
	 private JdbcTemplate jdbcTemplate;

	 public User getUser() {	
		 String sql="SELECT * FROM tngou_user WHERE id = 1";
		 @SuppressWarnings({ "unchecked", "rawtypes" })
		List<User> list = jdbcTemplate.query(sql,  new Object[]{}, new BeanPropertyRowMapper(User.class));
		 if(list!=null && list.size()>0){
			   User account = list.get(0);
	            return account;
	        }else{
	            return null;
	        }
	 }
}
