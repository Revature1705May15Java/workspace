package com.bank.run;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.bank.pojos.Account;
import com.bank.pojos.User;
import com.bank.service.Service;
/*
 *  Make sure when creating accounts to add them to the join table.
 * 
 * 
 */
public class RunBank {
	static Service service = new Service();
	static Scanner scan;
	static boolean loggedIn = false;
	static User loggedInUser = null;
	static Account acc = null;
	
	public static void main(String[] args) {
		run();
	}// Shouldn't be making any dao calls here.
	
	public static void run(){
		boolean again = true;
		
		do{	
			scan = new Scanner(System.in);
			if(!loggedIn) { // if not logged in, prompt for new user or logging in, else prompt for account actions.
				
				
				System.out.println("\n----------------------------------------"
								 + "\n|         WELCOME TO A+ BANK!          |"
								 + "\n----------------------------------------"
								 + "\nAre you a member? (0 to quit at any time)");
				String in = scan.nextLine();
				
				
				switch(in.substring(0,1).toLowerCase()){
					case "y":
						login();
						break;
					case "n":
						joinBank();
						login();
						break;
					case "0":
						System.out.println("Have a good day!");
						return;
					default:
						System.out.println("Invalid entry, please try again.");
				}	
			} else { // A user is logged in display account options.
				if(loggedInUser.getAccounts() == null) {
					System.out.println("No accounts found.");
					break;
				}
				
				if(!(acc == null)){
				System.out.println("\n---------------------------------"
								 + "\n  WELCOME TO A+ BANK " + loggedInUser.getFn() + "!"
								 + "\n---------------------------------");
				}
				
				if(acc == null && loggedInUser.getAccounts().size() > 1) {
					System.out.println("\nWe see you have multiple accounts open with us, ");
					for(int i = 0; i < loggedInUser.getAccounts().size(); i++) 
						System.out.print(i + " - " + loggedInUser.getAccounts().get(i).getId() + "\n");
					
					System.out.println("\n Which would you like to use?");
					try{
						int num = Integer.parseInt(scan.nextLine().trim());
						acc = loggedInUser.getAccounts().get(num);
					} catch (Exception E){
						System.out.println("Invalid entry, please try again.");
					}
					continue;
				}
				else if (acc == null && loggedInUser.getAccounts().size() == 1){
					acc = loggedInUser.getAccounts().get(0);
				}
				else if (loggedInUser.getAccounts().size() == 0){ // If the user does not have any open accounts.
					System.out.println("Hello " + loggedInUser.getFn() + ", we do not have an account on record with you."
									 + "\nPlease create an account or log out."
									 + "\n 1. Create Account        0. Log out");
					try{
						int num = scan.nextInt();
						scan.nextLine();
						switch(num){
						case 1:
							openAccount();
							loggedInUser = service.getUser(loggedInUser.getId());
							break;
						case 0:
							loggedIn = false;
							loggedInUser = null;
							break;
							
						default:
							System.out.println("Invalid Entry.");
						}
						
					} catch (Exception E){
						System.out.println("Invalid entry, please try again.");
					}
					
				}
				else {
					
					System.out.println("Account in Use: #" + acc.getId() + ", " + acc.getType() + "    Balance: $" + acc.getBalance());
					System.out.println("\n  How may we assist you today?"
									 + "\n 1. Make a Withdrawal     5. Transfer Money"
									 + "\n 2. Make a Deposit        6. Switch Active Account"
									 + "\n 3. Edit Account          7. Open an Account"
									 + "\n 4. Add User (joint acc)  8. Close this Account"
									 + "\n 0. Log out");
					System.out.print("Enter a Number: ");
					String in = scan.nextLine();
					System.out.println();
					switch(in.substring(0,1).toLowerCase()){
						case "1": // Withdrawal
							System.out.println("How much would you like to withdraw?");
							try{
								int reduceBalance = Integer.parseInt(scan.nextLine().trim());
								service.makeWithdrawal(acc, reduceBalance);
								acc.setBalance(acc.getBalance()-reduceBalance);
							} catch (NumberFormatException e) {
								System.out.println("Invalid ammount, please try again.");
							}
							break;
						case "2": // Deposit
							System.out.println("How much would you like to deposit?");
							try{
								int addBalance = Integer.parseInt(scan.nextLine().trim());
								service.makeDeposit(acc, addBalance);
								acc.setBalance(acc.getBalance()+addBalance);
							} catch (NumberFormatException e) {
								System.out.println("Invalid ammount, please try again.");
							}
							break;
							
						case "3": // Edit Account information
							boolean edit = service.editAccountInfo(editAccount(), loggedInUser);
							if(edit) {
								System.out.println("\nUpdate successful.");
								loggedInUser = service.getUser(loggedInUser.getId()); // Updating active user.
							}
							else System.out.println("Update unsuccessful.");
							break;
						case "4": // Create joint accounts
							System.out.println("Would you like to grant access to this account to another user?");
							String input = scan.nextLine();
							
							switch(input.substring(0,1).toLowerCase()){
								case "y":
									login(acc);
									break;
								case "n":
									break;
								case "0":
									break;
								default:
									System.out.println("Invalid entry, please try again.");
							}
							break;
						case "5": // Transfer Money to another account
							int num = service.transferMoney(acc);
							if(num == 1) {
								acc = null;
								loggedInUser = service.getUser(loggedInUser.getUsername());
							}
							break;
						case "6": // Switch currently active account
							if(loggedInUser.getAccounts().size() > 1) acc = null;
							else System.out.println("You only have one active account.");
							break;
						case "7": // open a new account
							if(loggedInUser.getAccounts().size() < 6) openAccount();
							else System.out.println("\n Too many active accounts.");
							break;
							
						case "8": // close current account
							System.out.println("Are you sure you would like to withdraw the remaining balance "
									 + "and close this account?");
							String ans = scan.nextLine();
							switch(ans.substring(0,1)){
							case "y":
								service.closeAccount(acc);
								acc = null;
								loggedInUser = service.getUser(loggedInUser.getUsername());
								break;
							case "n":
								break;
							default:
								System.out.println("Invalid entry, please try again.");
							}
							break;
							
						case "0": // Exit Banking
							System.out.println("Thank you for banking with us, " + loggedInUser.getFn() + "!");
							acc = null;
							loggedInUser = null;
							loggedIn = false;
							break;
						default:
							System.out.println("Invalid entry, please try again.");
					}
				}
			}
		}while(again);
		scan.close();
	}
	static User joinBank(){
		User temp = new User();
		System.out.println("\nWelcome to A+ Bank! Please create a log in.");
		System.out.print("Enter first name: ");
		String fn = scan.nextLine().trim();
		System.out.print("Enter last name: ");
		String ln = scan.nextLine().trim();
		System.out.print("Enter userName: ");
		String userName = scan.nextLine().trim();
		System.out.print("Enter a password: ");
		String password = scan.nextLine().trim();
		System.out.print("Confirm password: ");
		String password2 = scan.nextLine().trim();
		
		if(password.equals(password2)) {
			temp = service.addUser(fn, ln, userName, password);
			System.out.println("Account creation successful.\n");
		}
		else temp = null;
		return temp;
	}
	
	static void login(){
		do{
			System.out.println("\nRemember: All data is case sensitive!");
			System.out.print("Enter userName: ");
			String userName = scan.nextLine();
			if(userName.equals("0")) return;
			
			System.out.print("Enter a password: ");
			String password = scan.nextLine();
			if(password.equals("0")) return;
			
			User temp = service.getUser(userName);
			
			if(temp == null || !userName.equals(temp.getUsername()) || !password.equals(temp.getPassword())){
				System.out.println("Username or password incorrect. Enter '0' to exit at any time or try again.");
				continue;
			}
			else {
				loggedIn = true; 
				loggedInUser = temp;
				break;
			}
		}while(true);
	}
	
	static void login(Account acc){
		do{
			System.out.println("Remember: All data is case sensitive!");
			System.out.print("Enter userName: ");
			String userName = scan.nextLine();
			if(userName.equals("0")) return;
			User temp = service.getUser(userName);
			
			System.out.print("Enter a password: ");
			String password = scan.nextLine();
			
			if(password.equals("0")) return;
			
			if(temp == null || !userName.equals(temp.getUsername()) || !password.equals(temp.getPassword())){
				System.out.println("Username or password incorrect. Enter '0' to exit at any time or try again.");
				continue;
			}
			else {
				service.joinAcc(acc, temp);
				break;
			}
		}while(true);
	}
	
	public static void openAccount(){
		System.out.println("\nWhat type of account would you like to open? "
				   		 + "\n 1. Checking    2. Savings    3. Credit");
		try{
			int accType = Integer.parseInt(scan.nextLine().trim());
			System.out.println("How much would you like to put down for an opening deposit?");
			int balance = Integer.parseInt(scan.nextLine().trim());
			if(accType == 0 || balance == 0) return; 
			Account temp = service.openAccount(accType, balance, loggedInUser.getId());
			acc = null;
			loggedInUser = service.getUser(loggedInUser.getUsername());
		} catch (NumberFormatException e) {
			System.out.println("Invalid entry, please try again.");
			openAccount();
		}
	}
	
	static String editAccount() throws NumberFormatException{
		System.out.println("What type of account would you like to open? "
		   		 		+ "\n1. Username        3. First name"
		   		 		+ "\n2. Password        4. Last name"
		   		 		+ "\n0. No more edits.");
		String edits = "", columns = "", values = "";
		
		int num = Integer.parseInt(scan.nextLine().trim());
		
		switch(num){
			case 0:
				return "";
			default:
				if(!columns.equals("")) columns += ",";
				if(!values.equals("")) values += ",";
			case 1:
				columns = "user_name";
				System.out.print("Enter new Username: ");
				values += scan.nextLine().trim();
				break;
			case 2:
				columns = "password";
				System.out.print("Enter new password: ");
				values += scan.nextLine().trim();
				break;
			case 3:	
				columns = "first_name";
				System.out.print("Enter new first name: ");
				values += scan.nextLine().trim();
				break;
			case 4:
				columns = "last_name";
				System.out.print("Enter new last name: ");
				values += scan.nextLine().trim();
				break;
		}
		
		edits = columns + ":" + values;
		
		return edits;
	}
}
