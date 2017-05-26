package com.rev.main;

import java.util.Scanner;

import com.rev.pojos.User;
import com.rev.service.Service;
import com.rev.util.InputValidator;

public class Main {
	private static final String BANK_NAME = "[Placeholder Bank Name]";
	
	private static final int MAX_LOGIN_ATTEMPTS = 3;
	private static final int INVALID_SELECTION = -1;
	private static final int INITIAL_MENU_ITEMS = 3;
	
	private static Scanner scan;
	private static Service service;
	
	public static void main(String[] args) {
		run();
	}

	private static void run() {
		scan = new Scanner(System.in);
		service = new Service();
		
		System.out.println("\tWelcome to " + BANK_NAME + "'s portal.\n");
		displayInitialMenu();
	}
	
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
				
				if(validateMenuSelection(result, INITIAL_MENU_ITEMS)) {
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
				// Display user menu
			}
			else {
				System.out.println("\tMaximum login attempts reached.\n");
				exitProgram();
			}
		}
	}
	
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
			
			// TODO: Either log in or go to account holder menu
		}
		else {	// Email exists in the database.
			System.out.println("\tYou are already a member of " + BANK_NAME + ".\n");
			displayInitialMenu();
		}
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
		return input < 1 || input > totalSelections;
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
