package com.bank.run;

import java.util.Scanner;

import com.bank.pojos.User;
import com.bank.service.Service;

public class RunBank {

	static Scanner scan;
	static Service service = new Service();
	
	public static void main(String[] args) {

		System.out.println("WELCOME TO DOGGO BANK"
				+"\n"
				+ " Are you already a member?");
		User user = joinBank();
		System.out.println(user);
	}
	
	static User joinBank(){
		scan = new Scanner(System.in);
		System.out.println("Please enter your first name");
		String fn = scan.nextLine();
		System.out.println("Please enter your last name");
		String ln = scan.nextLine();
		System.out.println("Please enter your password");
		String pw = scan.nextLine();
		System.out.println("Please enter your username or email address");
		String uName = scan.nextLine();
		
		return service.addUser(fn, ln, uName, pw);
	}

}
