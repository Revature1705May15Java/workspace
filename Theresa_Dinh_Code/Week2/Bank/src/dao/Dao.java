package dao;

import pojos.Account;
import pojos.User;

public interface Dao 
{
	public int updateBalance(Account account, double newBalance);
	public User addUser(User newUser); 
	public User addUser(String fn, String ln, String pw, String email); 
//	public User getUser(String email); 
}