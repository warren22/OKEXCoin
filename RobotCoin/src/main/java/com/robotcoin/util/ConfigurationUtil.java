package com.robotcoin.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;

/**
 * 取得配置文件
 * @author tngou
 *
 */
public class ConfigurationUtil {

	public static Map<String, Object> map(String name) {
		Map<String, Object> map = new HashMap<>();
		Configuration config=config(name);
		if(config==null) return map;	
		Iterator<String> iterable = config.getKeys();// 取得配置文件中的key
		// 遍历赋值 dbProperties ——》cp_props
		while (iterable.hasNext()) {
			String skey = iterable.next();
			map.put(skey, config.getString(skey));
		}
		return map;	
	}
	public static Configuration config(String name) {
		Parameters params = new Parameters();
		FileBasedConfigurationBuilder<FileBasedConfiguration> builder =
		    new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class)
		    .configure(params.properties()
		        .setFileName(name).setEncoding("UTF-8"));
			Configuration config;
			try {
				config = builder.getConfiguration();	
				return config;
			} catch (ConfigurationException e) {
				e.printStackTrace();
				return null;
			}
			
	}
}
