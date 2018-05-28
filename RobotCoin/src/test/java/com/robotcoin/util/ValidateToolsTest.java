package com.robotcoin.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.robotcoin.util.ValidateTools;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ValidateToolsTest {
	@Test
	 public void test() {
		System.err.println(ValidateTools.Mobile("3880334484"));
	}
}
