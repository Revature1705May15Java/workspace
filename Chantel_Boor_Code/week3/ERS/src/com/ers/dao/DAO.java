package com.ers.dao;

import java.util.ArrayList;

import com.ers.pojos.Employee;
import com.ers.pojos.RequestType;
import com.ers.pojos.Requests;

public interface DAO 
{
	
 public Employee getEmployee(String email);
 
 public ArrayList<Employee> getAllEmployee();
 
 public Employee getEmployeeByID(int id);
 
 public int addEmployee(String fn, String ln, String email, String pass, int isM);
 
 public int updateEmployee(int id, String fn, String ln);
 
 public int addRequest(int type, double amount, String purpose, int requster);
 
 public int resolveRequest(int id,int type, int resolver, String note);
 
 public ArrayList<Requests> getR(int id);
 
 public RequestType getType (int i);
 
 public ArrayList<Requests> getAllR();

}
