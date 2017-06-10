package com.ers.service;

import com.ers.dao.DAO;
import com.ers.dao.DaoImp;
import com.ers.pojos.Employee;

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

}
