package com.rev.main;

import java.util.Scanner;

import com.rev.pojos.User;
import com.rev.service.Service;
import com.rev.util.InputValidator;

public class Main {
	private static final String BANK_NAME = "[Placeholder Bank Name]";
	
	private static final int INVALID_SELECTION = -1;
	private static final int INITIAL_MENU_ITEMS = 3;
	
	private static Scanner scan;
	private static Service service;
	
	public static void main(String[] args) {
		run();
	}

	public static void run() {
		scan = new Scanner(System.in);
		service = new Service();
		
		System.out.println("\tWelcome to " + BANK_NAME + "'s portal.\n");
		
		switch(printInitialOptions()) {
			case 1:
				// log in
				break;
			case 2:
				signUp();
				break;
			case 3:
				exitProgram();
				break;
		}
	}
	
	// TODO: Add ability to exit program.
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
					printErrorMessage(2);
				}
			}
			catch(NumberFormatException e) {
				result = INVALID_SELECTION;
				printErrorMessage(2);
			}
			

		} while(result == INVALID_SELECTION);
		
		return result;
	}
	
	private static void logIn() {
		String email;
		String password;
		
		
	}
	
	
	private static void signUp() {
		String email;
		String firstName;
		String lastName;
		String password;
		
		boolean isValidInput = false;
		
		do {
			System.out.print("\tEnter your email address: ");
			email = scan.nextLine().trim();
			System.out.println();
			
			if(InputValidator.validateEmail(email)) {
				isValidInput = true;
			}
			else {
				System.out.println("\n\tYour email address was improperly formed.\n");
			}
		} while(!isValidInput);
		
		//TODO: Ensure email address is unique before continuing.
		
		do{
			System.out.print("\tEnter your first name: ");
			firstName = scan.nextLine().trim();
			System.out.println();
		} while(firstName.length() == 0);
		
		do{
			System.out.print("\tEnter your last name: ");
			lastName = scan.nextLine().trim();
			System.out.println();
		} while(lastName.length() == 0);
		
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
