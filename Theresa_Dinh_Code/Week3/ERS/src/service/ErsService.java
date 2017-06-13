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
	public void registerEmployee(String email, String password, String firstName, String lastName)
	{		
		// if an Employee with the email already exists, prevent addition of Employee to database
		if(dao.getEmployee(email) != null)
		{
			System.out.println("An Employee has already been registered with that email."
					+ "Please try another email.");
			return; 
		}
		
		Employee employee = new Employee(); 
		employee.setEmail(email);
		employee.setPassword(password);
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		
		dao.registerEmployee(employee); 
	}
	
	// allow manager to promote or demote Employee to manager in db 
	// Parameters: the email of the Employee to be promoted/demoted 
	// and a boolean TRUE if manager, FALSE if not manager 
	public void setManager(String email, boolean isManager)
	{
		Employee employee = new Employee();
		employee.setEmail(email);
		
		dao.setManager(employee, isManager);
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
	
	// Return an ArrayList of all Requests ever submitted by an Employee
	// Parameter: the email of the Employee
	public ArrayList<Request> getRequests(String email)
	{
		return dao.getRequests(email); 
	}
	
	// Return an ArrayList of all Pending Requests
	public ArrayList<Request> getPendingRequests()
	{
		return dao.getPendingRequests(); 
	}
	
	// may need to add check for manager status later !!!!!!!!!!!!!!!!!!!!!!!!
	// allows a manager to approve a Request
	// retrieve request by that id, and mark approver as the 
	// manager's employee id 
	// Parameters: the ID of the Request, and an Employee manager 
	// that has at least its Email set
	public void approveRequest(int requestId, Employee employee)
	{		
		Request request = new Request(); 
		Employee e = dao.getEmployee(employee);
		
		request.setRequestId(requestId);
		request.setApproverId(e.getId());
		
		// prevent denial if Request is not in pending status
		if((dao.getRequest(request)).getStatusId() != 0)
		{
			System.out.println("This request has already been resolved.");
			return; 
		}
		
		dao.approveRequest(request);
		return; 
	}
	
	// Denies a Request
	// If the Request is resolved already, don't change its status
	// Parameters: the ID of the Request, and an Employee that has at least its Email set
	public void denyRequest(int requestId, Employee employee)
	{
		Request request = new Request(); 
		Employee e = dao.getEmployee(employee);
		
		request.setRequestId(requestId);
		request.setApproverId(e.getId());
		
		// prevent denial if Request is not in pending status
		if((dao.getRequest(request)).getStatusId() != 0)
		{
			System.out.println("This request has already been resolved.");
			return; 
		}
		
		dao.denyRequest(request);
		return; 
	}
	
	// submit a Request 
	// Parameters: a double of the amount requested, 
	// a String representation of the purpose (can be empty), 
	// and the email of the Employee submitting the request 
	public void submitRequest(double amount, String purpose, String email)
	{
		Request request = new Request(); 
		request.setAmount(amount);
		request.setPurpose(purpose);
		request.setRequesterId((dao.getEmployee(email)).getId()); 
		
		dao.submitRequest(request);
		return;
	}
}
