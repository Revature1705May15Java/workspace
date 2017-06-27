package com.ex.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {


	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String loginMethod(HttpServletRequest request,
			ModelMap map){
		
		if(request.getParameter("username").equals("dan") &&
				request.getParameter("password").equals("pickles")){
			// store username in ModelMap
			map.put("username", request.getParameter("username"));
			// send them to next jsp
			return "home";
		}else{
			return "index";
		}
	}


}
