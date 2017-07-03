package com.revature.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.model.User;
import com.revature.service.AuthService;

@Controller
public class LoginCtrl {

	@Autowired
	private AuthService authService;
	
	
	@RequestMapping("/login")
	public String loginEVERYTHING(ModelMap modelMap){
		System.out.println("in Login method");
		User user = new User();
		modelMap.addAttribute("user",user);
		return "Login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginPOST(@Valid User user, BindingResult bindingResult, ModelMap modelMap){
		
		if(bindingResult.hasErrors()){
			return "Login";
		}
		
		System.out.println("in Login POST");
		System.out.println(user.getUsername());
		
		User authUser = authService.auth(user);
		
		if(authUser != null){
			//Succesfull login
			return "Home";
		}else{
			modelMap.addAttribute("errorMessage", "Username/Password incorrect");
			return "Login";
		}
		
	}
	
}
