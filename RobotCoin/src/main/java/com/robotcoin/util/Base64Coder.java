package com.robotcoin.util;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.util.encoders.UrlBase64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Base64算法主要用于电子邮件传输、密钥和证书文件的文本方式保存， 在数据保密要求不高的情况下，可以做简单的数据“加密”
 * 
 * @author tngou@tngou.net
 * @version 2012/8/11
 * 
 *          注意： 这里主要用的是bouncy castle 和commons codec 两个插件作为Base64的编码和解码
 *          完全放弃sun自带的Base64编码 Base64 ：主要是否有换行的控制 UrlBase64： 主要是取代的问题 这里我们尽量用
 *          *Safe
 * 
 */
public class Base64Coder {

	private static final Logger logger = LoggerFactory.getLogger(Base64Coder.class);
	private static final String ENCODING = "UTF-8";

	/**
	 * 基本的base64加密
	 * 
	 * @param data
	 * @return
	 */
	public static String encodeBase64(String data) {
		try {
			byte[] b = Base64.encodeBase64(data.getBytes(ENCODING));
			return new String(b, ENCODING);
		} catch (UnsupportedEncodingException e) {
			logger.error("{}取得UTF-8字节错误", data);
			logger.error("异常:{}", e);
		}
		return data;

	}

	public static String encodeBase64OfUrlSafe(String data) {
		try {
			byte[] b = Base64.encodeBase64URLSafe(data.getBytes(ENCODING));
			return new String(b, ENCODING);
		} catch (UnsupportedEncodingException e) {
			logger.error("{}取得UTF-8字节错误", data);
			logger.error("异常:{}", e);
		}
		return data;
	}

	/**
	 * 基本的base64加密 RFC 2045
	 * 
	 * @param data
	 * @return
	 */
	public static String encodeBase64Safe(String data) {
		try {
			byte[] b = Base64.encodeBase64(data.getBytes(ENCODING), true);
			return new String(b, ENCODING);
		} catch (UnsupportedEncodingException e) {
			logger.error("{}取得UTF-8字节错误", data);
			logger.error("异常:{}", e);
		}
		return data;

	}

	/**
	 * 基本的Base64解密
	 * 
	 * @param data
	 * @return
	 */
	public static String decodeBase64(String data) {
		try {
			byte[] b = Base64.decodeBase64(data.getBytes(ENCODING));
			return new String(b, ENCODING);
		} catch (UnsupportedEncodingException e) {
			logger.error("{}取得UTF-8字节错误", data);
			logger.error("异常:{}", e);
		}
		return data;

	}

	/**
	 * 对UrlBase64编码 = 变成 .
	 * 
	 * @param data
	 * @return
	 */
	public static String encodeUrlBase64(String data) {
		try {
			byte[] b = UrlBase64.encode(data.getBytes(ENCODING));
			return new String(b, ENCODING);
		} catch (UnsupportedEncodingException e) {
			logger.error("{}取得UTF-8字节错误", data);
			logger.error("异常:{}", e);
		}
		return data;

	}

	/**
	 * 对UrlBase64解码 . 变成 =
	 * 
	 * @param data
	 * @return
	 */
	public static String decodeUrlBase64(String data) {
		try {
			byte[] b = UrlBase64.decode(data.getBytes(ENCODING));
			return new String(b, ENCODING);
		} catch (UnsupportedEncodingException e) {
			logger.error("{}取得UTF-8字节错误", data);
			logger.error("异常:{}", e);
		}
		return data;

	}

	/**
	 * 对UrlBase64编码 = 变成
	 * 
	 * @param data
	 * @return
	 */
	public static String encodeUrlBase64Safe(String data) {
		try {
			byte[] b = Base64.encodeBase64URLSafe(data.getBytes(ENCODING));
			return new String(b, ENCODING);
		} catch (UnsupportedEncodingException e) {
			logger.error("{}取得UTF-8字节错误", data);
			logger.error("异常:{}", e);
		}
		return data;

	}

	/**
	 * 对UrlBase64解码 变成 =
	 * 
	 * @param data
	 * @return
	 */
	public static String decodeUrlBase64Safe(String data) {
		try {
			byte[] b = Base64.decodeBase64(data.getBytes(ENCODING));
			return new String(b, ENCODING);
		} catch (UnsupportedEncodingException e) {
			logger.error("{}取得UTF-8字节错误", data);
			logger.error("异常:{}", e);
		}
		return data;

	}

	

}
