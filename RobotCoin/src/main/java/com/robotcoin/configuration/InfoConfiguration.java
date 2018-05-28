package com.robotcoin.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

//加上注释@Component，可以直接在其他地方使用@Autowired来创建其实例对象  
@Component  
@ConfigurationProperties(prefix = "info")
@PropertySource("classpath:info.properties")
public class InfoConfiguration {
	private String title;
	private String keywords;
	private String description;
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	} 
}
