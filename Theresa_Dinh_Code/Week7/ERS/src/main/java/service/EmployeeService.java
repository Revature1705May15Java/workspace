package service;

import dao.Dao;
import dao.EmployeeDao;
import model.Employee;
import model.Request;

public class EmployeeService 
{
	Dao dao = EmployeeDao.getInstance(); 
	
	public Employee createEmployee()
	{
		dao.createEmployee(new Employee()); 
		return null; 
	}
	
	public Request submitRequest()
	{
		dao.submitRequest(new Request()); 
		return null; 
	}
}
