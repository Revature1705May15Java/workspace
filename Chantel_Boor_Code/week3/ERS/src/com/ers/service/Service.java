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
		
		if(temp.getEmployeeId() != 0)
		{
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
	
	public void addRequest (double amount, String purpose, Employee e)
	{
		int requester = e.getEmployeeId();
		int requestTypeNum = 1;
		
		dao.addRequest(requestTypeNum, amount, purpose, requester);
		
		
	}
	
	public ArrayList<Requests> getRequests(Employee e)
	{
		ArrayList<Requests> r = new ArrayList<Requests>();
		Requests temp = new Requests();
		
		r = dao.getR(e.getEmployeeId());
		
		if(r.size() == 0)
		{
			temp.setRequestId(0);
			
			r.add(temp);
		}
		
		return r;
	}

}
