package com.bank.run;

import java.util.Scanner;

import com.bank.pojos.User;
import com.bank.service.Service;

public class RunBank {
	static Scanner scan;
	static Service service = new Service();
	
	public static void main(String[] args) {
		System.out.println("Welcome to bank"
				+ "\n"
				+ "Are you a member ");
		User user = joinBank();
		System.out.println(user);
	}
	
	static User joinBank() {
		scan = new Scanner(System.in);
		System.out.println("Please enter your first name ");
		String firstName = scan.nextLine();
		System.out.println("Please enter your last name ");
		String lastName = scan.nextLine();
		System.out.println("Please enter your username ");
		String userName = scan.nextLine();
		System.out.println("Please enter your password ");
		String password = scan.nextLine();
		
		return service.addUser(firstName, lastName, userName, password);
	}
}
