package com.ex.bank.user.service;

import com.ex.bank.user.dto.UserDto;

public interface UserService {
	
	public UserDto authenticateUser(UserDto userDto);
	public void createUser(UserDto userDto);

}
