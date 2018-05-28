package com.robotcoin.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.robotcoin.util.DigestSHA;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShaTest {
	@Test
	public void test() throws NoSuchAlgorithmException {
		// TODO Auto-generated method stu
			String s="81977100";
			System.out.println(DigestSHA.SHA1(s));
			System.out.println(DigestSHA.SHA224(s).length());
			System.out.println(DigestSHA.SHA256(s).length());
			System.out.println(DigestSHA.SHA384(s));
			System.out.println(DigestSHA.SHA512(s));
			//System.out.println(SHA1(new File("G://软件备份/eclipse-jee-juno-win32.zip")));
			String val="123";
			// 用来将字节转换成 16 进制表示的字符
		     char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
			 MessageDigest md = MessageDigest.getInstance("SHA1"); 
			 md.update(val.getBytes()); // 通过使用 update 方法处理数据,使指定的 byte数组更新摘要
		      byte[] encryptStr = md.digest(); // 获得密文完成哈希计算,产生128 位的长整数
		      char str[] = new char[16 * 2]; // 每个字节用 16 进制表示的话，使用两个字符
		      int k = 0; // 表示转换结果中对应的字符位置
		      for (int i = 0; i < 16; i++) { // 从第一个字节开始，对每一个字节,转换成 16 进制字符的转换
		        byte byte0 = encryptStr[i]; // 取第 i 个字节
		        str[k++] = hexDigits[byte0 >>> 4 & 0xf]; // 取字节中高 4 位的数字转换, >>> 为逻辑右移，将符号位一起右移
		        str[k++] = hexDigits[byte0 & 0xf]; // 取字节中低 4 位的数字转换
		      }
		        System.err.println( new String(str));; // 换后的结果转换为字符串
		}
}
