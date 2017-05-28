package com.bank.run;

import java.util.Scanner;

import com.bank.pojos.User;
import com.bank.service.Service;

public class RunBank 
{
	static Scanner scan;
	static 	Service service = new Service ();
	
	public static void main(String[] args) 
	{
		System.out.println("Welcome to bank"
				+ "\n"
				+"Are you alredy a member?");
		User user = joinBank();
	}
	
	static User joinBank ()
	{
		scan = new Scanner (System.in);
		System.out.println("Please enter your first name");
		String fn = scan.nextLine();
		System.out.println("Please enter your last name");
		String ln = scan.nextLine();
		System.out.println("Please enter your email");
		String email = scan.nextLine();
		System.out.println("Please enter your password");
		String pw = scan.nextLine();
		
		scan.close();
		
		
		User temp = service.AddUser(fn, ln, email, pw);
		return temp;
		
	}
}
