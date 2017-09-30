package com.revature.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MasterController {

	@GetMapping
	@RequestMapping("/login.view")
	public String getLoginView(){
		return "login";
	}
	
	@GetMapping
	@RequestMapping("/home.view")
	public String getHomeView(){
		return "home";
	}
	
}
