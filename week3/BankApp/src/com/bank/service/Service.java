package com.bank.service;

import java.util.ArrayList;

import com.bank.dao.DAO;
import com.bank.dao.DaoImpl;
import com.bank.pojos.Account;
import com.bank.pojos.AccountType;
import com.bank.pojos.User;

public class Service {
	
	static DAO dao = new DaoImpl();
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
	
	public Account findAccount(int id){
		return dao.getAccount(id);
	}
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
		System.out.println("found user "+uname);
		String actualpw=u.getPw();
		if(actualpw.equals(pw)){
			System.out.println(true);
			return true;
		}else{
			System.out.println(false);
			return false;
		}
	}
	public ArrayList<Integer> findAccounts(int userid){
		ArrayList<Integer> accounts=dao.findAccounts(userid);
		System.out.println("finding : "+userid);
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
	private void passGenericToDao(String tabletochange,String vartochange,String newinfo,String uname){
		dao.receiveGenericChange(tabletochange,vartochange,newinfo,uname);
	}
	public void changeFirstName(String newfn,String uname){
		passGenericToDao("users","firstname",newfn,uname);
	}
	public void changeLastName(String newln,String uname){
		passGenericToDao("users","lastname",newln,uname);
	}
	public void changePassword(String newpw,String uname){
		passGenericToDao("users","lastname",newpw,uname);
	}
	public void changeUsername(String newuname,String uname){
		passGenericToDao("users","username",newuname,uname);
	}
	public boolean changeAccountBalance(String balancechange,String id){
		passGenericToDao("account","balance",balancechange,id);
		return false;
	}
	public void closeAccount(String id){
		passGenericToDao("account","closed","",id);
	}
	public double getAccountBalance(int accountid){
		Account a =findAccount(accountid);
		return a.getBalance();
	}
}
