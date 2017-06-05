package service;

import dao.ERSDao;
import pojos.Employee;

public class ErsService 
{
	ERSDao dao = new ERSDao(); 
	
	public ErsService()
	{
		super(); 
	}
	
	// retrieves user from their unique email login 
	public Employee getEmployee(Employee employee)
	{
		Employee temp = dao.getEmployee(employee.getEmail());
		if(temp != null)
		{
			return temp; 
		}
		return null; 
	}
}
