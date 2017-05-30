package servicelayer;

//import java.sql.Date;
import java.util.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import dao.BankDao;
import pojos.Account;
import pojos.AccountType;
import pojos.User;

public class BankService 
{
	BankDao dao = new BankDao(); 
	
	// create new User to dao 
	public User addUser(String fn, String ln, String pw, String email)
	{
		User temp = new User(); 
		temp = dao.getUser(email); 
		if(temp != null)
		{
			System.out.println("Username already exists. Try again with a new username."); 
		}
		else
			dao.addUser(fn, ln, pw, email); /////edit later 
		return dao.getUser(email); 
	}
	
	// done ?
	// should probably take an int id instead so client doesn't have to know about AccountType 
	// object class at all 
	public boolean createAccount(int typeid, User user)
	{
		Date date = new Date(); 
		Timestamp ts = new Timestamp(date.getTime()); 
		AccountType at= new AccountType(typeid); 
		
		Account temp = new Account(); 
		temp.setType(at);
		temp.setDateOpened(ts);
		temp.addUser(user); 
		user.addUserAccount(temp); 
		
		if(dao.createAccount(temp)) //confirm that db insertion was success first
			return true;
		else
			return false; 
	}
	
	//done 
	public boolean deleteAccount(Account account, User user)
	{
		if(dao.deleteAccount(account))	
		{
			user.removeUserAccount(account); //need to remove from user's arraylist
			//need to remove user from Account's arraylist???
			return true;
		}
		else 
			return false; 
	}
	
	//
	public void viewBalance(Account account)	//no check for non-existing account
	{
		System.out.println("Account Balance: " + dao.viewBalance(account));
	}

	//done 
	public void viewAccounts(User user)
	{
		ArrayList<Account> list = user.getUserAccounts(); 
		for(Account a : list)
		{
			System.out.println(a.toString());
		}
	}
	
	public User getUser(User user)
	{
		return dao.getUser(user.getEmail()); 
	}
	
	// done
	public void viewUser(User user)
	{
		System.out.println(user.toString());
	}
	
	// takes amount to be removed from given account balance, returns the new balane
	public boolean withdraw(Account account, double amount)
	{
		double newBalance = dao.viewBalance(account) - amount; 
		newBalance = dao.updateBalance(account, newBalance); 
		account.setBalance(newBalance);
		
		if(dao.viewBalance(account) == account.getBalance())  //check that the balances are correct in both
			return true;
		else
			return false;  
	}
	
	// takes amount to be added to given account balance, returns the new balane
	public boolean deposit(Account account, double amount)
	{
		double newBalance = dao.viewBalance(account) + amount; 
		newBalance = dao.updateBalance(account, newBalance);
		account.setBalance(newBalance);
		
		if(dao.viewBalance(account) == account.getBalance())  //check that the balances are correct in both
			return true;
		else
			return false; 
	}
	
	public boolean transfer(Account from, Account to, double amount)
	{
		if(withdraw(from, amount) & deposit(to, amount))
			return true;
		else
			return false; 
	}
	
}
