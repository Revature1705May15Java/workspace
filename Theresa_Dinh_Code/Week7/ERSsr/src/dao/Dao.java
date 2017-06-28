package dao;

import java.util.ArrayList;

import pojos.Employee;
import pojos.Request;

public interface Dao 
{
	public Employee registerEmployee(Employee employee);
	public Employee getEmployee(Employee employee);
	public ArrayList<Request> getRequests(String email);
    public ArrayList<Request> getPendingRequests();
    public void approveRequest(Request request);
    public void denyRequest(Request request);
    public void submitRequest(Request request);
}
