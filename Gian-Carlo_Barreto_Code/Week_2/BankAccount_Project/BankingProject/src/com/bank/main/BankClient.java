package com.bank.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.bank.pojos.Account;
import com.bank.pojos.User;
import com.bank.service.BankService;

public class BankClient {
	private int userId;
	private User user;
	private Scanner in;
	private static final int EXIT = -1;
	private static final int LOGOUT = -2;
	private BankService service;
	
	BankClient() {
		this.in = new Scanner(System.in);
		this.service = new BankService();
	}
	
	/**
	 * Displays the welcome screen
	 * @return number of menu options
	 */
	private int displayWelcomeScreen() {
		System.out.println("Welcome to The Bank...");
		System.out.println("What would you like to do? Please choose from the menu below: ");
		System.out.println("1. Login");
		System.out.println("2. Create a new user");
		System.out.println("3. Exit");
		return 3;
	}
	
	/**
	 * Displays the main menu
	 * @return number of menu options
	 */
	private int displayMainMenu() {
		System.out.println("\nPlease select a choice from the menu below: ");
		System.out.println("1. Create an account");
		System.out.println("2. Add a user to an account");
		System.out.println("3. View your account balance");
		System.out.println("4. Withdraw");
		System.out.println("5. Deposit");
		System.out.println("6. Transfer an amount to another account");
		System.out.println("7. Close an account");
		System.out.println("8. Sign out");
		return 8;
	}
	
	/**
	 * Gets the user's menu choice
	 * @return user's menu choice
	 */
	private int getUserChoice(int numOfOptions) {
		int choice = Integer.parseInt(this.in.nextLine());
		while (choice < 1 || choice > numOfOptions) {
			System.out.println("Choice not valid.  Please enter valid choice");
			choice = Integer.parseInt(this.in.next());
		}
		return choice;
	}
	
	/**
	 * Executes the user's window menu choice
	 * @param choice
	 * @return EXIT if user wants to exit program, 0 otherwise
	 */
	private int executeWelcomeChoice(int choice) {
		switch (choice) {
			case 1: 
				login();
				boolean done = false;
				while (!done) {
					int numOfOptions = displayMainMenu();
					int mainChoice = getUserChoice(numOfOptions);
					int signout = executeMainChoice(mainChoice);
					if (signout == LOGOUT) 
						done = true;
				}
				break;
			case 2:
				createNewUser();
				break;
			case 3:
				return EXIT;
		}
		return 0;
	}
	
	/**
	 * Ask the user for their username and password and then log them into
	 * the system.
	 */
	private void login() {
		String username = "";
		String password = "";
		boolean valid = false;
		while (!valid) {
			System.out.print("Please enter your username: ");
			username = this.in.nextLine();
			System.out.print("Please enter your password: ");
			password = this.in.nextLine();
			User u = this.service.confirmLogin(username, password);
			if (u == null)
				System.out.println("Your login credentials are incorrect");
			else {
				this.userId = u.getId();
				this.user = u;
				setAccountInfo();
				valid = true;
			}
		}
	}
	
	/**
	 * Asks the user for new user information and sends the new user request to the BankService
	 * class.
	 */
	private void createNewUser() {
		String firstName, lastName, username = null, password, email = null;
		System.out.print("\nPlease enter your first name: ");
		firstName = this.in.nextLine();
		System.out.print("Please enter your last name: ");
		lastName = this.in.nextLine();
		boolean available = false;
		while (!available) {
			System.out.print("Please enter a username: ");
			username = this.in.nextLine();
			available = service.isUsernameAvailable(username);
			if (!available)
				System.out.println("Username not available");
		}
		System.out.print("Please enter a password: ");
		password = this.in.nextLine();
		available = false;
		while (!available) {
			System.out.print("Please enter an email: ");
			email = this.in.nextLine();
			available = service.isEmailAvailable(email);
			if (!available)
				System.out.println("Email not available");
		}
		User user = this.service.createNewUser(firstName, lastName, username, password, email);
	}
	
	/**
	 * Sets the user's account info.
	 */
	private void setAccountInfo() {
		ArrayList<Account> accounts = this.service.getAllAccounts(this.userId);
		for (Account a : accounts) {
			this.user.addAccount(a);
		}
	}
	
	/**
	 * Executes the user's main menu choice
	 * @param choice
	 * @return LOGOUT if user wants to logout, 0 otherwise
	 */
	private int executeMainChoice(int choice) {
		switch(choice) {
			case 1:
				// Create an account
				createAccount();
				break;
			case 2:
				// Add user to an account
				addUser();
				break;
			case 3:
				// View account balance
				System.out.println("Displaying your accounts' information: ");
				viewAccounts();
				break;
			case 4:
				// Withdraw
				withdraw();
				break;
			case 5:
				// Deposit
				deposit();
				break;
			case 6:
				// Transfer
				transfer();
				break;
			case 7:
				// Close an account
				closeAccount();
				break;
			case 8:
				// Sign out
				this.userId = 0;
				this.user = null;
				return LOGOUT;
		}
		return 0;
	}
	
	/**
	 * Asks user for the type of account that they want to create and then creates the account
	 */
	private void createAccount() {
		if (this.user.getNumOfAccounts() < 3) {
			System.out.println("What type of account would you like to create: ");
			System.out.println("1. Checking");
			System.out.println("2. Savings");
			System.out.println("3. Credit");
			int type = getUserChoice(3);
			Account a = this.service.createAccount(this.userId, type);
			if (a != null) {
				System.out.println("Account successfully created");
				a.addUser(this.user);
				this.user.addAccount(a);
			}
			else
				System.out.println("Account not created");
		}
		else
			System.out.println("You have exceeded the alloted amount of accounts");
	}
	
	/**
	 * Display all of the user's account information
	 */
	private void viewAccounts() {
		int count = 1;
		for (Account a : this.user.getAllAccounts()) {
			if (a.getCloseDate() == null) {
				System.out.println(count + ". Account type: " + a.getType().name() + "\tBalance: " + a.getBalance());
				count++;
			}
		}
	}
	
	/**
	 * Withdraws an amount from the user's account balance
	 */
	private void withdraw() {
		System.out.println("Which account do you want to withdraw from? Choose from the following: ");
		viewAccounts();
		int choice = getUserChoice(this.user.getNumOfAccounts());
		int index = choice - 1;
		Account a = this.user.getAllAccounts().get(index);
		boolean canWithdraw = false;
		double amount = 0;
		if (a.getBalance() != 0) {
			while (!canWithdraw) {
				System.out.print("Please enter withdraw amount: ");
				amount = Double.parseDouble(this.in.nextLine());
				if (amount < a.getBalance())
					canWithdraw = true;
				else
					System.out.println("Insufficient funds");
					
			}
			if (this.service.withdraw(a, amount)) {
				System.out.println("Your new balance is: " + a.getBalance());
			}
			else {
				System.out.println("Error: Unable to withdraw amount");
			}
		}
		else
			System.out.println("You have no money to withdraw");
	}
	
	/**
	 * Deposits an amount into an account
	 */
	private void deposit() {
		System.out.println("Which account do you want to deposit to? Choose from the following: ");
		viewAccounts();
		int choice = getUserChoice(this.user.getNumOfAccounts());
		int index = choice - 1;
		Account a = this.user.getAllAccounts().get(index);
		
		System.out.print("Please enter deposit amount: ");
		double amount = Double.parseDouble(this.in.nextLine());
		if (this.service.deposit(a, amount)) {
			System.out.println("Your new balance is: " + a.getBalance());
		}
		else {
			System.out.println("Error: Unable to deposit amount");
		}
	}
	
	/**
	 * Closes an account
	 */
	private void closeAccount() {
		if (this.user.getNumOfAccounts() != 0) {
			System.out.println("Which account do you want to close? Choose from the following: ");
			viewAccounts();
			int choice = getUserChoice(this.user.getNumOfAccounts());
			int index = choice - 1;
			Account a = this.user.getAllAccounts().get(index);
			
			if (this.service.closeAccount(a)) {
				this.user.removeAccount(a);
				System.out.println("Your account has been closed");
			}
			else
				System.out.println("ERROR: Account could not be closed");
		}
		else
			System.out.println("You do not have any accounts to close");
	}
	
	private void transfer() {
		if (this.user.getNumOfAccounts() > 1) {
			// Get the account in which an amount will be transfered from
			System.out.println("Which account do you want to transfer from? Choose from the following: ");
			viewAccounts();
			int choice = getUserChoice(this.user.getNumOfAccounts());
			int fromIndex = choice - 1;
			Account from = this.user.getAllAccounts().get(fromIndex);
			
			// Get the amount to transfer
			boolean canTransfer = false;
			double amount = 0;
			if (from.getBalance() != 0) {
				while (!canTransfer) {
					System.out.print("Please enter transfer amount: ");
					amount = Double.parseDouble(this.in.nextLine());
					if (amount < from.getBalance())
						canTransfer = true;
					else
						System.out.println("Insufficient funds");
						
				}
				
				// Get the account in which an amount will be transfered to
				System.out.println("Which account do you want to transfer to? Choose from the following: ");
				int count = 1;
				for (Account a : this.user.getAllAccounts()) {
					if (a.getCloseDate() == null) {
						if (count != choice) {
							System.out.println(count + ". Account type: " + a.getType().name() + "\tBalance: " + a.getBalance());
						}
						count++;
					}
				}
				int choice2 = getUserChoice(count - 1);
				int toIndex = choice2 - 1;
				Account to = this.user.getAllAccounts().get(toIndex);
				
				
				if (this.service.withdraw(from, amount)) {
					if (this.service.deposit(to, amount))
						System.out.println("Transfer complete");
					else
						System.out.println("ERROR: Could not transfer");
				}
				else {
					System.out.println("Error: Unable to withdraw amount");
				}
			}
			else
				System.out.println("You have no money to transfer");
		}
		else
			System.out.println("You need at least two accounts inorder to transfer money");
	}
	
	/**
	 * Add a user to an account
	 */
	private void addUser() {
		// Get the account in which a user is to be added
		System.out.println("Which account do you want to add a user to? Choose from the following: ");
		viewAccounts();
		int choice = getUserChoice(this.user.getNumOfAccounts());
		int index = choice - 1;
		Account a = this.user.getAllAccounts().get(index);
		ArrayList<User> users = this.service.getAccountUsers(a.getId());
		for (User u : users) {
			a.addUser(u);
		}
		
		if (a.getNumOfUsers() < 4) {
			System.out.print("What is the username of the user you would like to add? ");
			String username = this.in.nextLine();
			boolean member = false;
			for (User u : users) {
				if (username.equals(u.getUsername())) {
					member = true;
					break;
				}
			}
			if (!member) {
				int numAccounts = this.service.getNumOfAccounts(username);
				if (numAccounts != -1 && numAccounts < 3) {
					if (this.service.addUser(a.getId(), username))
						System.out.println("User added successfully");
					else
						System.out.println("User was unable to be added");
				}
				else
					System.out.println("User has max number of accounts");
			}
			else
				System.out.println("User is already on this account");
		}
		else
			System.out.println("ERROR: Account has max number of users");
}
	
	/**
	 * Runs the Online Banking Program
	 */
	public void run() {
		while (true) {
			int numOfOptions = displayWelcomeScreen();
			int choice = getUserChoice(numOfOptions);
			int shouldExit = executeWelcomeChoice(choice);
			if (shouldExit == EXIT)
				break;
		}
	}
}
