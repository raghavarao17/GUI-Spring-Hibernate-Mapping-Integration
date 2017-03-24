package com.spring.hibernate.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/index")
public class HelloSecurityController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String executeSecurity(ModelMap model) {
 
		model.addAttribute("message", "Spring Security Hello World");
		model.addAttribute("author", "By Spring Security");
		return "index";
 
	}
}
