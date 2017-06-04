package com.bank.run;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Scanner;

import com.bank.pojo.Account;
import com.bank.pojo.User;
import com.bank.service.Service;

public class RunBank {
	static Scanner scan;
	static Service service = new Service();
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		User u = new User();
		Account a = new Account();
		int x = 0, y=0, sw = 0;
		while(x==0){
			
			if(y==0){
				System.out.println("Welcome to GAF Bank"
						+ "\n"
						+ "Are you already a member(1:Y/2:N)?");
				sw = Integer.parseInt(scan.nextLine());
			}else{
				System.out.println("User Created Please Login");
				sw = 1;
			}
			switch(sw){
			case 1:
				System.out.println("please enter your email");
				String em = scan.nextLine();
				System.out.println("please enter your pw");
				String pw = scan.nextLine();
				u = service.getUser(em, pw);
				x=1;
				break;
			case 2:
				joinBank();
				y=1;
				break;
			default:
				System.out.println("not a valid choice");
			}
		}
		System.out.println("Welcome " + u.getFn());
		x=0;
		while(x==0){
			int check = 0;
			System.out.println("What would you like to do? \n"
					+ "1: Show All Accounts \n"
					+ "2: Add Account \n"
					+ "3: Choose Account by ID \n"
					+ "4: Logout\n");
			sw= scan.nextInt();
			
			switch(sw){
			case 1:
				service.showAccounts(u.getId());
				break;
			case 2:
				ArrayList<Account> ck = new ArrayList<Account>();
				ck = service.showAccounts(u.getId());
				int tp = 0;
				try{
					tp = ck.size();
				}catch(NullPointerException e){
					
				}
				if(tp>=6 ){
					System.out.println("Cannot Have More Than 6 Accounts");
					continue;
				}
				double bal = 0;
				int type = 1, temp=0;
				while(temp==0){
					System.out.println("Enter initial deposit: ");
					bal = Double.parseDouble(scan.nextLine());
					System.out.println("Enter Account Type (1:Checking"
							+ ",2:Saving, 3:Credit): ");
					type = Integer.parseInt(scan.nextLine());
					if(type>3){
						System.out.println("Invalid Type");
					}else{
						service.addAccount(u, bal, type);
						temp=2;
					}
				}
				if(bal<0){
					bal = 0;
				}
				break;
			case 3:
				System.out.println("Enter Your Account ID");
				int aid = scan.nextInt();
				a = service.getAccount(aid);
//				if(service.checkClosedAccount(a)){
//					System.out.println("This account is closed you no longer have access.");
//				}
				check = 1;
				break;
			case 4:
				x=1;
				System.out.println("Bye " + u.getFn());
				break;
			default:
				System.out.println("not a valid choice");
			
			}
			while(check==1){
				check = useAccount(check, sw, a, u);
			}
		}
		
	}
	
	static void joinBank(){
		scan = new Scanner(System.in);
		System.out.println("please enter your first name");
		String fn = scan.nextLine();
		System.out.println("please enter your last name");
		String ln = scan.nextLine();
		System.out.println("please enter your email");
		String em = scan.nextLine();
		System.out.println("please enter your pw");
		String pw = scan.nextLine();
		service.addUser(fn, ln, em, pw);//added user to database
		
	}
	
	static User login(){
		scan = new Scanner(System.in);
		System.out.println("please enter your email");
		String em = scan.nextLine();
		System.out.println("please enter your pw");
		String pw = scan.nextLine();
		return service.getUser(em, pw);
	}
	
	static int useAccount(int check, int sw, Account a, User u){
		System.out.println("What would you like to do? \n"
				+ "1: Deposit \n"
				+ "2: Withdraw \n"
				+ "3: Add User to Account \n"
				+ "4: Close Account \n"
				+ "5: Back to main menu\n");
		sw = scan.nextInt();
		
		double newbal = 0;
		switch((int)sw){
		case 1:
			System.out.println("How much do you need to deposit? ");
			newbal = scan.nextDouble();
			service.updateBalance(a, newbal);
			break;
		case 2:
			System.out.println("How much do you need to withdraw? ");
			newbal = -scan.nextDouble();;
			service.updateBalance(a, newbal);
			break;
		case 3:
			System.out.println("Enter the user id of user you want to add to the account: ");
			int userId = Integer.parseInt(scan.next());
			try {
				service.addUserToAccount(a, userId);
			} catch (SQLIntegrityConstraintViolationException e) {
				
			}
			break;
		case 4:
			System.out.println("Are you sure(1:Y/2:N)? ");
			int tmp = Integer.parseInt(scan.next());
			if(tmp==1){
				System.out.println("Ok we keep your money..... lol");
				service.closeAccount(a,u.getId());
			}else{
				System.out.println("Just making sure...");
			}
			break;
		case 5:
			check = 0;
			return check;
		default:
			System.out.println("not a valid choice");
			break;
		}
		return 1;
	}
}
