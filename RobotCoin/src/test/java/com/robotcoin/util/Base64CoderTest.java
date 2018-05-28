package com.robotcoin.util;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.robotcoin.util.Base64Coder;
@RunWith(SpringRunner.class)
@SpringBootTest
public class Base64CoderTest {
	@Test
	public void test() {
		Base64Coder coder = new Base64Coder();
		String s = "aHR0cDovL3d3dy55eXRhbGlhbmNlLmNvbS93ZWNhdC9kaWFnbm9zaXM";

		String s1 = "http://www.yytaliance.com/wecat/dianosis?";
		System.out.println(Base64Coder.encodeBase64OfUrlSafe(s1));

		System.out.println(Base64Coder.decodeUrlBase64Safe(s));
		System.out.println(Base64Coder.decodeBase64(Base64Coder.encodeBase64(s)));
		System.out.println(Base64Coder.encodeBase64(s));
		System.out.println(Base64Coder.encodeUrlBase64(s));
		// System.out.println(decodeBase64(s));
		// System.out.println(encodeUrlBase64(s));
		// System.out.println(encodeUrlBase64Safe(s));
		// System.out.println(decodeUrlBase64(encodeUrlBase64(s)));
		// System.out.println(decodeUrlBase64Safe(encodeUrlBase64Safe(s)));
		System.err.println(new Date().getTime() / 1000);

	}
}
