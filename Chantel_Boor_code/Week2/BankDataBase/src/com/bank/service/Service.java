package com.bank.service;

import java.util.ArrayList;

import com.bank.dao.DAO;
import com.bank.dao.DaoImp;
import com.bank.pojos.Account;
import com.bank.pojos.AccountType;
import com.bank.pojos.User;

public class Service 
{
	
	static DAO dao = new DaoImp ();
	
	//adds user returns true if new one is created or false if account already exists
	public Boolean AddUser (String fn,String ln,String email, String pw)
	{
		User temp = new User();
		
		temp = dao.getUser(email);
		
		if(temp!=null)
		{
			return false;
		}
		else
		{
			dao.addUser(fn, ln, email, pw);
			return true;
		}
		
	}
	
	//finds user in database and returns to login
	public User loginUser (String email, String pass)
	{
		User temp = new User();
		
		temp = dao.getUser(email);
		
		if(temp!=null)
		{
			if(temp.getPw().equals(pass))
			return temp;
			else
				return null;
		}
		else
		{
			
			return null;
		}
	}
	
	//gets list of accounts that belong to a user
	public ArrayList<Account> getAccount (User u)
	{
		int acctNumber = dao.getAccountNumber(u.getId());
		ArrayList<Account> a = new ArrayList<Account>();
		
		if(acctNumber == 0)
		{
			return null;
		}
		
		a = dao.getAccount(u.getId());
		
		return a;
	}
	
	//add an account of specified type for user
	public boolean addAccount (User u,int i)
	{
		int acctNumber = dao.getAccountNumber(u.getId());
		
		if(acctNumber >= 6)
		{
			return false;
		}
		
		dao.addAccount(u, i);
		return true;
	}
	
	//used for returning type options for display
	public ArrayList<AccountType> getTypes ()
	{
		ArrayList <AccountType> t = dao.getTypes();
		
		return t;
	}
	
	//closes specified account
	public boolean closeAccount (int aid)
	{
		Account a = dao.getAccountById(aid);
		
		//checks for this instead of null cause returned empty account will defualt to zero
		if (a.getId() == 0)
			return false;
		
		if(a.getBalance() == 0)
		{
			dao.closeAccount(a.getId());
			return true;
		}
		else
		{
			return false;
		}
			
	}
	
	//takes in account id and shows all users associated with it
	public ArrayList<User> showUsers (int aid)
	{
		Account a = dao.getAccountById(aid);
		
		if (a.getId() == 0)
			return null;
		
		//gets all user ids and puts them into account's array list
		a.setAccount_holders(dao.getUsersIds(a.getId()));
		
		ArrayList<User> users = new ArrayList<User>();
		
		//adds users to user array and returns

			for(int i =0; i<a.getAccount_holders().size();i++)
			{
				users.add(dao.getUserByID(a.getAccount_holders().get(i)));
			}
		
		return users;
	}
	
	//adds a specified user to existing account
	public boolean addUserToAccount (String email, int aid)
	{
		//checks if there are too many users
		ArrayList<User> users = showUsers(aid);
		
		if(users == null || users.size() >= 4)
			return false;
		
		//checks that user exists
		User u = dao.getUser(email);
		if(u == null)
		return false;
		
		//checks if user has too many accounts
		int aNum = dao.getAccountNumber(u.getId());
		
		if(aNum >= 6)
			return false;
		
		dao.addAccountUser(u.getId(),aid);
		
		return true;
	}

	public boolean withdraw(int aid, double amount)
	{
		Account a = dao.getAccountById(aid);
		
		//checks for this instead of null cause returned empty account will defualt to zero
		if (a.getId() == 0)
			return false;
		
		a.setBalance(a.getBalance() - amount);
		
		dao.updateBalance(a);
		
		return true;
	}
	
	//adds specified amount to account
	public boolean deposit(int aid, double amount)
	{
		Account a = dao.getAccountById(aid);
		
		//checks for this instead of null cause returned empty account will defualt to zero
		if (a.getId() == 0)
			return false;
		
		a.setBalance(a.getBalance() + amount);
		
		dao.updateBalance(a);
		
		return true;
	}
	
	public boolean transfer(int from, int to,double amount)
	{
		Account a = dao.getAccountById(from);
		
		//checks for this instead of null cause returned empty account will defualt to zero
		if (a.getId() == 0)
			return false;
		
		Account b = dao.getAccountById(to);
		
		//checks for this instead of null cause returned empty account will defualt to zero
		if (a.getId() == 0)
			return false;
		
		withdraw(from,amount);
		deposit(to,amount);
		
		
		return true;
	}
	
}

