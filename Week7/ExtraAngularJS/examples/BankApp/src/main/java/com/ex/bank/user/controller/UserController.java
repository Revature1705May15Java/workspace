package com.ex.bank.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ex.bank.user.dto.UserDto;
import com.ex.bank.user.service.UserService;

@RestController
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	private UserService userServiceImpl;

	@RequestMapping(value="/auth",method={RequestMethod.POST},
					consumes={MediaType.APPLICATION_JSON_VALUE},
					produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserDto> authenticateUser(@RequestBody UserDto userDto) {

		return new ResponseEntity<UserDto>(
									userServiceImpl.authenticateUser(userDto), 
									HttpStatus.OK
									);
	}
	
	@RequestMapping(value="/register", method={RequestMethod.POST},
					consumes={MediaType.APPLICATION_JSON_VALUE},
					produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto){
		System.out.println("register the new person");
		userServiceImpl.createUser(userDto);
		return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
	}
	
	
	

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Exception> handleException(Exception e) {
		return new ResponseEntity<Exception>(e, HttpStatus.CONFLICT);
	}

}
