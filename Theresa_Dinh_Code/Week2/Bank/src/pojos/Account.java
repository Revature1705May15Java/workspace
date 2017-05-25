package pojos;

import java.sql.Date;
import java.util.ArrayList;

public class Account 
{
	int id; 
	double balance; 
//	public enum AccountTypes{CHECKING, SAVINGS, CREDIT}
	AccountType type; 
	Date dateOpened, dateClosed; 
	ArrayList<User> accountUsers;
	
	public Account() {
		super();
	}

	public Account(int id, double balance, AccountType type, Date dateOpened, Date dateClosed,
			ArrayList<User> accountUsers) {
		super();
		this.id = id;
		this.balance = balance;
		this.type = type;
		this.dateOpened = dateOpened;
		this.dateClosed = dateClosed;
		this.accountUsers = accountUsers;
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

	public Date getDateOpened() {
		return dateOpened;
	}

	public void setDateOpened(Date dateOpened) {
		this.dateOpened = dateOpened;
	}

	public Date getDateClosed() {
		return dateClosed;
	}

	public void setDateClosed(Date dateClosed) {
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
		return "Account [id=" + id + ", balance=" + balance + ", type=" + type + ", dateOpened=" + dateOpened
				+ ", dateClosed=" + dateClosed + ", accountUsers=" + accountUsers + "]";
	} 
	
	
}