package com.robotcoin;

import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.robotcoin.configuration.InfoConfiguration;
import com.robotcoin.util.ConfigurationUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RobotCoinApplicationTests {

	@Autowired  
	private InfoConfiguration info;
	@Test
	public void contextLoads() {
		System.err.println(info.getTitle());
	}
	
	

}
