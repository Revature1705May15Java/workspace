package com.bank.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.bank.dao.DAO;
import com.bank.dao.DaoImpl;
import com.bank.pojos.Account;
import com.bank.pojos.User;

import oracle.net.aso.s;

public class Service {
	
	static DAO dao = new DaoImpl();
	
	Scanner scan = new Scanner(System.in);
	
	public User addUser(String fn, String ln, String uname, String pw){
		User temp = new User();
		temp = dao.getUser(uname);
		if(temp!=null){
			//username found
			System.out.println("USER FOUND! Try again!");
			return null;
		}
		else{
			dao.addUser(fn, ln, uname, pw);
		}
		return dao.getUser(uname);
		
	}
	
	
	public  User login(int uID, String pw){

		User currUser = getbyUserId(uID);
		if(pw.equals(currUser.getPw())){
			System.out.println("Welcome "+currUser.getFn());
			ArrayList<Account> a = getallAccounts(uID);
			currUser.setUserAccounts(a);
			return currUser;
		
	}
		return currUser;
	
		
		}
	
	public User getUser(String uname){
		User temp = new User();
		temp = dao.getUser(uname);
		return temp;
	}
	
	public User getbyUserId(int i){
		System.out.println("in get user service");
		User t = new User();
		t = dao.getUser(i);
		return t;
		
	}
	
	public Account addAccount(int userId, int type_id){
		Account a = new Account();
		
		a = dao.addAccount(userId, type_id);
		
		return a;
		
	}
	
	public ArrayList <Account> getallAccounts(int curid){
		ArrayList <Account>a;
		a = dao.getAllAccounts(curid);
		return a;
	}
	
	
	
	
	

}