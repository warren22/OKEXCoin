package com.robotcoin.jdbc;

import org.apache.commons.lang3.StringUtils;

import com.robotcoin.pojo.POJO;

/**
 * 变形器
 * @author tbgou@tngou.net
 *
 */
public class Inflector 
{
   
   public static Inflector  getInstance()
	{
			  return  new Inflector();
	}
   		
   		/**
   		 *   取得类的名称
    * @param cl 类
    * @return 类的名称
    	*/
   public String tableize(Class<? extends POJO> cl)
	   {
	  // String[] cls = StringUtils.split(cl.getName(), ".");
			return  StringUtils.lowerCase(cl.getSimpleName());
	   	}
   
   public String fullyQualifiedName(Class<? extends POJO> cl)
   {
  // String[] cls = StringUtils.split(cl.getName(), ".");
		return  StringUtils.lowerCase(cl.getSimpleName())+"_List";
   	}

 
}
