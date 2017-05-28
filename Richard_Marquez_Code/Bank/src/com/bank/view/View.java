package com.bank.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.bank.pojos.Account;
import com.bank.pojos.AccountType;
import com.bank.pojos.User;
import com.bank.service.Service;

public class View {

	private static Scanner scan = new Scanner(System.in);
	private static Service svc = new Service();

	public static void main(String[] args) {
		View v = new View();
		v.run();
	}
	
	public void run() {
		boolean running = true;
		
		do {
			System.out.println(
					"\t1. Login\n" +
					"\t2. Register new user\n" +
					"\t3. Exit\n"
					);
			System.out.print("Select an action: ");
			
			int choice = Integer.parseInt(scan.nextLine());
			switch (choice) {
			case 1:
				login();
				break;
			case 2:
				createUser();
				break;
			case 3:
				running = false;
				break;
			default:
				System.out.println("Please enter a valid option.");
			}
			
			System.out.println();
		} while (running);
	}
	
	private void login() {
		System.out.print("Email: ");
		String email = scan.nextLine();
		
		System.out.print("Password: ");
		String password = scan.nextLine();
		
		User u = svc.login(email, password);
		
		if (u == null) {
			System.out.println("Invalid login information; please try again.");
		} else {
			userActionPage(u);
		}
	}
	
	private void userActionPage(User u) {
		boolean running = true;
		
		do {
			System.out.println(
					"\t1. Manage an account\n" +
					"\t2. Create new account\n" +
					"\t3. Log out\n"
					);
			System.out.print("Select an action: ");
			
			int choice = Integer.parseInt(scan.nextLine());
			switch (choice) {
			case 1:
				manageAccount(u);
				break;
			case 2:
				createAccount(u);
				break;
			case 3:
				running = false;
				break;
			default:
				System.out.println("Please enter a valid option.");
			}
			
			System.out.println();
		} while (running);
	}
	
	private void accountActionPage(User u, Account a) {
		boolean running = true;
		
		do {
			System.out.println(
					"\t1. Deposit\n" +
					"\t2. Withdraw\n" +
					"\t3. Transfer\n" +
					"\t4. Add joint account holder\n"+
					"\t5. View balance\n" +
					"\t6. Close account\n" +
					"\t7. Back\n"
					);
			System.out.print("Select an action: ");
			
			int choice = Integer.parseInt(scan.nextLine());
			switch (choice) {
			case 1:
				deposit();
				break;
			case 2:
				withdraw();
				break;
			case 3:
				transfer();
				break;
			case 4:
				addJointAccountHolder();
				break;
			case 5:
				viewBalance();
				break;
			case 6:
				closeAccount();
				break;
			case 7:
				running = false;
				break;
			default:
				System.out.println("Please enter a valid option.");
			}
			
			System.out.println();
		} while (running);
	}
	
	private void createUser() {
		System.out.print("First name: ");
		String fName = scan.nextLine();
		
		System.out.print("Last name: ");
		String lName = scan.nextLine();
		
		System.out.print("Email: ");
		String email = scan.nextLine();
		
		System.out.print("Password: ");
		String password = scan.nextLine();
		
		User u = svc.addUser(fName, lName, password, email);
		if (u == null) {
			System.out.println("Unable to create new user; please try again.");
		} else {
			System.out.println("Successfully created new user.");
			userActionPage(u);
		}
	}
	
	private void manageAccount(User u) {
	    ArrayList<Account> accounts = svc.getAccounts(u);
		boolean running = true;

		do {
			for (int i = 0; i < accounts.size(); i++) {
				Account a = accounts.get(i);
				System.out.printf("\t%d. %-15s [$%-8.2f] [ACCT#%d]\n", (i+1), a.getType(), a.getBalance(), a.getId());
			}
			System.out.println("\t" + (accounts.size()+1) + ". Back\n");

			System.out.print("Select an action: ");

			int choice = Integer.parseInt(scan.nextLine());

			if (choice <= accounts.size() && choice > 0) {
			    accountActionPage(u, accounts.get(choice-1));
            } else if (choice == accounts.size()+1) {
			    running = false;
			} else {
				System.out.println("Please enter a valid option.");
			}

			System.out.println();
		} while (running);



	}

	private void createAccount(User u) {
		boolean running = true;
		ArrayList<AccountType> types = svc.getAccountTypes();

		do {
			for (int i = 0; i < types.size(); i++) {
				AccountType a = types.get(i);
				System.out.println("\t" + (i + 1) + ". " + a.getName());
			}
			System.out.println("\t" + (types.size()+1) + ". Back\n");

			System.out.print("What type of account would you like to open: ");

			int choice = Integer.parseInt(scan.nextLine());

			if (choice >= 1 && choice <= types.size()) {
				Account a = svc.addAccount(u, choice);
				if (a != null) {
					running = false;
					accountActionPage(u, a);
				} else {
					System.out.println("Unable to create new account");
				}
			} else if (choice == types.size()+1) {
				running = false;
			} else {
				System.out.println("Please enter a valid option.");
			}

			System.out.println();
		} while (running);
		
	}
	
	private void deposit() {
	}
	
	private void withdraw() {
	}
	
	private void transfer() {
	}
	
	private void addJointAccountHolder() {
	}
	
	private void viewBalance() {
	}

	private void closeAccount() {
	}

}
