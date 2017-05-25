package pojos;

import java.util.ArrayList;

public class User 
{
	int id; 
	String fName, lName, password, email; 
	ArrayList<Account> userAccounts;
	public User() {
		super();
	}
	public User(int id, String fName, String lName, String password, String email, ArrayList<Account> userAccounts) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.password = password;
		this.email = email;
		this.userAccounts = userAccounts;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ArrayList<Account> getUserAccounts() {
		return userAccounts;
	}
	public void setUserAccounts(ArrayList<Account> userAccounts) {
		this.userAccounts = userAccounts;
	} 
	@Override
	public String toString() {
		return "User [id=" + id + ", fName=" + fName + ", lName=" + lName + ", password=" + password + ", email="
				+ email + ", userAccounts=" + userAccounts + "]";
	}
	
}
