package com.bank.dao;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import com.bank.pojo.*;

public interface DAO {
	
	double updateBalance(Account account, double newbal);
	int addUser( String fn, String ln, String uname, String pw);
	User getUser(String uname, String pw);
	User getUser(int id);
	void addAccount(User u, double bal, int type);
	ArrayList<Account> showAccounts(int uid);
	boolean closeAccount(Account a);
	int getRecentAccount();//get most recent id to insert into 
	Account getAccount(int aid);
	void updateJoin(User u,  int accountId);
	double getBalance(Account account);
	ArrayList<User> getAllUserOnAccount(Account a);
	boolean addUserToAccount(Account a, int userId) throws SQLIntegrityConstraintViolationException;
	boolean checkClosedAccount(Account a);
}
//SERVICE LAYER
//SHOULD CREATE USER
//GET USER BY USER NAME-OR BY ID
//GETUSERNAME FROM USER