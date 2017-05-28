package com.bank.view;

import com.bank.pojos.Account;
import com.bank.pojos.AccountType;
import com.bank.pojos.User;
import com.bank.service.Service;

import java.util.ArrayList;
import java.util.Scanner;

public class View {

	private Scanner scan = new Scanner(System.in);
	private Service svc = new Service();
	private User currUser;
	private Account currAcct;

	public static void main(String[] args) {
		View v = new View();
		v.showMainPage();
	}

	public void showMainPage() {
		boolean running = true;

		do {
			System.out.println("\t1. Login\n" +
					"\t2. Register new user\n" +
					"\t3. Exit\n"
			);
			System.out.print("Select an action: ");

			int choice = Integer.parseInt(scan.nextLine());
			switch (choice) {
				case 1:
					showLoginPage();
					break;
				case 2:
					showAddUserPage();
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

	private void showLoginPage() {
		System.out.print("Email: ");
		String email = scan.nextLine();

		System.out.print("Password: ");
		String password = scan.nextLine();

		currUser = svc.login(email, password);

		if (currUser == null) {
			System.out.println("\nInvalid login information; please try again.");
		} else {
			System.out.println("\nWelcome, " + currUser.getFirstName() + " " + currUser.getLastName() + "\n");
			showUserActionPage();
		}
	}

	private void showUserActionPage() {
		boolean running = true;

		do {
			System.out.println("\t1. Manage an account\n" +
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
					showAccountsListingPage();
					break;
				case 2:
					showAddAccountPage();
					break;
				case 3:
					showUpdateInformationPage();
					break;
				case 4:
					currUser = null;
					currAcct = null;
					running = false;
					break;
				default:
					System.out.println("Please enter a valid option.");
			}

			System.out.println();
		} while (running);
	}

	private void showUpdateInformationPage() {
		System.out.print("First name: ");
		String fName = scan.nextLine();

		System.out.print("Last name: ");
		String lName = scan.nextLine();

		System.out.print("Email: ");
		String email = scan.nextLine();

		System.out.print("Password: ");
		String password = scan.nextLine();

		User updatedUser = svc.updateUser(currUser, fName, lName, email, password);
		if (updatedUser != null) {
			System.out.println("Successfully updated information.");
			currUser = updatedUser;
		} else {
			System.out.println("Unable to update information; please try again.");
		}
	}

	private void showAccountActionPage() {
		System.out.println();
		boolean running = true;

		do {
			System.out.println("\t1. Deposit\n" +
					"\t2. Withdraw\n" +
					"\t3. Transfer\n" +
					"\t4. Add joint account holder\n" +
					"\t5. Remove joint account holder\n" +
					"\t6. View balance\n" +
					"\t7. Close account\n" +
					"\t8. Back\n"
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
					showDepositPage();
					break;
				case 2:
					showWithdrawPage();
					break;
				case 3:
					showTransferPage();
					break;
				case 4:
					showAddJointAccountHolderPage();
					break;
				case 5:
					if (showRemoveJointAccountHolderPage()) running = false;
					break;
				case 6:
					showBalancePage();
					break;
				case 7:
					if (showCloseAccountPage()) running = false;
					break;
				case 8:
					currAcct = null;
					running = false;
					break;
				default:
					System.out.println("Please enter a valid option.");
			}

			System.out.println();
		} while (running);
	}

	private void showAddUserPage() {
		System.out.print("First name: ");
		String fName = scan.nextLine();

		System.out.print("Last name: ");
		String lName = scan.nextLine();

		System.out.print("Email: ");
		String email = scan.nextLine();

		System.out.print("Password: ");
		String password = scan.nextLine();

		currUser = svc.addUser(fName, lName, password, email);
		if (currUser == null) {
			System.out.println("Unable to create new user; please try again.");
		} else {
			System.out.println("Successfully created new user.");
			showUserActionPage();
		}
	}

	private void showAccountsListingPage() {
		System.out.println();
		boolean running = true;

		do {
			ArrayList<Account> accounts = svc.getAccounts(currUser);

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
			System.out.println("\t" + (openAccounts.size() + 1) + ". Back\n");

			System.out.print("Select an account: ");

			int choice;
			try {
				choice = Integer.parseInt(scan.nextLine());
			} catch (Exception e) {
				System.out.println("Please enter a number.\n");
				continue;
			}

			if (choice <= openAccounts.size() && choice > 0) {
				currAcct = openAccounts.get(choice - 1);
				showAccountActionPage();
			} else if (choice == openAccounts.size() + 1) {
				running = false;
			} else {
				System.out.println("Please enter a valid option.");
			}

			System.out.println();
		} while (running);
	}

	private void showAddAccountPage() {
		boolean running = true;
		ArrayList<AccountType> types = svc.getAccountTypes();

		do {
			for (int i = 0; i < types.size(); i++) {
				AccountType a = types.get(i);
				System.out.println("\t" + (i + 1) + ". " + a);
			}
			System.out.println("\t" + (types.size() + 1) + ". Back\n");

			System.out.print("What type of account would you like to open: ");

			int choice;
			try {
				choice = Integer.parseInt(scan.nextLine());
			} catch (Exception e) {
				System.out.println("Please enter a number.\n");
				continue;
			}

			if (choice >= 1 && choice <= types.size()) {
				currAcct = svc.addAccount(currUser, choice);
				if (currAcct != null) {
					running = false;
					showAccountActionPage();
				} else {
					System.out.println("Unable to create new account");
				}
			} else if (choice == types.size() + 1) {
				running = false;
			} else {
				System.out.println("Please enter a valid option.");
			}

			System.out.println();
		} while (running);
	}

	private void showDepositPage() {
		System.out.print("Enter deposit amount: $");

		double amt;
		try {
			amt = Double.parseDouble(scan.nextLine());

			Account updatedAcct = svc.deposit(currAcct, amt);
			if (updatedAcct != null) {
				System.out.printf("Deposit successful.\nNew balance: $%.2f\n", updatedAcct.getBalance());
				currAcct = updatedAcct;
			} else {
				System.out.println("Unable to deposit money. Please try again.");
			}
		} catch (Exception e) {
			System.out.println("Please enter a number.\n");
		}
	}

	private void showWithdrawPage() {
		System.out.print("Enter withdraw amount: $");

		try {
			double amt = Double.parseDouble(scan.nextLine());

			Account updatedAcct = svc.withdraw(currAcct, amt);
			if (updatedAcct != null) {
				System.out.printf("Withdraw successful.\nNew balance: $%.2f\n", updatedAcct.getBalance());
				currAcct = updatedAcct;
			} else {
				System.out.println("Unable to withdraw money. Please try again.");
			}
		} catch (Exception e) {
			System.out.println("Please enter a number.\n");
		}
	}

	private void showTransferPage() {
		try {
			System.out.print("Enter transfer amount: $");
			double amt = Double.parseDouble(scan.nextLine());

			System.out.print("Enter recipient account ID: ");
			int recipientAccountId = Integer.parseInt(scan.nextLine());

			Account updatedAcct = svc.transfer(currAcct, recipientAccountId, amt);
			if (updatedAcct != null) {
				System.out.printf("Transfer successful.\nNew balance: $%.2f\n", updatedAcct.getBalance());
				currAcct = updatedAcct;
			} else {
				System.out.println("Unable to transfer funds. Please try again.");
			}
		} catch (Exception e) {
			System.out.println("Please enter a number.");
		}
	}

	private void showAddJointAccountHolderPage() {
		System.out.print("Enter email of new account holder: ");
		String holderEmail = scan.nextLine();

		if (svc.addJointAccountHolder(currAcct, holderEmail)) {
			System.out.println("Successfully added " + holderEmail + " to this account.");
		} else {
			System.out.println("Unable to add account holder; please try again.");
		}
	}

	// returns true if user removed self from account
	private boolean showRemoveJointAccountHolderPage() {
		boolean result = false;

		System.out.print("Enter email of account holder to remove: ");
		String holderEmail = scan.nextLine();

		if (svc.removeJointAccountHolder(currAcct, holderEmail)) {
			System.out.println("Successfully removed " + holderEmail + " from this account.");
			if (currUser.getEmail().equals(holderEmail)) {
				result = true;
			}
		} else {
			System.out.println("Unable to remove account holder; please try again.");
		}

		return result;
	}

	private void showBalancePage() {
		System.out.printf("Balance for ACCT#%d: $%.2f\n", currAcct.getId(), currAcct.getBalance());
	}

	private boolean showCloseAccountPage() {
		boolean result = false;

		System.out.print("Are you sure you want to close this account? (y/n): ");
		String answer = scan.nextLine().toLowerCase();

		switch (answer) {
			case "y":
				if (svc.closeAccount(currAcct)) {
					result = true;
					currAcct = null;
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
