package com.ers.service;

import java.util.ArrayList;


import com.ers.dao.DAO;
import com.ers.dao.DaoImp;
import com.ers.pojos.Employee;
import com.ers.pojos.Requests;

public class Service 
{
	
	static DAO dao = new DaoImp ();
	
	//finds user in database and returns to login
	public Employee login (String email, String pass)
	{
		Employee temp = dao.getEmployee(email);
		
		//checks if employee is found, employee defaults to zero if not found
		if(temp.getEmployeeId() != 0)
		{
			//only logs in if passwords match
			if(temp.getPass().equals(pass))
			return temp;
			else
			{
				temp.setEmployeeId(0);
				return temp;
			}
		}
		else
		{
			temp.setEmployeeId(0);
			return temp;
		}
	}
	
	//gets all employees, will set a default object to array if none are found
	 public ArrayList<Employee> getAllEmployee()
	 {
		 //values for holding result and creating default
			ArrayList<Employee> e = new ArrayList<Employee>();
			Employee temp = new Employee();
			
			e = dao.getAllEmployee();
			
			//sets defualt when nothing if found
			if(e.size() == 0)
			{
				temp.setEmployeeId(0);
				
				e.add(temp);
			}
			
			return e;
	 }
	 
	 //sends employee to dao to be added to database, won't add if email is already being used
	 public boolean addEmployee(String fn, String ln, String email, String pass, String isM)
	 {
		 
		 //check if email exists
		 Employee temp = dao.getEmployee(email);
		 int im;
		 
		 if(isM.equals("yes"))
		 {
			 im = 1;
		 }
		 else
		 {
			 im = 0;
		 }
		 
		 //id will be zero if employee not found, if not found add employee
		 if(temp.getEmployeeId() == 0)
		 {
			 dao.addEmployee(fn, ln, email, pass, im);
			 return true;
		 }
		 
		 //returns false if email found and employee not added
		 return false;
	 }
	 
	 public Employee updateEmployee(int id, String fn, String ln)
	 {
		 //used to return updated employee
		 Employee e = new Employee();
		 
		 dao.updateEmployee(id, fn, ln);
		 e = dao.getEmployeeByID(id);
		 
		 return e;
	 }
	
	 //sets request type to the default of 1(pending) and sends request to be added to database
	public void addRequest (double amount, String purpose, Employee e)
	{
		int requester = e.getEmployeeId();
		int requestTypeNum = 1;
		
		dao.addRequest(requestTypeNum, amount, purpose, requester);
		
		
	}
	
	//gets all requests for a specified employee, returns a list holding a default if nothing found
	public ArrayList<Requests> getRequests(Employee e)
	{
		ArrayList<Requests> r = new ArrayList<Requests>();
		Requests temp = new Requests();
		
		r = dao.getR(e.getEmployeeId());
		
		//sets default if nothing is found
		if(r.size() == 0)
		{
			temp.setRequestId(0);
			r.add(temp);
		}
			
		return r;
	}
	
	//gets all requests, returns a list holding a default if nothing found
	public ArrayList<Requests> getAllR()
	{
		ArrayList<Requests> r = new ArrayList<Requests>();
		Requests temp = new Requests();
		
		r = dao.getAllR();
		
		//sets default if nothing is found
		if(r.size() == 0)
		{
			temp.setRequestId(0);
			
			r.add(temp);
		}
		
		return r;
	}
	
	public void resolveRequest(int id, String note, String status, Employee e)
	{
		int s;
		
		if(status.equals("accepted"))
		{
			s = 2;
		}
		else
		{
			s = 3;
		}
		
		dao.resolveRequest(id,s, e.getEmployeeId(), note);
	}
	
	public String displayIsmanger (int i)
	{
		if(i == 1)
		{
			return "yes";
		}
		
		return "no";
	}
	
	public String displayEName(int i)
	{
		
		//default for if the employee is not set yet
		if(i == 0)
		{
			return "n/a";
		}
		
		//finds employee by id and retruns name for display in table
		Employee e = dao.getEmployeeByID(i);
		String name = e.getfName() + " " + e.getlName();
		return name;
	}

}
