package com.robotcoin.controller.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.robotcoin.controller.BaseController;

@RestController
@RequestMapping("/test")
public class HelloWorldController extends BaseController{
	
    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }
}