package com.ex.bank.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.bank.user.dao.UserDao;
import com.ex.bank.user.domain.User;
import com.ex.bank.user.dto.UserDto;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDaoImpl;

	@Override
	public UserDto authenticateUser(UserDto userDto) {
		User user = userDaoImpl.findUserByUsername(userDto.getUsername());
		if(user != null && user.getPassword().equals(userDto.getPassword())){
			userDto.setAuthenticated(true);
			userDto.setPassword(null);
		}else{
			userDto.setPassword(null);
		}
		return userDto;
	}

	@Override
	public void createUser(UserDto userDto) {
		User user = new User();
		user.setUsername(userDto.getUsername());
		user.setPassword(userDto.getPassword());
		userDaoImpl.createUser(user);
	}

}
