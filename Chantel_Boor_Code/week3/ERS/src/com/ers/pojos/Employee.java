package com.ers.pojos;

public class Employee 
{
	int employeeId;
	String fName, lName, Email, Pass;
	int isManager;
	
	public Employee ()
	{
		
	}
	
	public Employee(int employeeId, String fName, String lName, String email, String pass, int isManager) {
		super();
		this.employeeId = employeeId;
		this.fName = fName;
		this.lName = lName;
		Email = email;
		Pass = pass;
		this.isManager = isManager;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
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

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPass() {
		return Pass;
	}

	public void setPass(String pass) {
		Pass = pass;
	}

	public int getIsManager() {
		return isManager;
	}

	public void setIsManager(int isManager) {
		this.isManager = isManager;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", fName=" + fName + ", lName=" + lName + ", Email=" + Email
				+ ", Pass=" + Pass + ", isManager=" + isManager + "]";
	}
	
	
	

}
