package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

//the entity annotation tells hibernate that we want this class made into a table
//by default it maps the class to a table of the same name

//The table annotation is an optional annotation that provides additional
//info about the table. For example this can be used to name the table something other than the class naem


//The two annotations required for table creation are the Entity annotation used 
//to map the table and the Id annotation used to mark teh primary key

@Entity
@Table(name = "EMPLOYEE")
public class Employee 
{
	//annotation for primary key
	@Id
	
	//optional tag that changes the name of the column to something other than varible name
	@Column (name="E_ID")
	
	//These two tags are used to automatically generate a number value that
	//will become a unique primay key
	@SequenceGenerator(name="EID_SEQ",sequenceName="EID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="EID_SEQ")
	int employeeId;
	
	@Column(name="FIRST_NAME")
	String fName;
	
	@Column(name="LAST_NAME")
	String lName; 
	
	@Column(name="EMAIL")
	String Email;
	
	@Column(name="PASSWORD")
	String Pass;
	
	@Column(name="IS_MANAGER")
	int isManager;
	
	public Employee ()
	{
		
	}
	
	public Employee(String fName, String lName, String email, String pass, int isManager) {
		super();
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