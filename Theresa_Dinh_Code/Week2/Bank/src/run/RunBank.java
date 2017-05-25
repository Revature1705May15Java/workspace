package run;

import java.util.Scanner;

import servicelayer.BankService;

public class RunBank 
{
	static Scanner in; 
	static BankService service = new BankService(); 
	
	public static void main(String[] args)
	{
		System.out.println("join bank?");
	}
	
	void joinBank()
	{
		in = new Scanner(System.in); 
		//print out prompts and accept user response
		System.out.println("Enter your first name:");
		String fn = in.nextLine(); 
		System.out.println("Enter your last name");
		String ln = in.nextLine();
		System.out.println("Enter a password");
		String pw = in.nextLine();
		System.out.println("Enter an email");
		String email = in.nextLine(); 
		
		service.addUser(fn, ln, pw, email); 
	}
}
