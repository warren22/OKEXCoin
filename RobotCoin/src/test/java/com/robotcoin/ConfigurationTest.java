package com.robotcoin;

import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.robotcoin.util.ConfigurationUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConfigurationTest {
	@Test
	public void configMap() {
		Map<String, Object> map = ConfigurationUtil.map("info.properties");
		Set<String> sets = map.keySet();
		sets.forEach(e->{System.err.println(e);});
	}
}
