package com.bank.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.bank.dao.Dao;
import com.bank.dao.Impldao;
import com.bank.pojos.Account;
import com.bank.pojos.User;

public class Service {
	
	static Dao dao = new Impldao();
	
	public User addUser(String fn, String ln, String userName, String password){
		User temp = new User();
		
		temp = dao.getUser(userName); // this will ensure the username is unique.
		if(temp != null){
			//prompt user to log in or change the user name.
			// "Hey! This user name is already taken, log in instead of trying to create a new user!"
		}else {
			dao.addUser(fn, ln, userName, password);
		}
		
		return temp;
	}
	public Account openAccount (int accType, int balance, int cust_id) {
		Account temp = new Account();
		
		if (accType > 3) return null;
		dao.addAccount(accType, balance, cust_id);
		
		return temp;
	}
	
	public int closeAccount(Account acc){
		return dao.closeAccount(acc);
	}
	
	public int transferMoney(Account acc){
		System.out.print("What account would you like to transfer money to?"
				 + "\n Enter destination account number: ");
		Scanner in = new Scanner(System.in);
		try{
			int accNum = Integer.parseInt(in.nextLine().trim());
			
			System.out.println("How much money do you want to transfer to acc#" + accNum + " from your acc#" + acc.getId() + "?");
		
			int balance = Integer.parseInt(in.nextLine().trim());
		
			return dao.transferMoney(acc, accNum, balance);
			
		} catch(NumberFormatException e) {
			System.out.println("Invalid entry. Please try again.");
			return -1;
		}
		
	}
	
	public void makeDeposit(Account acc, int addBalance){
		dao.makeDeposit(acc, addBalance);
	}
	
	public void makeWithdrawal(Account acc, int reduceBalance){
		dao.makeWithdrawal(acc, reduceBalance);
	}
	
	public boolean editAccountInfo(String edits, User u){
		return dao.editAcc(edits, u);
	}
	
	public User getUser(String userName){
		User temp = new User();
		temp = dao.getUser(userName);
		
		return temp;
	}
	
	public User getUser(int id){
		User temp = new User();
		temp = dao.getUser(id);
		
		return temp;
	}
	
	public void joinAcc(Account acc, User u){
		dao.joinAcc(acc, u);
	}
	
	public ArrayList<User> getUsers(){
		ArrayList<User> allUsers = new ArrayList<User>();
		
		return allUsers;
	}
}
