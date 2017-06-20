package service;

import java.util.ArrayList;

import dao.ERSDao;
import pojos.Employee;
import pojos.Request;

public class ErsService 
{
	ERSDao dao = new ERSDao(); 
	
	public ErsService()
	{
		super(); 
	}
	
	// allow new Employees to register into the system  
	// with their name, a unique email, and a password 
	public Employee registerEmployee(String email, String password, String firstName, String lastName)
	{		
		// if an Employee with the email already exists, prevent addition of Employee to database
		if(dao.getEmployee(email) != null)
		{
			System.out.println("An Employee has already been registered with that email."
					+ "Please try another email.");
			return null; 
		}
		
		Employee employee = new Employee(); 
		employee.setEmail(email);
		employee.setPassword(password);
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		
		return dao.registerEmployee(employee);
	}
    
    // allow Employee to update their personal info 
    // parameters: the Employee of the current session with their id, the first and last names to be changed 
    public boolean updateEmployee(Employee employee, String firstName, String lastName)
    {
        //if the names are empty, keep the old names to prevent overwriting with empty values to db 
        if(!firstName.equals(""))
            employee.setFirstName(firstName); 
        if(!lastName.equals(""))
            employee.setLastName(lastName);    
    
        if(dao.updateEmployee(employee))
        	return true;
        return false; 
    }
	
	// allow manager to promote or demote Employee to manager in db 
	// Parameters: the email of the Employee to be promoted/demoted 
	// and a boolean TRUE if manager, FALSE if not manager 
	public boolean setManager(String email, boolean isManager)
	{
		Employee employee = new Employee();
		employee.setEmail(email);
		
		if(dao.setManager(employee, isManager))
			return true; 
		return false; 
	}
	
	// retrieves user from their unique email login 
	// Parameter: an Employee that has at least its email set 
	public Employee getEmployee(Employee employee)
	{
		Employee temp = dao.getEmployee(employee.getEmail());
		if(temp != null)
		{
			return temp; 
		}
		return null; 
	}
	
	// retrieves user based on their id number in the db 
	// Parameter: Employee id 
	public Employee getEmployee(int id)
	{
		Employee temp = dao.getEmployee(id);
		if(temp != null)
		{
			return temp; 
		}
		return null; 
	}
	
	public ArrayList<Employee> getAllEmployees()
	{
		return dao.getAllEmployees(); 
	}
	
	public ArrayList<Employee> getAllManagers()
	{
		return dao.getAllManagers();
	}
	
	// Return an ArrayList of all Requests ever submitted by an Employee
	// Parameter: the email of the Employee
	public ArrayList<Request> getRequests(String email)
	{
		return dao.getRequests(email); 
	}
	
	public ArrayList<Request> getAllRequests()
	{
		return dao.getAllRequests(); 
	}
	
	// Return an ArrayList of all Pending Requests
	public ArrayList<Request> getPendingRequests()
	{
		return dao.getPendingRequests(); 
	}
	
	// Return an ArrayList of all Approved Requests
	public ArrayList<Request> getApprovedRequests()
	{
		return dao.getApprovedRequests();
	}
	
	// Return an ArrayList of all Denied Requests 
	public ArrayList<Request> getDeniedRequests()
	{
		return dao.getDeniedRequests(); 
	}
	
	// may need to add check for manager status later !!!!!!!!!!!!!!!!!!!!!!!!
	// allows a manager to approve a Request
	// retrieve request by that id, and mark approver as the 
	// manager's employee id 
	// Parameters: the ID of the Request, and an Employee manager 
	// that has at least its Email set
	public boolean approveRequest(int requestId, Employee employee)
	{		
		Request request = new Request(); 
		Employee e = dao.getEmployee(employee);
		
		request.setRequestId(requestId);
		request.setApproverId(e.getId());
		
		// prevent denial if Request is not in pending status
		if((dao.getRequest(request)).getStatusId() != 0)
		{
			System.out.println("This request has already been resolved.");
			return false; 
		}
		
		else if(dao.approveRequest(request))
			return true;
		return false; 
	}
	
	// Denies a Request
	// If the Request is resolved already, don't change its status
	// Parameters: the ID of the Request, and an Employee that has at least its Email set
	public boolean denyRequest(int requestId, Employee employee)
	{
		Request request = new Request(); 
		Employee e = dao.getEmployee(employee);
		
		request.setRequestId(requestId);
		request.setApproverId(e.getId());
		
		// prevent denial if Request is not in pending status
		if((dao.getRequest(request)).getStatusId() != 0)
		{
			System.out.println("This request has already been resolved.");
			return false; 
		}
		else if(dao.denyRequest(request))
			return true;
		return false; 
	}
	
	// submit a Request 
	// Parameters: a double of the amount requested, 
	// a String representation of the purpose (can be empty), 
	// and the email of the Employee submitting the request 
	public boolean submitRequest(double amount, String purpose, String email)
	{
		Request request = new Request(); 
		request.setAmount(amount);
		request.setPurpose(purpose);
		request.setRequesterId((dao.getEmployee(email)).getId()); 
		
		if(dao.submitRequest(request))
			return true;
		return false; 
	}
}