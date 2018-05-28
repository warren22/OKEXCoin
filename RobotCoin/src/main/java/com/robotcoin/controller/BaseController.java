package com.robotcoin.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.robotcoin.configuration.InfoConfiguration;
import com.robotcoin.util.Base64Coder;


/**
 *  基础Controller 
 * @author tngou@tngou.net
 *
 */

public abstract class BaseController {
	protected static final Logger log = LoggerFactory.getLogger(BaseController.class);
	@Autowired 
	protected InfoConfiguration info;	//读取配置文件
	@Value("${url.static.domain}")
	protected String staticUrl; //读取访问URL,静态资源
	@Value("${url.dynamic.domain}")
	protected String dynamicUrl; //读取访问URL,动态资源
	@Value("${url.img.domain}")
	protected String imgUrl; //读取访问URL,图片资源
	
	

	/**
	 * Freemarker处理
	 * @param model map 对象
	 * @param ftl 文件名字
	 * @return
	 */
	protected String printFreemarker(ModelMap root,String ftl) {
		


		root.addAttribute("title", root.getOrDefault("title", info.getTitle()));
		root.addAttribute("keywords", root.getOrDefault("keywords", info.getKeywords()));
		root.addAttribute("description", root.getOrDefault("description", info.getDescription()));
		root.addAttribute("domain",dynamicUrl);
		root.addAttribute("staticdomain",staticUrl);
		root.addAttribute("imgdomain",dynamicUrl);
		root.addAttribute("info",info);
		String url = url(); //取得URL
		root.addAttribute("url",url);
		root.addAttribute("rurl",Base64Coder.encodeBase64Safe(url));
		return printFreemarker(ftl);	
	}
	protected String printFreemarker(String ftl) {
		return ftl;	
	}
	
	
	/**
	 * 取得URL地址，，或者需要调整的地址
	 * 参数url
	 * 当前url
	 * @return
	 */
	protected String url()
	{
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
	    ServletRequestAttributes sra = (ServletRequestAttributes) ra;
	    HttpServletRequest request = sra.getRequest();
	    String url=request.getParameter("url");
	   
//
//	    String url = request.getRequestURL().toString();
//	    String method = request.getMethod();
//	    String uri = request.getRequestURI();
//	    String queryString = request.getQueryString();
//	    log.info("请求开始, 各个参数, url: {}, method: {}, uri: {}, params: {}", url, method, uri, queryString);
		 
	    if(StringUtils.isEmpty(url))  {
			url = request.getRequestURI()+"?"+request.getQueryString();
			 if(url.startsWith(request.getContextPath()))url= url.replaceFirst(request.getContextPath(), "");
	          url=dynamicUrl+url; 
		 }else
		 {
			 url=Base64Coder.decodeUrlBase64Safe(url);//解密URL
		 }
	     return url;
	}
	/**
	 * JSON 转换
	 * @param object
	 * @return
	 */
	protected String toJsonP(Object object)
	{	
		JSONObject jsonObject = (JSONObject) JSON.toJSON(object);
		jsonObject.put("status", true);
		return JSON.toJSONString(jsonObject, SerializerFeature.WriteMapNullValue,SerializerFeature.WriteNullStringAsEmpty,SerializerFeature.WriteNullListAsEmpty,SerializerFeature.WriteNullNumberAsZero);	
	}
	protected String toJsonP(List<?> list) {
		if (list == null)
			list = new ArrayList<>();
		JSONArray array = (JSONArray) JSON.toJSON(list);
		return toJsonP(array);
	}
	protected String toJsonP(JSONArray array) {
		JSONObject jsonObject = new JSONObject();
		String rowsName = "list";
		jsonObject.put(rowsName, array);
		return toJsonP(jsonObject);
	}
	
	/**
	 * 错误提示
	 * @param message
	 * @return
	 */
	protected String run_false(String message) {
		JSONObject obj = new JSONObject();
		obj.put("status", false);
		obj.put("msg", message);
		return toJsonP(obj);

	}
	
	/**
	 * 正确提示
	 * @param message
	 * @return
	 */
	protected String run_success(String message) {
		JSONObject obj = new JSONObject();
		obj.put("status", true);
		obj.put("msg", message);
		return toJsonP(obj);
	}
	
	/**
	 * 未登陆提示
	 * @return
	 */
	protected String run_nologin() {
		JSONObject obj = new JSONObject();
		obj.put("status", true);
		obj.put("msg", "用户认证失败！");
		obj.put("errorcode", 500);
		return toJsonP(obj);
	}
	
	/**
	 * 跳转后浏览器地址栏变化<br>
	 * <p>
	 * 传值出去的话，只能在url中带parameter或者放在session中，无法使用request.setAttribute来传递。<br> 
	 * @param url
	 * 重定向访问的路径 http://127.0.0.1:8080/index.html
	 *            
	 */
	public String redirect(String url) {
		return "redirect:"+url;
		
	}
	/**
	 * Servlet页面跳转的路径是相对路径。forward方式只能跳转到本web应用中的页面上。 <br>
	 * 跳转后浏览器地址栏不会变化。 <br>
	 * 使用这种方式跳转，传值可以使用三种方法：url中带parameter，session，request.setAttribute
	 * @param uri
	 *            跳转的相对路径 如：input.jsp
	 */
	public String forward(String uri) {
		return "forward:"+uri;
	}
	
}
