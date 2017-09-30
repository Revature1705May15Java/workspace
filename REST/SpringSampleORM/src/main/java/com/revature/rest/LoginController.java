package com.revature.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.User;
import com.revature.service.UserService;

@RestController
public class LoginController {

	@Autowired
	private UserService userService;

	@PostMapping
	@RequestMapping("/login.do")
	public User login(@RequestBody User user) {
		return userService.login(user);
	} 
}
