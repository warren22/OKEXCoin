package com.robotcoin.controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.robotcoin.controller.BaseController;

@Controller
@RequestMapping("/test/jump")
public class JumpController extends BaseController {

	@RequestMapping("/redirect") 
	public String redirect() {	
		
		return redirect("http://127.0.0.1:8080/tngou/test/json/show"); 
	}
	@RequestMapping("/forward") 
	public String forward() {			
		return forward("/test/json/show"); 
	}
}
