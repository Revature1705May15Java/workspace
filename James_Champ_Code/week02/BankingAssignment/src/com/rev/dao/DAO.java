package com.rev.dao;

import com.rev.pojos.Account;

public interface DAO {
	public int updateBalance(Account account, double newBalance);
	public int addUser(String firstName, String lastName, String password, String email);
}
