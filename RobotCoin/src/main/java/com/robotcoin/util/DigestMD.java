package com.robotcoin.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 用于摘要的MD系列 加密 MD2 MD4 MD5 同时还有MD5 对文件校验
 * @author PICOHOOD1
 * @version 2012/8/11
 *
 */
public class DigestMD {

	private static final Logger logger = LoggerFactory.getLogger(DigestMD.class);
	
	public static String MD2(String data)
	{
		if (data==null) 
		{
			return null;
		}
		
		try {
			
			MessageDigest 	md = MessageDigest.getInstance("MD2");
			byte[] b = md.digest(data.getBytes());	
			return new String(Hex.encode(b));
			
		} catch (NoSuchAlgorithmException e) {
			logger.error("{}MD2加密错误", data);
			logger.error("异常:{}",e);
		} 
		
		return data;
		
	}
	
	/**
	 * MD4 加密 用于bouncy castle
	 * @param data
	 * @return
	 */
	public static String MD4(String data)
	{
		if (data==null) 
		{
			return null;
		}
		Security.addProvider(new BouncyCastleProvider());
		try {
			MessageDigest md = MessageDigest.getInstance("MD4");
			byte[] b = md.digest(data.getBytes());
			return new String(Hex.encode(b));
		} catch (NoSuchAlgorithmException e) {
			logger.error("{}MD4加密错误", data);
			logger.error("异常:{}",e);
		} 
		return data;
		
	}
	
	/**
	 * MD5摘要 用的是commons codec 的MD5
	 * @param data
	 * @return
	 */
	public static String MD5(String data)
	{
		if (data==null) 
		{
			return null;
		}
		//byte[] b= DigestUtils.md5(data);
		return DigestUtils.md5Hex(data);
		
	}
	
	/**
	 * MD5摘要 用的是commons codec 的MD5
	 * @param data
	 * @return
	 */
	public static String MD5(File file) 
	{
		Date st = new Date();
		if (file==null)
		{
			return null;
		}
		
			 String r =null; 
			try {
				FileInputStream  input = new FileInputStream(file);
				r=DigestUtils.md5Hex(input);
				input.close(); 
			} catch (IOException e) {
				logger.error("{}文件MD5加密错误", file.getName());
				logger.error("异常:{}",e);
			}
			
		 
		return r;
	}
	
	
	/**
	 *   MD5 加盟取得后 16位
	 * @param data
	 * @return
	 */
	public static String MD5To16(String data)
	{
	   String p=	MD5(data);
	   if(p==null)
	   {
		   return null;
	   }
	   return p.substring(8, 24);
		
	}
	public static String MD5To4(String data)
	{
	   String p=	MD5(data);
	   if(p==null)
	   {
		   return null;
	   }
	   return p.substring(0, 4);
		
	}
	
	public static String MD5key(String mrecordid,List<String>strings)
	{
		if(mrecordid == null)
		{
			mrecordid="";
		}
		String data = mrecordid+"|";
		for (String string : strings) {
			data = data+string+"_";
		}
		
		return DigestUtils.md5Hex(data);
	}
	/**
	 * 患者咨询交流MD5key
	 * @param mrecordid  病历id
	 * @param strings 交流用户ids
	 * @param type 咨询类型
	 * @return
	 */
	public static String MD5key(String mrecordid,List<String> strings,String type)
	{
		if(mrecordid == null)
		{
			mrecordid="";
		}
		String data = mrecordid+"|";
		for (String string : strings) {
			data = data+string+"_";
		}
		if(type==null){
			type="";
		}
		data = data+"|"+type;
		return DigestUtils.md5Hex(data);
	}
	public static String MD5key(String str){
		return DigestUtils.md5Hex(str);
	}
	

}
