package com.rev.main;

import java.util.Scanner;

import com.rev.pojos.User;
import com.rev.service.Service;
import com.rev.util.InputValidator;

// TODO: Add comments.
public class Main {
	private static final String BANK_NAME = "[Placeholder Bank Name]";
	
	private static final int MAX_LOGIN_ATTEMPTS = 3;
	
	private static final int INVALID_SELECTION = -1;
	private static final int INITIAL_MENU_ITEMS = 3;
	private static final int USER_MENU_ITEMS = 3;
	private static final int ACCOUNT_MENU_ITEMS = 7;
	
	private static Scanner scan;
	private static Service service;
	
	/**
	 * Main entry point for this program.
	 * 
	 * @param args	Command line arguments.
	 */
	public static void main(String[] args) {
		run();
	}

	/**
	 * Begins the banking program. Opens the Scanner,
	 * creates a new Service object, prints a welcome
	 * message to the user, and displays the initial
	 * menu.
	 */
	private static void run() {
		scan = new Scanner(System.in);
		service = new Service();
		
		System.out.println("\tWelcome to " + BANK_NAME + "'s portal.\n");
		displayInitialMenu();
	}
	
	// TODO: Rename and add comments.
	private static void displayInitialMenu() {
		switch(printInitialOptions()) {
			case 1:
				login();
				break;
			case 2:
				signUp();
				break;
			case 3:
				exitProgram();
				break;
		}
	}
	
	/**
	 * Displays the initial menu and prompts the user
	 * for a selection. Once a valid selection is made,
	 * the value of the selection is returned.
	 * 
	 * @return	The user's menu item selection.
	 */
	private static int printInitialOptions() {
		int result;
		String line;
		
		System.out.println("\tWhat would you like to do?\n");

		do {
			System.out.println("\t1. Log in to existing account.");
			System.out.println("\t2. Become a member.");
			System.out.println("\t3. Exit program.\n");
			
			System.out.print("\tMake a selection [1 - " + INITIAL_MENU_ITEMS + "]: ");
			
			line = scan.nextLine().trim();
			System.out.println();
			
			try {
				result = Integer.parseInt(line);
				
				if(!validateMenuSelection(result, INITIAL_MENU_ITEMS)) {
					result = INVALID_SELECTION;
					printErrorMessage(INITIAL_MENU_ITEMS);
				}
			}
			catch(NumberFormatException e) {
				result = INVALID_SELECTION;
				printErrorMessage(INITIAL_MENU_ITEMS);
			}
		} while(result == INVALID_SELECTION);
		
		return result;
	}
	
	/**
	 * Logs a user into the banking system, allowing them
	 * to access and modify their accounts.
	 * <p>
	 * This method gets an email from the user. If the email is
	 * valid and matches that of an existing user, the user is then
	 * prompted for a password. If the password is correct, the user
	 * will have access to their accounts.
	 * </p>
	 * <p>
	 * If the password is incorrectly entered three times, the program
	 * will end. This is to simulate a user being locked out of a 
	 * banking system for some amount of time after too many 
	 * unsuccessful login attempts.
	 * </p>
	 */
	private static void login() {
		String email;
		String password;
		
		email = promptForEmail();
		
		if(service.isEmailUnique(email)) {
			System.out.println("\tYou are not a member of " + BANK_NAME + ".\n");
			displayInitialMenu();
		}
		else {
			User user = service.getUser(email);
			int count = MAX_LOGIN_ATTEMPTS;
			boolean isPasswordCorrect = false;
			
			do {
				count--; 
				
				System.out.print("\tEnter your password: ");
				password = scan.nextLine().trim();
				System.out.println();
				
				if(password.equals(user.getPassword())) {
					isPasswordCorrect = true;
				}
				else {
					System.out.println("\tIncorrect password.");
					System.out.print("\t" + count);
					
					if(count != 1){
						System.out.println(" attempts remaining.\n");
					}
					else {
						System.out.println(" attempt remaing.\n");
					}
				}
				
			} while(count > 0 && !isPasswordCorrect);
			
			if(isPasswordCorrect) {
				displayUserMenu(user);
			}
			else {
				System.out.println("\tMaximum login attempts reached.\n");
				exitProgram();
			}
		}
	}
	
	/**
	 * Signs a new user up as a member of the bank. Logs 
	 * the newly created user into the banking system on
	 * success.
	 * <p>
	 * This method first prompts a user for their email 
	 * address. If the given address is not already in the
	 * database, the user is then prompted for their first
	 * name, last name, and a password.
	 * </p>
	 * <p>
	 * If all of the user's input is valid, a new {@code User}
	 * object is created, and the user is added to the database.
	 * The user is then logged into the banking system.
	 * </p>
	 * <p>
	 * If the user enters an email that is already in the database,
	 * the user is taken back to the previous menu.
	 * </p>
	 */
	private static void signUp() {
		String email;
		String firstName;
		String lastName;
		String password;
				
		// Get email
		email = promptForEmail();
		
		
		if(service.isEmailUnique(email)) {	// Email is unique.
			// Get first name:
			do{
				System.out.print("\tEnter your first name: ");
				firstName = scan.nextLine().trim();
				System.out.println();
			} while(firstName.length() == 0);
			
			// Get last name:
			do{
				System.out.print("\tEnter your last name: ");
				lastName = scan.nextLine().trim();
				System.out.println();
			} while(lastName.length() == 0);
			
			// Get password:
			do{
				System.out.print("\tEnter your password: ");
				password = scan.nextLine().trim();
				System.out.println();
			} while(password.length() == 0);
			// TODO: Ensure password is strong before continuing.
	
			User user = service.addUser(firstName, lastName, password, email);
	
			System.out.println("\tYou have successfully became a member of " + BANK_NAME);
			
			displayUserMenu(user);
		}
		else {	// Email exists in the database.
			System.out.println("\tYou are already a member of " + BANK_NAME + ".\n");
			displayInitialMenu();
		}
	}
	
	// TODO: Comments
	public static void displayUserMenu(User user) {
		String line;
		int selection;
		
		System.out.println("\tWelcome, " + user.getFirstName() + 
							" " + user.getLastName() + ".\n");
		
		do {
			System.out.println("\tWhat would you like to do today?\n");
			
			System.out.println("\t1. Create a new account.");
			System.out.println("\t2. View account details.");
			System.out.println("\t3. Log out.");
			
			System.out.print("\n\tMake a selection [1 - " + USER_MENU_ITEMS + "]: ");
			line = scan.nextLine().trim();
			System.out.println();
			
			try {
				selection = Integer.parseInt(line);
			}
			catch(NumberFormatException e) {
				selection = INVALID_SELECTION;
			}
		} while(!validateMenuSelection(selection, USER_MENU_ITEMS));
		
		switch(selection) {
			case 1:
				createNewAccount(user);
				break;
			case 2:
				viewAccountDetails(user);
				break;
			case 3:
				exitProgram();
				break;
		}
	}
	
	private static void createNewAccount(User user) {
		
	}
	

	
	private static void viewAccountDetails(User user) {
		
	}
	
	private static void listAccounts(User user) {
		
	}
	
	// Flow:
		// Create new account
			// Is joint account?
			// Account type?
		// List accounts
		// View account details (List account holders)
			// Choose account if more than one
				// Check balance
				// Deposit
				// Withdraw
				// Transfer funds
				// Close account
				// Add account holder
		// Log out
	
	/**
	 * Prompts the user for an email address, and returns the
	 * address if it is properly formed. While the input is
	 * not properly formed, the user will be prompted for an
	 * email.
	 * 
	 * @return	The user's email address.
	 */
	private static String promptForEmail() {
		String email;
		boolean isValidInput = false;
				
		do {
			System.out.print("\tEnter your email address: ");
			email = scan.nextLine().trim();
			System.out.println();
			
			if(InputValidator.validateEmail(email)) {
				isValidInput = true;
			}
			else {
				System.out.println("\tYour email address was improperly formed.\n");
			}
		} while(!isValidInput);
		
		return email;
	}
	
	/**
	 * Used to end this program. Closes the Scanner and prints a message 
	 * that bids the user adieu.
	 */
	private static void exitProgram() {
		scan.close();
		
		System.out.println("\tThanks for visiting " + BANK_NAME + ".");
		System.out.println("\tHave a great day!\n");
		
		System.out.println("\nProgram terminated...");
	}
	
	/**
	 * Determines whether a user's menu item selection is within range.
	 * 
	 * @param input				The number that the user entered.
	 * @param totalSelections	The total number of menu items in the current menu.
	 * @return					{@code true} if the user's selection is valid, {@code false}
	 * 							otherwise.
	 */
	private static boolean validateMenuSelection(int input, int totalSelections) {
		return input >= 1 || input <= totalSelections;
	}
	
	/**
	 * Prints an error message when a user attempts to choose a menu item that
	 * is out of range.
	 * 
	 * @param totalSelections	The total number of selections in the current
	 * 							menu.
	 */
	private static void printErrorMessage(int totalSelections) {
		System.out.println("\n\tInvalid selection.\n" +
						 	"\tPlease enter a whole number between 1 and " +
							totalSelections + ".\n");
	}
}
