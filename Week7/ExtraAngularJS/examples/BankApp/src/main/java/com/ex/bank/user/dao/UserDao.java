package com.ex.bank.user.dao;

import com.ex.bank.user.domain.User;

public interface UserDao {
	
	public User findUserByUsername(String username);
	public void createUser(User user);
	
}
