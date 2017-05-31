package com.rev.service;

import com.rev.dao.DAO;
import com.rev.dao.DAOImpl;
import com.rev.exceptions.InsufficientFundsException;
import com.rev.exceptions.NonexistentAccountException;
import com.rev.pojos.Account;
import com.rev.pojos.User;

// TODO: Add comments
public class Service {
	private static final int MAX_ACCOUNT_HOLDERS = 4;
	
	private static DAO dao = new DAOImpl();
	
	public User addUser(String firstName, String lastName, String password, String email) {
		if(dao.addUser(firstName, lastName, password, email) == 1) {
			User user = dao.getUser(email);
			
			return user;
		}
		
		return null;
	}
	
	public User getUser(String email) {
		User user = dao.getUser(email);
		
		// Get all user's accounts
		if(user != null) {
			user.setAccounts(dao.getUserAccounts(user));
			
			// Set each Account's users
			for(Account a : user.getAccounts()) {
				a.setAccountHolders(dao.getAccountHolders(a));
			}
		}
		
		
		return user;
	}
	
	public void closeAccount(User user, Account account) {
		int numClosed = dao.closeAccount(account);
		
		if(numClosed == 1) {
			user.removeAccount(account);
		}
		// TODO: Throw exception otherwise.
	}
	
	public Account openAccount(User user, Account account) {
		account = dao.addAccount(account, user);
		
		if(account != null) {
			account.setAccountHolders(dao.getAccountHolders(account));
			return account;
		}
		// TODO: Throw exception otherwise
		return null;
	}
	
	public void addAccountHolder(Account account, int holderId) {
		User accountHolder = dao.getUser(holderId);
		
		dao.addAccountHolder(account, accountHolder);
		account.addAccountHolder(accountHolder);
	}
	
	public double depositFunds(Account account, double amount) {
		double total = account.getBalance() + amount;
		account.setBalance(total);
		dao.updateBalance(account);
		
		// TODO: Error checking
		
		return total;
	}
	
	public double withdrawFunds(Account account, double amount) throws InsufficientFundsException {
		double total = account.getBalance() - amount;
		
		if(total < 0) {
			throw new InsufficientFundsException("Insufficent funds available for this action.");
		}
		else {
			account.setBalance(total);
			dao.updateBalance(account);
			
			return total;
		}
	}
	
	public double transferFunds(User user, Account account, double amount, int recipientAccountId) 
			throws InsufficientFundsException, 
					NonexistentAccountException {
		double total = account.getBalance() - amount;
		
		if(total < 0) {
			throw new InsufficientFundsException("Insufficent funds available for this action.");
		}
		
		Account recipientAccount = dao.getAccount(recipientAccountId);
		
		if(recipientAccount == null) {
			throw new NonexistentAccountException("Recipient does not exist.");
		}
		
		boolean userIsOwner = false;
		
		for(Account a : user.getAccounts()) {
			if(a.getAccountId() == recipientAccountId) {
				userIsOwner = true;
			}
		}
		
		double recipientTotal = recipientAccount.getBalance() + amount;
		recipientAccount.setBalance(recipientTotal);
		dao.updateBalance(recipientAccount);
		
		if(userIsOwner) {
			for(int i = 0; i < user.getAccounts().size(); i++) {
				Account a = user.getAccounts().get(i);
				
				if(a.getAccountId() == recipientAccountId) {
					user.removeAccount(a);
					user.addAccount(recipientAccount);
					break;
				}
			}
		}
		
		account.setBalance(total);
		dao.updateBalance(account);
		
		return total;
	}
	
	public boolean isEmailUnique(String email) {
		if(dao.getUser(email) == null) {
			return true;
		}
		
		return false;
	}
	
	public boolean canAccountHaveMoreOwners(Account account) {
		return account.getAccountHolders().size() <= MAX_ACCOUNT_HOLDERS;
	}
}
