package com.rev.main;

import java.util.Scanner;

public class Main {
	private static final String BANK_NAME = "Placeholder Bank Name";
	private static final int INVALID_SELECTION = -1;
	
	private static Scanner scan;
	
	public static void main(String[] args) {
		run();
	}

	public static void run() {
		scan = new Scanner(System.in);
		
		System.out.println("\tWelcome to " + BANK_NAME + " portal.\n");
		
		while(true) {
			System.out.println(printInitialOptions());
		}
	}
	
	// TODO: Add ability to exit program.
	private static int printInitialOptions() {
		int result;
		String line;
		
		System.out.println("\tWhat would you like to do?\n");

		do {
			
			System.out.println("\t1. Log in to existing account.");
			System.out.println("\t2. Become a member.\n");
			
			System.out.print("\tMake a selection [1 - 2]: ");
			
			line = scan.nextLine();
			System.out.println();
			
			try {
				result = Integer.parseInt(line);
				
				if(result < 1 || result > 2) {
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
	// Prompt for account holder
	
	// If no:
		// Sign up (Logged in after successful sign-up)
			// Create account
	// Else:
		// List accounts
		// View account details (List account holders)
			// Choose account if more than one
				// Check balance
				// Deposit
				// Withdraw
				// Transfer funds
				// Close account
				// Add account holder
		// Create new account
			// Is joint account
			// Account type
		// Log out
	
	private static void printErrorMessage(int totalSelections) {
		System.out.println("\n\tInvalid selection.\n" +
						 	"\tPlease enter a whole number between 1 and " +
							totalSelections + ".\n");
	}
}
