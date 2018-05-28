package com.robotcoin.util;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.robotcoin.util.DigestMD;
@RunWith(SpringRunner.class)
@SpringBootTest
public class MdTest {
	@Test
	public void test() {
			// TODO Auto-generated method stub
			String s="8155001|1001|13880334484|001001001||好帅";
			System.out.println(DigestMD.MD2(s));
			System.out.println(DigestMD.MD5To4(s));
			System.out.println(DigestMD.MD5(s));
			byte[] b = DigestUtils.md5(s);
			System.err.println(DigestUtils.md5Hex(s));
//			File f= new File("G://软件备份/ext-4.1.1-gpl.zip") ;
//			System.out.println(MD5(f));
			//System.out.println(MD51(f));
			LocalDateTime now = LocalDateTime.now().minusHours(3);
			now=LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), now.getHour(), 0);
			//0cdb~8155001|1001|13880334484|001001001||好帅
			System.err.println(now);
			

		}
}
