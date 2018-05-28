package com.robotcoin.controller.test;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.robotcoin.controller.BaseController;
@Controller
@RequestMapping("/test/ftl")
public class FtlController extends BaseController {
    
	@RequestMapping(value = "/index", method = RequestMethod.GET) 
	public String index(ModelMap model) {
		//ModelMap model = new ModelMap();
		model.addAttribute("cityName","成都！");
		return printFreemarker(model,"index");
	}
	
	@RequestMapping(value = "/index2", method = RequestMethod.GET) 
	public String index2(ModelMap model) {
		//ModelMap model = new ModelMap();
		model.addAttribute("cityName","成都！");
		return printFreemarker(model,"index");
	}
	
}
