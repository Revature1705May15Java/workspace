package pojos;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;


//make AddUser method to add to arraylist<user>
public class Account 
{
	int id; 
	double balance; 
//	public enum AccountTypes{CHECKING, SAVINGS, CREDIT}
	AccountType type; 
	Timestamp dateOpened;
	Timestamp dateClosed; 
	ArrayList<User> accountUsers;
	
	public Account() {
		super();
	}
	
	public Account(int i)
	{
		super(); 
		id = i; 
	}

	public Account(int id, double balance, AccountType type, Timestamp dateOpened, Timestamp dateClosed,
			ArrayList<User> accountUsers) {
		super();
		this.id = id;
		this.balance = balance;
		this.type = type;
		this.dateOpened = dateOpened;
		this.dateClosed = dateClosed;
		this.accountUsers = accountUsers;
	}
	
	public void addUser(User user)
	{
		accountUsers.add(user);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public AccountType getType() {
		return type;
	}

	public void setType(AccountType type) {
		this.type = type;
	}

	public Timestamp getDateOpened() {
		return dateOpened;
	}

	public void setDateOpened(Timestamp ts) {
		this.dateOpened = ts;
	}

	public Timestamp getDateClosed() {
		return dateClosed;
	}

	public void setDateClosed(Timestamp dateClosed) {
		this.dateClosed = dateClosed;
	}

	public ArrayList<User> getAccountUsers() {
		return accountUsers;
	}

	public void setAccountUsers(ArrayList<User> accountUsers) {
		this.accountUsers = accountUsers;
	}

	@Override
	public String toString() {
		return "Account ID: " + id + ", \n Balance: $" + balance + ", \n Account Type: " + type 
				+ ", \n Date Opened: " + dateOpened + 
				", \n Users with Access to this Account: " + accountUsers + "]";
	} 
	
	
}
