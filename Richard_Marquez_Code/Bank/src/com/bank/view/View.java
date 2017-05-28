package com.bank.view;

import java.math.BigDecimal;
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
			System.out.println("Welcome, " + u.getFirstName() + " " + u.getLastName());
			userActionPage(u);
		}
	}
	
	private void userActionPage(User u) {
		boolean running = true;
		
		do {
			System.out.println(
					"\t1. Manage an account\n" +
					"\t2. Create new account\n" +
                    "\t3. Update information\n" +
					"\t4. Log out\n"
					);
			System.out.print("Select an action: ");
			
			int choice;
			try {
				choice = Integer.parseInt(scan.nextLine());
			} catch (Exception e) {
				System.out.println("Please enter a number.\n");
				continue;
			}

			switch (choice) {
			case 1:
				manageAccount(u);
				break;
			case 2:
				createAccount(u);
				break;
            case 3:
            	updateInformation(u);
                break;
			case 4:
				running = false;
				break;
			default:
				System.out.println("Please enter a valid option.");
			}
			
			System.out.println();
		} while (running);
	}

	private void updateInformation(User u) {
		System.out.print("First name: ");
		String fName = scan.nextLine();

		System.out.print("Last name: ");
		String lName = scan.nextLine();

		System.out.print("Email: ");
		String email = scan.nextLine();

		System.out.print("Password: ");
		String password = scan.nextLine();

		if (svc.updateUser(u, fName, lName, email, password)) {
			System.out.println("Successfully updated information.");
			userActionPage(u);
		} else {
			System.out.println("Unable to update information; please try again.");
		}
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
			
			int choice;
			try {
				choice = Integer.parseInt(scan.nextLine());
			} catch (Exception e) {
				System.out.println("Please enter a number.\n");
				continue;
			}

			switch (choice) {
			case 1:
				deposit(a);
				break;
			case 2:
				withdraw(a);
				break;
			case 3:
				transfer(a);
				break;
			case 4:
				addJointAccountHolder(a);
				break;
			case 5:
				viewBalance(a);
				break;
			case 6:
				if (closeAccount(a)) {
					running = false;
				}
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
		boolean running = true;

		do {
			ArrayList<Account> accounts = svc.getAccounts(u);

			// Don't show closed accounts
			ArrayList<Account> openAccounts = new ArrayList<>();
			for (Account a : accounts) {
				if (a.getClosed() == null) {
					openAccounts.add(a);
				}
			}

			for (int i = 0; i < openAccounts.size(); i++) {
				Account a = openAccounts.get(i);
                System.out.printf("\t%d. %-15s [ACCT#%d]\n", (i + 1), a.getType(), a.getId());
			}
			System.out.println("\t" + (openAccounts.size()+1) + ". Back\n");

			System.out.print("Select an account: ");

			int choice;
			try {
				choice = Integer.parseInt(scan.nextLine());
			} catch (Exception e) {
				System.out.println("Please enter a number.\n");
				continue;
			}

			if (choice <= openAccounts.size() && choice > 0) {
			    accountActionPage(u, openAccounts.get(choice-1));
            } else if (choice == openAccounts.size()+1) {
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
				System.out.println("\t" + (i + 1) + ". " + a);
			}
			System.out.println("\t" + (types.size()+1) + ". Back\n");

			System.out.print("What type of account would you like to open: ");

			int choice;
			try {
				choice = Integer.parseInt(scan.nextLine());
			} catch (Exception e) {
				System.out.println("Please enter a number.\n");
				continue;
			}

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
	
	private void deposit(Account a) {
	    System.out.print("Enter deposit amount: $");

		double amt;
		try {
			amt = Double.parseDouble(scan.nextLine());

			a =  svc.deposit(a, amt);
			if (a != null) {
			    System.out.printf("Deposit successful.\nNew balance: $%.2f\n\n", a.getBalance());
			} else {
				System.out.println("Unable to deposit money. Please try again.");
			}
		} catch (Exception e) {
			System.out.println("Please enter a number.\n");
		}
	}
	
	private void withdraw(Account a) {
		System.out.print("Enter withdraw amount: $");

		double amt;
		try {
			amt = Double.parseDouble(scan.nextLine());

			a = svc.withdraw(a, amt);
			if (a != null) {
				System.out.printf("Withdraw successful.\nNew balance: $%.2f\n\n", a.getBalance());
			} else {
				System.out.println("Unable to withdraw money. Please try again.");
			}
		} catch (Exception e) {
			System.out.println("Please enter a number.\n");
		}
	}
	
	private void transfer(Account a) {
		try {
			System.out.print("Enter transfer amount: $");
			double amt = Double.parseDouble(scan.nextLine());

			System.out.print("Enter recipient account ID: ");
			int recipientAccountId = Integer.parseInt(scan.nextLine());

			a = svc.transfer(a, recipientAccountId, amt);
			if (a != null) {
				System.out.printf("Transfer successful.\nNew balance: $%.2f\n\n", a.getBalance());
			} else {
				System.out.println("Unable to transfer funds. Please try again.");
			}
		} catch (Exception e) {
			System.out.println("Please enter a number.\n");
		}
	}
	
	private void addJointAccountHolder(Account a) {
	}
	
	private void viewBalance(Account a) {
		System.out.printf("Balance for ACCT#%d: $%.2f\n\n", a.getId(), a.getBalance());
	}

	private boolean closeAccount(Account a) {
		boolean result = false;

	    System.out.print("Are you sure you want to close this account? (y/n): ");
	    String answer = scan.nextLine().toLowerCase();

	    switch(answer) {
			case "y":
				if (svc.closeAccount(a) != null) {
					result = true;
					System.out.println("Successfully closed account");
				} else {
					System.out.println("Unable to close account; please try again.");
				}
				break;
			default:
			    break;
		}

		return result;
	}

}
