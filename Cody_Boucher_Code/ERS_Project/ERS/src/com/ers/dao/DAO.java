package com.ers.dao;

import com.ers.pojos.Employee;
import com.ers.pojos.Reimbursement;


public interface DAO {
	public Employee getEmployee(String username);
	public Employee getEmployee(int id);
	public Employee addEmployee(String username, String password, String firstName, String lastName, boolean isManager);
	public Employee updateEmployee(Employee emp);
	public Reimbursement requestReimbursement(int requesterId, double amount, String purpose);
}
