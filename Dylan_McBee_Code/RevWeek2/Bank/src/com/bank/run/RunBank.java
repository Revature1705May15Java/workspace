package com.bank.run;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bank.pojos.Account;
import com.bank.pojos.User;
import com.bank.service.Service;

public class RunBank {
//CURRENTLY WORKING ON OPENING ACCOUNT, GETACCOUNTBYID, DAO OPEN ACCOUNT
	static Scanner scan;
	static Service service = new Service();

	public static void main(String[] args) {
		run();

	}

	public static void run() {
		scan = new Scanner(System.in);
		int decision;
		boolean prompt = true;
		System.out.println("WELCOME TO DOGGO BANK" + "\n" + " Are you already a member?");
		while (prompt) {
			System.out.println("1: New Member");
			System.out.println("2: Returning Member");
			System.out.println("3: Terminate Program");
			decision = scan.nextInt();
			switch (decision) {

			case 1:
				User newUser = joinBank();
				System.out.println(newUser);
				break;
			case 2:
				User currentUser = login();
				if (currentUser.getFn() != null) {
					loggedIn(currentUser);
				}

				break;
			case 3:
				prompt = false;

				break;
			default:
				System.out.println("Invalid input, please try again");

			}
		}

	}

	static User joinBank() {
		scan = new Scanner(System.in);
		System.out.println("Please enter your first name");
		String fn = scan.nextLine();
		System.out.println("Please enter your last name");
		String ln = scan.nextLine();
		System.out.println("Please enter your password");
		String pw = scan.nextLine();
		System.out.println("Please enter your username or email address");
		String uName = scan.nextLine();
		while (service.isUserNameAvailable(uName) == false | uName.equals("")) {
			System.out.println("User Name is not available, please try again");
			uName = scan.nextLine();

		}
		return service.addUser(fn, ln, uName, pw);
	}

	static User login() {
		User u = new User();
		scan = new Scanner(System.in);
		System.out.println("Welcome back! Please login");
		System.out.println("Username:");
		String uName = scan.nextLine();
		if (service.checkUser(uName)) {
			System.out.println("Hello " + uName + ", Please enter your password");
			String pw = scan.nextLine();
			if (service.checkPassword(uName, pw)) {
				u = service.getUser(uName);
				String uFn = u.getFn();
				System.out.println("User verified! Welcome back " + uFn + "!");
				return u;
			} else {
				System.out.println("Incorrect password");
				return u;
			}
		} else {
			System.out.println("UserName does not exist, returning to first page.");
			return u;
		}

	}

	static void loggedIn(User u) {
		scan = new Scanner(System.in);
		int currId = u.getId();
		ArrayList<Account> userAccounts = service.getAllAccounts(currId);
		u.setUserAccounts(userAccounts);
		int decision;
		boolean logged = true;
		while (logged) {
			System.out.println("What would you like to do today " + u.getFn() + "?");
			System.out.println("1: Open Account");
			System.out.println("2: Check Balance");
			System.out.println("3: Logout");
			decision = scan.nextInt();
			switch (decision) {

			case 1:
				if(u.getUserAccounts().size() < 3){
				int openAccount;
				System.out.println("What type of account would you like to open?");
				System.out.println("1: Checking");
				System.out.println("2: Savings");
				System.out.println("3: Credit");
				openAccount = scan.nextInt();
				switch (openAccount) {
				case 1:
					
					service.openAccount(u, openAccount);
					break;
				}
				}
				else{
					System.out.println("You have the maximum number of accounts. Please close an account");
				}
				break;
			

			case 2:
				break;
			case 3:
				System.out.println("Logging out...");
				logged = false;
				break;
			
		}
		}

	}

}