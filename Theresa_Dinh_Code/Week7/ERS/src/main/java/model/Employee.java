package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component 
@Entity
@Table(name = "EMPLOYEE")
public class Employee 
{
	@Id
	@Column(name = "EMAIL")
	String email; 
	
	@Column(name = "PASSWORD")
	String password; 
	
	@Column(name = "ID")
	@SequenceGenerator(name = "EMPLOYEEID_SEQ", sequenceName = "EMPLOYEEID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMPLOYEEID_SEQ")
	int id; 
	
	@Column(name = "FIRSTNAME")
	String firstName; 
	
	@Column(name = "LASTNAME")
	String lastName;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade	= CascadeType.ALL)
	@Column(name = "ISMANAGER")
	int isManager;

	public Employee()
	{	
	}
	
	public Employee(String email, String password, int id, String firstName, String lastName, int isManager) {
		super();
		this.email = email;
		this.password = password;
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.isManager = isManager;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getIsManager() {
		return isManager;
	}

	public void setIsManager(int isManager) {
		this.isManager = isManager;
	} 
	
	
}
