package com.bank.dao;
import java.util.ArrayList;

import com.bank.pojos.Account;
import com.bank.pojos.AccountType;
import com.bank.pojos.User;

public interface DAO {
	public int updateBalance (Account account, double newbal);
	public int addUser(String fn, String ln, String uname, String pw);
	public User getUser(String uname);
	public User getUser(int id);
	public Account getAccByAccId(int acc_id );
	public int recentCreated();
	AccountType getTypeName(int typeId);
	void addUserAccount(int userId, int accountId);
	Account addAccount(int userId, int type_id);
	ArrayList<Account> getAllAccounts(int currId);

}