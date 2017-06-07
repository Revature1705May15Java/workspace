package com.ers.dao;

import com.ers.pojo.User;

public interface Dao {
	User getUser(String username);
	User getUser(int id);
	
}
