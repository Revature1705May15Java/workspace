package com.bank.dao;

import com.bank.pojo.*;

public interface DAO {
	
	public int updateBalance(Account account, double newbal);
	public int addUser( String fn, String ln, String uname, String pw);
	public User getUser(String uname, String pw);
	public User getUser(int id);
	public Account addAccount(User u, double bal, int type);
	public void showAccounts(int uid);
	public void closeAccount(Account a);
	public int getRecentAccount();//get most recent id to insert into 
	public Account getAccount(int aid);
	public void updateJoin(User u);
}
//SERVICE LAYER
//SHOULD CREATE USER
//GET USER BY USER NAME-OR BY ID
//GETUSERNAME FROM USER