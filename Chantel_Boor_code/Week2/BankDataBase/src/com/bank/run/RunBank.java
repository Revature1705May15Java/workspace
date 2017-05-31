package com.bank.run;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.bank.pojos.Account;
import com.bank.pojos.AccountType;
import com.bank.pojos.User;
import com.bank.service.Service;

public class RunBank 
{
	static Scanner scan;
	static 	Service service = new Service ();
	
	public static void main(String[] args) 
	{
		String choice = "empty"; //used for user input options
		User u = new User();
		scan = new Scanner (System.in);
		
		while(true)
		{
			
			System.out.println("Welcome to bank"
					+ "\n"
					+"Are you alredy a member? y or n?");
			choice = scan.nextLine();
			
			//does action based on user input
			switch(choice)
			{
			case "y":
			case "Y":
			{
				u = loginBank();
				break;
			}
			case "n":
			case "N":
			{
			    joinBank();
			    u = loginBank();
				break;
			}
			default:
			{
				System.out.println("You must enter y or n");
				continue;
			}
			}
			
			if(u != null)
			{
			System.out.println("Welcome!" + u.getFn() + " " + u.getLn());
			doBankStuff(u);
			break;
			}
			
		}
		
		
	}
	
	static void joinBank ()
	{
		System.out.println("Please enter your first name");
		String fn = scan.nextLine();
		System.out.println("Please enter your last name");
		String ln = scan.nextLine();
		System.out.println("Please enter your email");
		String email = scan.nextLine();
		System.out.println("Please enter your password");
		String pw = scan.nextLine();
		
		
		boolean added = service.AddUser(fn, ln, email, pw);
		
		if(added)
		{
			System.out.println("Congratulations! Your account has been created \n"
					+ "Please login");
		}
		else
		{
			System.out.println("Email is already in uese. Please login.");
		}
		
	}
	
	static User loginBank ()
	{
		User temp = new User();
		
		while(true)
		{
			System.out.print("Welcome! please login\n"
					+ "Eneter email: ");
			String email = scan.nextLine();
			System.out.print("\n Enter password: ");
			String pass = scan.nextLine();
			
			temp = service.loginUser(email, pass);
			
			if(temp == null)
			{
				System.out.println("Inccorrect email or password \n");
				System.out.println("Try again? Y or N?");
				String choice = scan.nextLine();
				
				if (choice.equals("y") || choice.equals("Y"))
					continue;
				else
				{
					System.out.println("User not logged in. If you are a new user please create an Account first \n");
					break;
				}
			}
			else
				break;
			
		}
		
		return temp;
	}
	
	static void doBankStuff (User u)
	{
		//used to show accounts to user
		ArrayList <Account> myAccount = new ArrayList<Account>();
		boolean doingStuff = true;
		
		while(doingStuff)
		{
			myAccount = service.getAccount(u);
			
			//prints to screen accounts if thre are some
			if(myAccount != null)
			{
				System.out.println("\n Your Accounts");
				
				for(Account a: myAccount)
					System.out.println("id: "+a.getId() + " Balance: $" + a.getBalance() + " " + a.getType().getName());
				
			}
			else
			{
				System.out.println("No current accouts");
			}
			
			System.out.println();
			
			//displays avalible actions
			System.out.println("What would you like to do? \n"
					+"1. Add Account \n"
					+ "2. Close Account \n"
					+ "3. Allow another user to access account \n"
					+ "4. View users that can access account \n"
					+ "5. Deposit \n"
					+ "6. Withdraw \n"
					+ "7. Transfer \n"
					+ "8. Logout");
			String choice = scan.nextLine();
			
			// does action based on user choice
			switch(choice)
			{
				case "1":    //add account
				{
					
					//display account types to choose from
					ArrayList <AccountType> ts = service.getTypes(); //used to show user type options
					
					for(AccountType t: ts )
						System.out.println(t.getTypeId() +". " +  t.getName());
					
					System.out.println("Choose type for your Account: ");
					String num = scan.nextLine();
					
					int i = 0;
					
					switch(num)
					{
					case "1":
					{
						 i = 1;
						 break;
					}
					case "2":
					{
						 i = 2;
						 break;
					}
					case "3":
					{
						 i = 3;
						 break;
					}
					default:
					{
						System.out.println("must enter a number 1 - 3");
						continue;
					}
					}
					
					boolean added = service.addAccount(u, i);
					
					if(!added)
					{
						System.out.println("You have over six accounts please close an account before adding another");
					}
					
					break;
					
				}
				case "2": //close account
				{
					System.out.println("Please enter the account number of the account you wish to close");
					
					int id;
					
					try
					{
						id = scan.nextInt();
					}
					catch(InputMismatchException e)
					{
						id = 0;
					}
					
					scan.nextLine(); // clears scanner
					
					boolean closed = service.closeAccount(id);
					
					if(!closed)
					{
						System.out.println("Only valid accounts with a balance of $0 may be closed");
					}
					
					break;
				}
				case "3": // add user to account
				{
					
					//gets account from user
					System.out.println("Please enter the account you want to give access to");
					
					int id;
					
					try
					{
						id = scan.nextInt();
					}
					catch(InputMismatchException e)
					{
						id = 0;
					}
					
					scan.nextLine(); // clears scanner
					
					//gets email from user
					System.out.println("Please enter the name of the user you wish to give access to");
					String email = scan.nextLine();
					
					Boolean done = service.addUserToAccount(email, id);
					
					if(!done)
					{
						System.out.println("Invalid account or user. \n"
								+ "Remeber that accounts may only have four users and users may only have six accounts");
					}
					break;
				}
				case "4": //show users of account
				{
					System.out.println("Please enter the account number of the account you wish to see the users of");
					
					int id;
					
					try
					{
						id = scan.nextInt();
					}
					catch(InputMismatchException e)
					{
						id = 0;
					}
					
					scan.nextLine(); // clears scanner
					
					ArrayList<User> users = service.showUsers(id);
					
					if(users == null)
					{
						System.out.println("Invalid account number");
					}
					
					System.out.println("The users of this account are: ");
					for(User x:users)
					{
						System.out.println(x.getFn() + " " + x.getLn());
					}
					
					break;
				}
				case "5": //deposit
				{
					
					//get account from user
					System.out.println("Please enter the account you wish to deposit to");
					
					int id;
					
					try
					{
						id = scan.nextInt();
					}
					catch(InputMismatchException e)
					{
						id = 0;
					}
					
					scan.nextLine(); // clears scanner
					
					System.out.println("Please enter the amount you would like to deposit");
					
					//get amount from user
					double amount;
					
					try
					{
						amount = scan.nextDouble();
					}
					catch(InputMismatchException e)
					{
						amount = 0;
					}
					
					scan.nextLine(); // clears scanner
					
					boolean done = service.deposit(id, amount);
					
					if(!done)
					{
						System.out.println("Invalid account number");
					}
					
					break;
				}
				case "6": //withdraw
				{
					//get account from user
					System.out.println("Please enter the account you wish to withdraw from");
					
					int id;
					
					try
					{
						id = scan.nextInt();
					}
					catch(InputMismatchException e)
					{
						id = 0;
					}
					
					scan.nextLine(); // clears scanner
					
					System.out.println("Please enter the amount you would like to withdraw");
					
					//get amount from user
					double amount;
					
					try
					{
						amount = scan.nextDouble();
					}
					catch(InputMismatchException e)
					{
						amount = 0;
					}
					
					scan.nextLine(); // clears scanner
					
					boolean done = service.withdraw(id, amount);
					
					if(!done)
					{
						System.out.println("Invalid account number");
					}
					
					break;
				}
				case "7": //transfer
				{
					//get first account from user
					System.out.println("Please enter the account you wish to transfer from");
					
					int from;
					
					try
					{
						from = scan.nextInt();
					}
					catch(InputMismatchException e)
					{
						from = 0;
					}
					
					scan.nextLine(); // clears scanner
					
					//get second account
					System.out.println("Please enter the account you wish to transfer to");
					
					int to;
					
					try
					{
						to = scan.nextInt();
					}
					catch(InputMismatchException e)
					{
						to = 0;
					}
					
					scan.nextLine(); // clears scanner
					
					
					System.out.println("Please enter the amount you would lik to transfer");
					
					//get amount from user
					double amount;
					
					try
					{
						amount = scan.nextDouble();
					}
					catch(InputMismatchException e)
					{
						amount = 0;
					}
					
					scan.nextLine(); // clears scanner
					
					boolean done = service.transfer(from, to, amount);
					
					if(!done)
					{
						System.out.println("Invalid account number");
					}
					
					break;
				}
				case "8": //logout
				{
					doingStuff = false;
					System.out.println("Logged out of Bank");
					break;
				}
				default:
					continue;
			}
			
		}

	}
}
