package com.example.demo.controlers;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class DemoController {

    

    @RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		return "home";
	}

    
    
}
