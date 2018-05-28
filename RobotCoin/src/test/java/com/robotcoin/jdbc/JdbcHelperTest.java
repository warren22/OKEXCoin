package com.robotcoin.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.robotcoin.jdbc.JdbcHelper;
import com.robotcoin.pojo.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JdbcHelperTest {
	@Autowired  
	private JdbcHelper jdbchelper;
		@Test
		public void configMap() throws SQLException {
			User rs = jdbchelper.getUser();
			System.err.println(rs);
		}
	}
