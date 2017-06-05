package run;

import java.util.Scanner;

import pojos.Account;
import pojos.User;
import service.BankService;

public class RunBank 
{
	static Scanner in; 
	static BankService service = new BankService(); 
	static User currentUser = new User(); //holds email and password of current user
	
	public static void main(String[] args)
	{
		welcome(); 
	}
	
	static void welcome()
	{
		in = new Scanner(System.in); 
		
		System.out.println("Welcome to Nacho Bank. \n"
				+ "Enter a number to choose to login or to create a new \n"
				+ "user account if you don't already have one. \n"
				+ "1: Login to user account \n"
				+ "2: Create a new user account \n"
				+ "3: Exit \n");
		boolean loop = true; 
		do
		{
			int choice = in.nextInt(); 
			switch(choice)
			{
				case 1: 
				{
					loop = false; 
					login();
					break;
				}
				case 2: 
				{
					loop = false; 
					joinBank();
					break;
				}
				case 3:
				{
					loop = false; 
					exit();
					break;
				}
				default: 
				{
					System.out.println("Please enter a valid number choice \n"
					+ "1: Login to user account \n"
					+ "2: Create a new user account \n"
					+ "3: Exit \n");
					loop = true; 
					break;
				}
			}
		}while(loop); 
	}
	
	static void login()
	{
		in = new Scanner(System.in);  
		
		System.out.println("Please enter your login credentials \n"
				+ "User email: ");
		String email = in.nextLine(); 
		System.out.println("Password: ");
		String password = in.nextLine(); 
		currentUser.setEmail(email);
		currentUser.setPassword(password);
		
		if(service.getUser(currentUser) != null)  
		{
			System.out.println("\nLogin successful");
			mainmenu(); 
		}
		else 
		{
			System.out.println("Login failed. Try again?"
								+ "\n 1: Yes"
								+ "\n 2: No \n");
						int yn = in.nextInt(); 
						if(yn == 1) 
							login(); 
						else
							welcome(); 
		}
	}
	
	static void joinBank()
	{
		in = new Scanner(System.in); 
		//print out prompts and accept user response
		System.out.println("Enter your first name");
		String fn = in.nextLine(); 
		System.out.println("Enter your last name");
		String ln = in.nextLine();
		System.out.println("Enter a password");
		String pw = in.nextLine();
		System.out.println("Enter an email");
		String email = in.nextLine(); 
		
		currentUser = service.addUser(fn, ln, pw, email); 
		if(currentUser == null)
		{
			System.out.println("Username already exists. Try again with a new username.");
			joinBank(); 
		}
		else 
			System.out.println("User account creation successful. \n"
				+ "Please log in with your new user account now \n");
		login(); 
	}
	
	static void mainmenu()
	{
		in = new Scanner(System.in); 
		
		System.out.println("What would you like to do next? \n"
				+ "Enter a number to choose \n"
				+ "1: View all your bank accounts \n"
				+ "2: View your user information \n"
				+ "3: Check the balance of an account \n"
				+ "4: Make a withdrawal \n"
				+ "5: Make a deposit \n"
				+ "6: Transfer funds \n"
				+ "7: Create a new bank account \n"
				+ "8: Delete a bank account \n"
				+ "9: Logout");
		
		int choice = in.nextInt();
		switch(choice)
		{
			case 1: //view all accounts owned
			{
				service.viewAccounts(currentUser);	//requires lookup table
				mainmenu(); 
				break; 
			}
			case 2: //view user info 
			{
				service.viewUser(currentUser);
				mainmenu(); 
				break;
			}
			case 3: //check balance
			{
				System.out.println("Enter the id for the bank account you "
						+ "would like to check: ");
				int id = in.nextInt(); 
				//needs a check for wrong ids 
				service.viewBalance(new Account(id));
				mainmenu(); 
				break; 
			}
			case 4: //withdrawal 
			{
				Account account = new Account(); 
				boolean loop = true; 
				do
				{
					System.out.println("Enter the ID for the account you would like "
							+ "to withdraw from");
					int id = in.nextInt(); 
					account.setId(id);
					System.out.print("Enter the amount you would like to withdraw \n"
							+ "$ ");
					double amount = in.nextDouble(); 
					if(service.withdraw(account, amount))
					{
						System.out.println("Withdrawal complete");
						loop = false; 
						mainmenu(); 
					}
					else
					{
						System.out.println("Withdrawal failed. Try again?"
								+ "\n 1: Yes"
								+ "\n 2: No");
						int yn = in.nextInt(); 
						if(yn == 2) 
						{
							loop = false;
							mainmenu(); 
						}
						else
						{
							loop = true; 
						}
						//another if else for ppl who can't type 1 or 2 ?
					}
				}while(loop); 
				mainmenu(); 
				break; 
			}
			case 5: //deposit
			{
				Account account = new Account(); 
				boolean loop = true; 
				do
				{
					System.out.println("Enter the ID for the account you would like "
							+ "to deposit into");
					int id = in.nextInt(); 
					account.setId(id);
					
					System.out.print("Enter the amount you would like to deposit \n"
							+ "$ ");
					double amount = in.nextDouble(); 
					if(service.deposit(account, amount))
					{
						System.out.println("Deposit complete");
						loop = false; 
						mainmenu(); 
					}
					else
					{
						System.out.println("Deposit failed. Try again?"
								+ "\n 1: Yes"
								+ "\n 2: No");
						int yn = in.nextInt(); 
						if(yn == 2) 
						{
							loop = false;
							mainmenu(); 
						}
						else
						{
							loop = true; 
						}
						//another if else for ppl who can't type 1 or 2 
					}
				}while(loop); 
				mainmenu(); 
				break; 
			}
			case 6: //transfer
			{
				Account from = new Account(); 
				Account to = new Account(); 
				boolean loop = true; 
				
				do
				{
					System.out.println("Enter the id of the account you would like to "
							+ "transfer money from: ");
					from.setId(in.nextInt());
					System.out.println("Enter the id of the account you would like to "
							+ "transfer money to"); 
					to.setId(in.nextInt());
					System.out.print("Enter the amount you would like to transfer \n"
							+ "$ ");
					double amount = in.nextDouble(); 
					
					if(service.transfer(from, to, amount))
					{
						System.out.println("Transfer successful"); 
						loop = false; 
						mainmenu(); 
					}
					else
					{
						System.out.println("Transfer failed. Try again?"
								+ "\n 1: Yes"
								+ "\n 2: No");
						int yn = in.nextInt(); 
						if(yn == 2) 
						{
							loop = false;
							mainmenu(); 
						}
						else
						{
							loop = true; 
						}
					}
				}while(loop);
				mainmenu(); 
				break; 
			}
			case 7: //new bank account
			{
				if((currentUser.getUserAccounts()).size() >= 3)
				{
					System.out.println("Account limit has been reached. Delete an existing"
							+ "account to be able to create a new one");
					mainmenu(); 
				}
				boolean loop = true; 
				do
				{
					System.out.println("To begin creating a new bank account, please "
							+ "select the kind of account you would like: \n"
							+ "1: Checking \n"
							+ "2: Savings \n"
							+ "3: Credit");
					int type = in.nextInt(); 
	
					switch(type)  
					{
						case 1: //checking
						{
							service.createAccount(1, currentUser);
							System.out.println("Account created successfully"); 
							loop = false; 
							break; 
						}
						case 2: //savings
						{
							service.createAccount(2, currentUser);
							System.out.println("Account created successfully"); 
							loop = false; 
							break;
						}
						case 3: //credit
						{
							service.createAccount(3, currentUser);
							System.out.println("Account created successfully"); 
							loop = false; 
							break;
						}
						default: //
						{
							System.out.println("Please enter a valid number. Try again?"
								+ "\n 1: Yes"
								+ "\n 2: No");
							int yn = in.nextInt(); 
							if(yn == 2) 
							{
								loop = false;
								mainmenu(); 
							}
							else
							{
								loop = true; 
							}
						}
					}
				}while(loop);
				mainmenu(); 
				break; 
			}
			case 8: //delete bank account
			{
				Account account = new Account(); 
				boolean loop = true; 
				do
				{
					System.out.println("Enter the id for the bank account you "
							+ "would like to cancel: ");
					int id = in.nextInt(); 
					account.setId(id);
					if(service.deleteAccount(account, currentUser))
					{
						System.out.println("Cancellation successful");
						loop = false; 
						mainmenu(); 
					}
					else
					{
						System.out.println("Cancellation failed. Try again?"	
								+ "\n 1: Yes"
								+ "\n 2: No");
						int yn = in.nextInt(); 
						if(yn == 2) 
						{
							loop = false;
							mainmenu(); 
						}
						else
						{
							loop = true; 
						}
					}
				}while(loop); 
				mainmenu(); 
				break; 
			}
			case 9: //logout 
			{
				exit(); 
				break; 
			}
			default: 
			{
				System.out.println("Please enter a valid number choice\n");
				mainmenu(); 
				break; 
			}
		}
	}
	
	static void exit()
	{
		System.out.println("Thank you for using Nacho Bank.\n");
	}
}
