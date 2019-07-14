package com.revature.beans;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name = "EMPLOYEE")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empSeq")
	@SequenceGenerator(allocationSize = 1, name = "empSeq", sequenceName = "EMP_SEQ")
	@Column(name = "EMPLOYEE_ID")
	private int employee_id;
	
	@Column(name = "First_NAME")
	private String fn;
	
	@Column(name = "LAST_NAME")
	private String ln;
	
	@Column(name = "PASSWORD")
	private String pw; 
	
	@Column(name = "USERNAME")
	private String uname;
	
	@Column(name = "IS_MANAGER")
	private int is_manager;
	
	@OneToMany(mappedBy = "REQUEST", fetch = FetchType.EAGER)
	@JoinColumn(name="EMPLOYEE_REQUESTS")
	private ArrayList<Request> employee_request;
	
	
	private ArrayList<Employee> employees;
	
	
	public Employee(){}
	
	public Employee(int employee_id, String fn, String ln, String pw, String uname, int is_manager,
			ArrayList<Request> employee_request) {
		super();
		this.employee_id = employee_id;
		this.fn = fn;
		this.ln = ln;
		this.pw = pw;
		this.uname = uname;
		this.is_manager = is_manager;
		this.employee_request = employee_request;
	}

	public Employee(int employee_id, String fn, String ln, String pw, String uname, int is_manager,
			ArrayList<Request> employee_request, ArrayList<Employee> employees, String employeeFullName) {
		super();
		this.employee_id = employee_id;
		this.fn = fn;
		this.ln = ln;
		this.pw = pw;
		this.uname = uname;
		this.is_manager = is_manager;
		this.employee_request = employee_request;
		this.employees = employees;
	
	}

	public ArrayList<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}

	
	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getFn() {
		return fn;
	}

	public void setFn(String fn) {
		this.fn = fn;
	}

	public String getLn() {
		return ln;
	}

	public void setLn(String ln) {
		this.ln = ln;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public int getIs_manager() {
		return is_manager;
	}

	public void setIs_manager(int is_manager) {
		this.is_manager = is_manager;
	}

	public ArrayList<Request> getEmployee_request() {
		return employee_request;
	}

	public void setEmployee_request(ArrayList<Request> employee_request) {
		this.employee_request = employee_request;
	}

	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", fn=" + fn + ", ln=" + ln + ", pw=" + pw + ", uname=" + uname
				+ ", is_manager=" + is_manager + ", employee_request=" + employee_request + ", employees=" + employees
				+ ", employeeFullName=" + "]\n";
	}
	
	
	
}
