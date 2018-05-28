package com.robotcoin.controller.test;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.robotcoin.controller.BaseController;
@RestController
@RequestMapping("/test/json")
public class JsonController extends BaseController {
    
	@RequestMapping("/show") 
	public String show() {
		return run_success("hello world!");
	}
	
	@RequestMapping("/map") 
	public String map() {
		Map<String, Object> map = new HashMap<>();
		String sex=null;
		map.put("name", "陈磊");
		map.put("age", 29);	
		map.put("sex", sex);
		String json = toJsonP(map);
		System.err.println(json);
		return json;
	}
}
