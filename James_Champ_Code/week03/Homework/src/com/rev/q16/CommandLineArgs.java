package com.rev.q16;

public class CommandLineArgs {
	public static void main(String[] args) {
		if(args.length == 0) {
			System.out.println("Please enter a command line argument...");
		}
		else if(args.length > 1) {
			System.out.println("Please enter only one, and only one, command line argument...");
		}
		else {
			String argument = args[0];
			System.out.println("Your argument is: \"" + argument +"\"");
			System.out.println("Its length is " + argument.length());
		}
		
		System.out.println("\nProgram terminated...");
	}
}
