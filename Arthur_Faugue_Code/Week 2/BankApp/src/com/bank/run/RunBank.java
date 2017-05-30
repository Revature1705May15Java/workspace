package com.bank.run;

import java.util.Scanner;

import com.bank.pojo.User;
import com.bank.service.Service;

public class RunBank {
	static Scanner scan;
	static Service service = new Service();
	public static void main(String[] args) {
		
		System.out.println("Welcome to bank"
				+ "\n"
				+ "Are you already a member?");
		User user = joinBank();
		
		System.out.println("Welcome " + user.getFn());
		
	}
	
	static User joinBank(){
		scan = new Scanner(System.in);
		System.out.println("please enter your first name");
		String fn = scan.nextLine();
		System.out.println("please enter your last name");
		String ln = scan.nextLine();
		System.out.println("please enter your email");
		String em = scan.nextLine();
		System.out.println("please enter your pw");
		String pw = scan.nextLine();
		
		
		return service.add(fn, ln, em, pw);
	}
}
