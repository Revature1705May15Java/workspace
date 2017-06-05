	package pojos;

import java.util.ArrayList;

public class User 
{
	int id; 
	String fName, lName, password, email; 
	ArrayList<Account> userAccounts = new ArrayList<Account>();
//	int accountsOwned; 
	
	public User() 
	{
		super();
	}
	
	public User(String password, String email)
	{
		this.password = password;
		this.email = email;
		this.userAccounts = new ArrayList<Account>();
	}
	
	public User(String fName, String lName, String password, String email) 
	{
		super();
		this.id = -1;
		this.fName = fName;
		this.lName = lName;
		this.password = password;
		this.email = email;
		this.userAccounts = new ArrayList<Account>();
	}
	
	public User(int id, String fName, String lName, String password, String email, ArrayList<Account> userAccounts) 
	{
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.password = password;
		this.email = email;
		this.userAccounts = userAccounts;
//		accountsOwned = 0; 
	}
	
//	public int getAccountsOwned() {
//		return accountsOwned;
//	}
//	public void incAccountsOwned() {
//		accountsOwned++;
//	}
//	
//	public void decAccountsOwned()
//	{
//		accountsOwned--; 
//	}
	
	public int getId() 
	{
		return id;
	}
	
	public void setId(int id) 
	{
		this.id = id;
	}
	
	public String getfName() 
	{
		return fName;
	}
	
	public void setfName(String fName) 
	{
		this.fName = fName;
	}
	
	public String getlName() 
	{
		return lName;
	}
	
	public void setlName(String lName) 
	{
		this.lName = lName;
	}
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
	public String getEmail() 
	{
		return email;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}
	public ArrayList<Account> getUserAccounts() 
	{
		return userAccounts;
	}
	public void setUserAccounts(ArrayList<Account> userAccounts) 
	{
		this.userAccounts = userAccounts;
	} 
	public void addUserAccount(Account account)
	{
		userAccounts.add(account);
	}
	
	public void removeUserAccount(Account account)
	{
		userAccounts.remove(account); 
	}
	@Override
	public String toString() 
	{
		return "User ID: " + id + ", First Name: " + fName + ", Last Name: " + lName + ", "
				+ "Password: " + password + ", Email: "	+ email + 
				", Number of Accounts Owned:" + userAccounts.size() + "]";
	}
	
}
