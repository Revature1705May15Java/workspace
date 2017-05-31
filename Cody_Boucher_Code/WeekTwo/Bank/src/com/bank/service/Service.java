package com.bank.service;

import java.time.LocalDate;
import java.util.ArrayList;

import com.bank.dao.DAO;
import com.bank.dao.DaoImpl;
import com.bank.pojos.Account;
import com.bank.pojos.User;

public class Service {
	//rough service layer outline, no security checking like making sure account has money
	static DAO dao = new DaoImpl();

	public User addUser(String firstName, String lastName, String userName, String password) {
		User temp = new User();
		temp = dao.getUser(userName);
		if(temp != null) {
			//username exists, prompt user to change username or login
			System.out.println("Username must be unique!");
		}
		else {
			dao.addUser(firstName, lastName, userName, password);
		}
		return dao.getUser(userName);
	}
	
	public Account getAccount(int accountId) {
		return dao.getAccount(accountId);
	}
	
	public ArrayList<Account> getAllAccounts(User user) {
		return dao.getAllAccounts(user);
	}
	
	public Account addAccount(User user, int typeId) {
		return dao.addAcount(user, typeId);
	}
	
	public Account withdraw(Account account, double amount) {
		Account temp = new Account(account.getId(), (account.getBalance() - amount), account.getType(), account.getOpenDate(), null);
		return dao.upDateAccount(temp);
	}
	
	public Account deposit(Account account, double amount) {
		Account temp = new Account(account.getId(), (account.getBalance() + amount), account.getType(), account.getOpenDate(), null);
		return dao.upDateAccount(temp);
	}
	
	public void closeAccount(Account account) {
		Account temp = new Account(account.getId(), account.getBalance(), account.getType(), account.getOpenDate(), LocalDate.now());
		temp.setCloseDate(temp.getCloseDate());
	}
	
	public Account transfer(Account account, int recievingAccount, double amount) {
		Account temp = new Account(account.getId(), (account.getBalance() - amount), account.getType(), account.getOpenDate(), null);
		dao.transfer(account.getId(), recievingAccount, amount);
		return temp;    
	}
	
}
