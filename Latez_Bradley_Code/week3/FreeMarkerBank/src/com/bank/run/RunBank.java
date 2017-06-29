package com.bank.run;
import java.util.ArrayList;
//client
import java.util.Scanner;

import com.bank.pojos.Account;
import com.bank.pojos.User;
import com.bank.service.Service;

public class RunBank {
	
	static Scanner scan;
	static Service service = new Service();
	static User currentUser;
	static boolean login=false;

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		scan = new Scanner(System.in);
		System.out.println("WELCOME TO Date Access Bank"
				+ "\n"
				+ "Please log in..");
		//User user = joinBank();
		//System.out.println(user);
//		System.out.println("Please enter your userID:");
//		int i = Integer.parseInt(scan.nextLine());
//		
//		System.out.println("Please enter your password");
//		String pw1 = scan.nextLine();
//		String pass= "weezy";
//		
		//currentUser = login();
		
		boolean exit = true;
		String c;
		while(exit){
			System.out.println("1: Add a user");
			System.out.println("2: Returning user");
			System.out.println("3: Exit Program");
			c=scan.nextLine();
			
			switch(c){
			case "1":
				joinBank();
				
				break;
			case "2":
				currentUser = login();
				login =true;
				
				break;
			case "3":
				System.out.println("Program Terminated!");
				exit=!exit;
			}
		}
		
		
		boolean exit2 = true;
		String choice;
		if(login){
			System.out.println(currentUser.getFn()+", Welcome, what would you like to do? \n"
					+ "1: Create an account\n"
					+ "2: Withdraw\n"
					+ "3: Deposit\n"
					+ "4: Create Joint Account\n"
					+ "5  LOGOUT");
			choice = scan.nextLine();
			while(exit2){
				switch(choice){
				case "1":
					System.out.println("What kind of account would you like to create?"
							+ "1: Checking"
							+ "2: Savings"
							+ "3: Credit");
					String t= scan.nextLine();
					service.addAccount(currentUser.getId(), Integer.parseInt(t));
					ArrayList <Account> a = service.getallAccounts(currentUser.getId());
					System.out.println(a.toString());
					break;
				case "2":
					break;
				case "3":
					break;
				case "4":
					break;
				}
			}
		}
		
		
		
		

	}
	
	static User joinBank(){
		//scan = new Scanner(System.in);
		System.out.println("Please enter your first name");
		String fn = scan.nextLine();
		
		System.out.println("Please enter your Last name");
		String ln = scan.nextLine();
		
		System.out.println("Please enter your password");
		String pw = scan.nextLine();
		
		System.out.println("Please enter username/email address");
		String uname = scan.nextLine();
		
		return service.addUser(fn, ln, uname, pw);		
	}
	
	public static User login(){
		System.out.println("Please enter your userID:");
		int userID = Integer.parseInt(scan.nextLine());
		
		System.out.println("Please enter your password");
		String userPW = scan.nextLine();
		
		
		
		User currUser = service.getbyUserId(userID);
		if(userPW.equals(currUser.getPw())){
			System.out.println("Welcome "+currUser.getFn());
			return currUser;
		}
			else{
				if(currUser.getPw()==null){
					System.out.println("user not found");
					return null;
				}
				System.out.println("Incorrect Password");
				return null;
			}
		

	}
	
	public static void logout (){
		System.out.println("User has been Logged out");
		currentUser=null;
	}
	
	

}