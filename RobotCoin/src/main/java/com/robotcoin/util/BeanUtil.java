package com.robotcoin.util;

import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

/**
 * Bean Map转换
 * @author tngou@tngou.net
 *
 */
public class BeanUtil {


	/**
	 * 转换
	 * @param bean
	 * @param properties
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public static void populate(Object bean, Map<String, ? extends Object> properties) throws IllegalAccessException, InvocationTargetException{
		ConvertUtils.register(new BeanUtil().new MyTimestamp(), Timestamp.class); //时间处理
        ConvertUtils.register(new BeanUtil().new MyDate(), Date.class); 
		BeanUtilsBean.getInstance().populate(bean, properties);
	}
	
	/**
	 * 时间
	 * @author tngou@tngou.net
	 *
	 */
	class MyTimestamp implements Converter{

		@SuppressWarnings({ "unchecked", "hiding" })
		@Override
		public <Timestamp> Timestamp convert(Class<Timestamp> paramClass, Object paramObject) {
			LocalDateTime localDateTime = DateUtil.parse(paramObject.toString());
			if(localDateTime==null) return null;
			return  (Timestamp) DateUtil.toTimestamp(localDateTime);
		}
		
	}
	class MyDate implements Converter{

		@SuppressWarnings({ "unchecked", "hiding" })
		@Override
		public <Date> Date convert(Class<Date> paramClass, Object paramObject) {
			LocalDateTime localDateTime = DateUtil.parse(paramObject.toString());
			if(localDateTime==null) return null;
			return  (Date) DateUtil.toSqlDate(localDateTime);
		}
		
	}

}

