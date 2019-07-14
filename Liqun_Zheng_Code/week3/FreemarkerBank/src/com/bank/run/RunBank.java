package com.bank.run;

import java.util.ArrayList;
import java.util.Scanner;

import com.bank.dao.DAO;
import com.bank.pojos.Account;
import com.bank.pojos.User;
import com.bank.service.Service;

public class RunBank {
	
	static Scanner scan;
	static Service service = new Service();
	
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		
		User user=null;
		System.out.println("WELCOME TO BOSS BANK"
				+ "\n"
				+ " Are you already a member? (Y/N)");
		String yn = scan.nextLine();
		if (yn.equals("N")){
			do{
				user = joinBank();
				if(user == null){
					System.out.println("Username already exist, re-enter your information");
				}
				else{
					System.out.println("User created"+user.toString());
					
				}
			}while(user ==null);
		}
		while(user == null){
			user = signinBank();
			if(user== null){
				System.out.println("password does not match");
			}
			else{
				System.out.println("Signin successful ");
			}
		}
		user = userPage(user);
		
	}
	
	//userpage after a user has been logged in
	static User userPage(User user){
		boolean loop = true;
		int input;
		do{
			System.out.println("Welcome " + user.getFn());
			System.out.println("What would you like to do?");
			System.out.println("Option 1 open account");
			System.out.println("Option 2 close account");
			System.out.println("Option 3 check balance");
			System.out.println("Option 4 deposit");
			System.out.println("Option 5 withdraw");
			System.out.println("Option 6 create joint account");
			System.out.println("Option 7 transfer money");
			System.out.println("Option 8 sign out");
			input = scan.nextInt();
			switch(input){
				case 1:	Account acc = openAcc(user);
						if(acc == null){
							System.out.println("Reached Account limit! You cannot create another account");
						}
						else{
							ArrayList<Account> accs = user.getUserAccounts();
							if(accs==null){
								accs = new ArrayList<Account>();
							}
							accs.add(acc);
							user.setUserAccounts(accs);
						}
						break;
				case 2: if(user.getUserAccounts()==null){
							System.out.println("No accounts, please create account first");
						}
						else{
							user = closeAcc(user);
							}
						break;
				case 3: checkBala(user);
						break;
				case 4: deposit(user);
						break;
				case 5: withdraw(user);
						break;
				case 6: createJoinAcc(user);
						break;
				case 7: transferMoney(user);
						break;
				case 8: System.out.println("You successfully signed out");
						loop = false;
						break;
			}
		}while(loop);
		return user;
	}
	
	
	//method of user create joint accounts
	static User createJoinAcc(User user){
		scan = new Scanner(System.in);
		int join;
		int i;
		user.setUserAccounts(service.getAllAccByUserId(user.getId()));
		for(i = 1; i <= user.getUserAccounts().size(); i++){
			System.out.println("("+ i +") " + user.getUserAccounts().get(i-1).toString());
		}
		System.out.println("Which account do you want to joint with another user? or skip: 0");
		do{
			join = scan.nextInt();
			if(join == 0) break;
			else if(join>user.getUserAccounts().size() || join<1){
				System.out.println("Please enter vaild input");
			}
			else if(!service.CheckAccLimit(user.getUserAccounts().get(join-1).getId())){
				System.out.println("Account exceed maxium users limit, Please enter another account");
			}
			
		}
		while(join>user.getUserAccounts().size() || join<1 || (!service.CheckAccLimit(user.getUserAccounts().get(join-1).getId())));
		System.out.println("Please sign in second user to joint this account");
		User user2 = null;
		while(user2 == null){
			user2 = signinBank();
			if(user2== null){
				System.out.println("password does not match");
			}
			else{
				System.out.println("Signin successful ");
			}
		}
		user2 = service.joinAcc(user2, user.getUserAccounts().get(join-1).getId());
		System.out.println("Joint account been made!");
		return user;
	}
	
	//transfer money between different accounts in same user.
	static User transferMoney(User user){
		scan = new Scanner(System.in);
		int out, in;
		int i;
		user.setUserAccounts(service.getAllAccByUserId(user.getId()));
		for(i = 1; i <= user.getUserAccounts().size(); i++){
			System.out.println("("+ i +") " + user.getUserAccounts().get(i-1).toString());
		}
		System.out.println("Which accounts do you want to do the transfer?");
		do{
			System.out.println("Which account do you want transfer from?");
			out = scan.nextInt();
			if(out>user.getUserAccounts().size() || out<1){
				System.out.println("Please enter vaild input");
			}
		}
		while(out>user.getUserAccounts().size() || out<1);
		do{
			System.out.println("Which account do you want transfer to?");
			in = scan.nextInt();
			if(in>user.getUserAccounts().size() || in<1){
				System.out.println("Please enter vaild input");
			}
		}
		while(in>user.getUserAccounts().size() || in<1);
		double dep;
		do{System.out.println("How much do you want to transfer?");
			dep = scan.nextDouble();
			if(dep> user.getUserAccounts().get(out-1).getBalance()){
				System.out.println("Your account doesn't have enough funds"+ user.getUserAccounts().get(out-1).getBalance());
			}
			else if(dep<0){
				System.out.println("Please enter an positive value!");
			}
		}while(dep<0||dep> user.getUserAccounts().get(out-1).getBalance());
		
		
		user = service.withdraw(user, user.getUserAccounts().get(out-1).getId(), dep);
		user = service.deposit(user, user.getUserAccounts().get(in-1).getId(), dep);
		
		return user;
	}
	
	//withdraw from account 
	static User withdraw(User user){
		scan = new Scanner(System.in);
		int input;
		int i;
		user.setUserAccounts(service.getAllAccByUserId(user.getId()));
		for(i = 1; i <= user.getUserAccounts().size(); i++){
			System.out.println("("+ i +") " + user.getUserAccounts().get(i-1).toString());
		}
		System.out.println("Which account do you want to withdraw to?");
		do{
			input = scan.nextInt();
			if(input>user.getUserAccounts().size() || input<1){
				System.out.println("Please enter vaild input");
			}
		}
		while(input>user.getUserAccounts().size() || input<1);
		double dep;
		do{System.out.println("How much do you want to withdraw");
			dep = scan.nextDouble();
			if(dep> user.getUserAccounts().get(input-1).getBalance()){
				System.out.println("Your account doesn't have enough funds"+ user.getUserAccounts().get(input-1).getBalance());
			}
			else if(dep<0){
				System.out.println("Please enter an positive value!");
			}
		}while(dep<0||dep> user.getUserAccounts().get(input-1).getBalance());
		user = service.withdraw(user, user.getUserAccounts().get(input-1).getId(), dep);
		
		
		return user;
	}
	
	//deposit to a account
	static User deposit(User user){
		scan = new Scanner(System.in);
		int input;
		int i;
		user.setUserAccounts(service.getAllAccByUserId(user.getId()));
		for(i = 1; i <= user.getUserAccounts().size(); i++){
			System.out.println("("+ i +") " + user.getUserAccounts().get(i-1).toString());
		}
		System.out.println("Which account do you want to deposit to?");
		do{
			input = scan.nextInt();
			if(input>user.getUserAccounts().size() || input<1){
				System.out.println("Please enter vaild input");
			}
		}
		while(input>user.getUserAccounts().size() || input<1);
		double dep;
		do{System.out.println("How much do you want to deposit");
			dep = scan.nextDouble();
			if(dep<0){
				System.out.println("Please enter an positive value!");
			}
		}while(dep<0);
		user = service.deposit(user, user.getUserAccounts().get(input-1).getId(), dep);
		
		
		return user;
	}
	
	//check balance of account
	static User checkBala(User user){
		scan = new Scanner(System.in);
		String input;
		int i;
		user.setUserAccounts(service.getAllAccByUserId(user.getId()));
		for(i = 1; i <= user.getUserAccounts().size(); i++){
			System.out.println("("+ i +") " + user.getUserAccounts().get(i-1).toString());
		}
		System.out.println("Input anything to continue.");

			input = scan.nextLine();
		
		return user;
	}
	
	//close an account
	static User closeAcc(User user){
		scan = new Scanner(System.in);
		int input;
		int i;
		user.setUserAccounts(service.getAllAccByUserId(user.getId()));
		for(i = 1; i <= user.getUserAccounts().size(); i++){
			System.out.println("("+ i +") " + user.getUserAccounts().get(i-1).toString());
		}
		System.out.println("Which account do you want to delete?");
		do{
			input = scan.nextInt();
			if(input>user.getUserAccounts().size() || input<1){
				System.out.println("Please enter vaild input");
			}
		}
		while(input>user.getUserAccounts().size() || input<1);
		
		user = service.closeAcc(user, user.getUserAccounts().get(input-1).getId());
		
		
		return user;
		
	}
	
	//open an account
	static Account openAcc(User user){
		if(service.CheckUserLimit(user)){
			scan = new Scanner(System.in);
			int input;
			do{
				System.out.println("Please enter account type");
				System.out.println("(1) Checking");
				System.out.println("(2) Saving");
				System.out.println("(3) Credit Card");
				input = scan.nextInt();
				if(input>3 || input <1){
					System.out.println("Please enter 1-3");
				}
			}while(input>3 || input<1);
			return service.addAccount(user, input);
		}
		else
			return null;
	}
	
	//sign up user
	static User joinBank(){
		scan = new Scanner(System.in);
		System.out.println("Please enter your first name");
		String fn = scan.nextLine();
		System.out.println("Please enter your last name");
		String ln = scan.nextLine();
		System.out.println("Please enter your password");
		String pw = scan.nextLine();
		System.out.println("Please enter username or email address");
		String uname = scan.nextLine();
		
		return service.addUser(fn, ln, uname, pw);
		
	}
	//sign in to bank
	static User signinBank(){
		scan = new Scanner(System.in);
		System.out.println("Please enter your username");
		String uname = scan.nextLine();
		System.out.println("Please enter your password");
		String pw = scan.nextLine();
		
		return service.Signin(uname, pw);
	}
}
