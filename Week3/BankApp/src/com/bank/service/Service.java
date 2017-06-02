package com.bank.service;

import java.util.ArrayList;

import com.bank.dao.DaoImpl;
import com.bank.pojos.Account;
import com.bank.pojos.AccountType;
import com.bank.pojos.User;

public class Service {


	static DaoImpl dao = new DaoImpl();
	static Account currentaccount=new Account();
	static User currentuser=new User();
	public ArrayList<AccountType> accounttypes=new ArrayList<AccountType>();
	
	public ArrayList<AccountType> getAccountTypes(){
		accounttypes=dao.fetchAccountTypes();
		return accounttypes;
	}
	
	public void newAccount(int accounttype, int userid){
		dao.newAccount(accounttype, userid);
	}
	
//	public Account findAccount(int id){
//		return dao.getAccount(id);
//	}
	public User addUser(String fn, String ln, String uname, String pw){
		User temp = new User();
		temp=dao.getUser(uname);
		if(temp!=null){
			System.out.println("User already exists. Please select a different username.");
		}else{
			dao.addUser(fn,ln,uname,pw);
		}
		
		return null;
	}
	public boolean checkPassword(String pw,String uname){
		User u=findUser(uname);
		String actualpw=u.getPassword();
		if(actualpw.equals(pw)){
			System.out.println(true);
			return true;
		}else{
			return false;
		}
	}
	public ArrayList<Account> findAccounts(int userid){
		ArrayList<Account> accounts=dao.findAccounts(userid);
		System.out.println("in service findAccounts");
		return accounts;
	}
	public User findUser(String uname){//this function should only be called by other methods in the service level
		//to make the user details readily accessible
		User temp = new User();
		temp=dao.getUser(uname);
		if(temp==null){
			return null;
		}else{
			return temp;
		}
	}

}
