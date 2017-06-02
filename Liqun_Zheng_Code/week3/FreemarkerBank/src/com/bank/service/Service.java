package com.bank.service;

import java.util.ArrayList;

import com.bank.dao.DAO;
import com.bank.dao.DaoImpl;
import com.bank.pojos.Account;
import com.bank.pojos.User;

public class Service {
	static DAO dao = new DaoImpl();
	final int AccountLimit = 3;
	final int UserLimitPerAcc = 4;
	
	//return all accounts by userid
	public ArrayList<Account> getAllAccByUserId(int userId){
		ArrayList<Account> accs = dao.findAccByUserId(userId);
		for(int i= 0; i<accs.size(); i++){
			if(accs.get(i).getDateClosed()!= null){
				accs.remove(i);
				i--;
				}
		}
		
		return accs;
	}
	
	//return user by adding user with 
	public User addUser(String fn, String ln, String uname, String pw){
		User temp = null;
		temp = dao.getUser(uname);
		if(temp.getUname()==null){
			dao.addUser(fn, ln, pw, uname);
			System.out.println("User account create succussfully!");
			temp = dao.getUser(uname);
			return temp;
		}
		return null;
	}
	public Account addAccount(User user, int typeId){
		Service s = new Service();
		Account temp = null;
		if(s.CheckUserLimit(user)){
		temp = dao.addAccount(user, typeId);
		}
		return temp;
		
	}
	//return true if limit is not excess.
	public boolean CheckUserLimit(User user){
		if(dao.coutAccByUserId(user.getId()) < AccountLimit){
			return true;
		}
		else return false;
	}
	
	
	//check if account reached to max users
	public boolean CheckAccLimit(int accId){
		if(dao.findUserByAccId(accId).size() < AccountLimit){
			return true;
		}
		else return false;
	}
	
	//sign in user by username and password return user with ArrayList of accounts
	public User Signin(String username, String password){
		User u = dao.getUser(username);
		ArrayList<Account> accs = new ArrayList<Account>();
		if(u.getPw().equals(password)){
			accs= dao.findAccByUserId(u.getId());
			for(int i= 0; i<accs.size(); i++){
				if(accs.get(i).getDateClosed()!= null){
					accs.remove(i);
					i--;
					}
			}
			u.setUserAccounts(accs);
			return u;
		}
		else
			return null;
	}
	//close account by account id and return user with updated ArrayList of accounts
	public User closeAcc(User user, int accId){
		ArrayList<Account> accs = null;
		if(dao.closeAccount(accId)){
			accs = user.getUserAccounts();
			for(int i = 0; i < accs.size(); i++){
				if(accs.get(i).getId()==accId){
					accs.remove(i);
				}
			}
			user.setUserAccounts(accs);
		}	
		return user;
		
	}
	
	//deposit to account by account id and amount user want to deposit to
	//return user with updated ArrayList of accounts
	public User deposit(User user, int accId, double amount){
		double curr = dao.getAccByAccId(accId).getBalance();
		curr = dao.updateBalance(accId, (amount+curr));
		
		for(int i= 0; i<user.getUserAccounts().size(); i++){
			if(user.getUserAccounts().get(i).getId() == accId){
				user.getUserAccounts().get(i).setBalance(curr);
			}
		}
		
		
		return user;
		
	}
	//withdraw from account by account id and amount user want to withdraw
	//return user with updated ArrayList of accounts
	public User withdraw(User user, int accId, double amount){
		double curr = dao.getAccByAccId(accId).getBalance();
		curr = dao.updateBalance(accId, (curr - amount));
		
		for(int i= 0; i<user.getUserAccounts().size(); i++){
			if(user.getUserAccounts().get(i).getId() == accId){
				user.getUserAccounts().get(i).setBalance(curr);
			}
		}
		
		
		return user;
		
	}
	
	//Joint account by taking second user and account id then add to user_account table
	//return user with updated ArrayList of accounts
	public User joinAcc(User user2, int accId){
		Service s = new Service();
		dao.addUserAccount(user2.getId(), accId);
		user2.setUserAccounts(s.getAllAccByUserId(user2.getId()));
		return user2;
		
	}
	
	

}
