package com.ex.dao;

import java.util.List;

import com.ex.pojos.Reimbursement;
import com.ex.pojos.User;

public interface Dao {

	void addUser(User u);

	void addReimbursement(Reimbursement r);
	
	public List<User> getAllUsers();

}