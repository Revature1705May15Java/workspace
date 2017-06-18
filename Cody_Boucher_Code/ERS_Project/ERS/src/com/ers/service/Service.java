package com.ers.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import com.ers.dao.DAO;
import com.ers.dao.DaoImp;
import com.ers.pojos.Employee;
import com.ers.pojos.Reimbursement;

public class Service {
	static DAO dao = new DaoImp();
	
	public Employee login(String username, String password) {
		Employee emp = dao.getEmployee(username);
		String correctPassword = emp.getPassword();
		if(password.equals(correctPassword)) {
			System.out.println("correct password");
			return emp;
		}
		else {
			System.out.println("incorrect password");
			return null;
		}
	}
	
	//ADD CHECKING TO MAKE SURE USERNAME IS UNIQUE!!!!!!!!!!!!!
	public Employee addEmploye(String username, String password, String firstName, String lastName, boolean isManager) {
		Employee emp = new Employee();
		emp = dao.addEmployee(username, password, firstName, lastName, isManager);
		return emp;
	}
	
	public Employee updateEmployee(Employee emp, String username, String password, String firstName, String lastName) {
		System.out.println("In Service");
		emp.setUsername(username);
		System.out.println(username);
		emp.setPassword(password);
		System.out.println(password);
		emp.setFirstName(firstName);
		System.out.println(firstName);
		emp.setLastName(lastName);
		System.out.println(lastName);
		emp = dao.updateEmployee(emp);
		System.out.println(emp);
		return emp;
		
	}
	
	public Reimbursement updateReimbursement(int id, Employee emp, String note, int state) {
		Reimbursement reim = dao.getReimbursement(id);
		reim.setStateId(state);
		System.out.println("service" + state);
		reim.setResolverId(emp.getId());
		System.out.println("service" + reim.getResolverId());
		reim.setNotes(note);
		System.out.println("service" + note);
		reim = dao.updateReimbursement(reim, note, state);
		return reim;
		
	}
	
	
	public Reimbursement requestReimbursement(Employee emp, Double amount, String purpose) {
		Reimbursement rem = new Reimbursement();
		rem = dao.requestReimbursement(emp.getId(), amount, purpose);
		return rem;
	}
	
	public ArrayList<Reimbursement> getEmpReimbursements(Employee emp) {
		ArrayList<Reimbursement> empReimbursements = new ArrayList<Reimbursement>();
		empReimbursements = dao.getEmployeeReimbursement(emp.getId());
		return empReimbursements;
	}
	
	public ArrayList<Reimbursement> getAllReimbursements() {
		ArrayList<Reimbursement> allReimbursements = new ArrayList<Reimbursement>();
		allReimbursements = dao.getReimbursements();
		return allReimbursements;
	}
}
