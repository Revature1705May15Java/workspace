package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.User;
import com.revature.repository.UserDao;

@Service("userService")
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public UserService() {}
	
	public User login(User user) {
		User loggedUser = userDao.selectByUsername(user);
		
		if(loggedUser.getUsername().equals(user.getUsername()) &&
				loggedUser.getPassword().equals(user.getPassword())) {
			return loggedUser;
		}
		
		return new User();
	}
}
