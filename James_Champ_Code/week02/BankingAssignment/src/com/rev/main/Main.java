package com.rev.main;

import java.util.Scanner;

public class Main {
	private static final String BANK_NAME = "Placeholder Bank Name";
	private static final int INVALID_SELECTION = -1;
	private static final int INITIAL_MENU_ITEMS = 3;
	
	private static Scanner scan;
	
	public static void main(String[] args) {
		run();
	}

	public static void run() {
		scan = new Scanner(System.in);
		
		System.out.println("\tWelcome to " + BANK_NAME + "'s portal.\n");
		
		switch(printInitialOptions()) {
			case 1:
				// log in
				break;
			case 2:
				// create account
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
			
			line = scan.nextLine();
			System.out.println();
			
			try {
				result = Integer.parseInt(line);
				
				if(validateSelection(result, INITIAL_MENU_ITEMS)) {
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
	
	// If no:
		// Sign up (Logged in after successful sign-up)
			// Create account
	// Else:
		// Create new account
			// Is joint account
			// Account type	
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
	
	private static boolean validateSelection(int input, int totalSelections) {
		return input < 1 || input > totalSelections;
	}
	
	private static void printErrorMessage(int totalSelections) {
		System.out.println("\n\tInvalid selection.\n" +
						 	"\tPlease enter a whole number between 1 and " +
							totalSelections + ".\n");
	}
}
