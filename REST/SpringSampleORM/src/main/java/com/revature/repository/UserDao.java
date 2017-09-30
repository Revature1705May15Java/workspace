package com.revature.repository;

import com.revature.model.User;

public interface UserDao {
	public void insert(User user);
	public User selectById(User user);
	public User selectByUsername(User user);
}
