package com.ex.dao;

import com.ex.domain.User;

public interface UserDao {

	User findUserByUsername(String username);

	void createUser(User user);

}