package com.ers.dao;

import java.util.List;

import com.ers.pojos.Employee;
import com.ers.pojos.Request;
import com.ers.pojos.RequestState;

public interface DAO {
	/**
	 * Returns an {@code Employee} that has the given email address.
	 * 
	 * @param email	An employee's email address.
	 * @return	An {@code Employee} that has the given email address, or
	 * 			{@code null} if no such employee exists.
	 */
	public Employee getEmployee(String email);
	
	/**
	 * Returns an {@code Employee} that has the given ID number.
	 * 
	 * @param id	An employee's ID number.
	 * @return		An {@code Employee} that has the given ID number,
	 * 				or {@code null} if no such employee exists.
	 */
	public Employee getEmployee(int id);
	
	/**
	 * Adds the given {@code Employee} to persistent storage.
	 * 
	 * @param employee	{@code Employee} that will be stored.
	 * @return			{@code Employee} with updated information, or
	 * 					{@code null} if the employee could not be stored.
	 */
	public Employee addEmployee(Employee employee);
	
	/**
	 * Updates persisted employee information with data found in the 
	 * given {@code Employee} object.
	 * 
	 * @param employee	{@code Employee} that contains the new employee
	 * 					data.
	 * @return			An {@code Employee} object with additional information,
	 * 					or {@code null} if the employee's data could not be
	 * 					updated.
	 */
	public Employee updateEmployee(Employee employee);
	
	/**
	 * Returns a list of all employees.
	 * 
	 * @return	A list of all {@code Employee} objects.
	 */
	public List<Employee> getAllEmployees();
	
	/**
	 * Adds a new reimbursement request to persistent storage.
	 * 
	 * @param request	A {@code Request} object that represents a 
	 * 					reimbursement request.	
	 * @return			A {@code Request} object with additional information,
	 * 					or {@code null} if the request could not be stored.
	 */
	public Request addRequest(Request request);
	
	/**
	 * Returns a list of all {@code Request} objects that have the given
	 * {@code RequestState}.
	 * 
	 * @param state	The current state of the requests that will be returned
	 * 				from persistent storage.
	 * @return		A list of {@code Request} objects with the given state.
	 */
	public List<Request> getAllRequests(RequestState state);
	
	/**
	 * Returns a list of all requests that were made by the given employee.
	 * 
	 * @param employee	Identifies the employee whose requests will be returned.
	 * @return			A list of requests made by the given employee.
	 */
	public List<Request> getRequests(Employee employee);
	
	/**
	 * Returns a list of all requests that were made by the given employee that
	 * are either resolved (approved or denied), or unresolved (pending).
	 * 
	 * @param employee		Identifies the employee whose requests will be returned.
	 * @param isResolved	Indicates whether the returned requests will be resolved
	 * 						or unresolved.
	 * @return				A list of requests made by the given employee that have
	 * 						the given status.
	 */
	public List<Request> getRequests(Employee employee, boolean isResolved);
	
	/**
	 * Updates a request that lives in persistent storage with data provided
	 * by the given {@code Request} object.
	 * 
	 * @param request	The new state of an existing request.
	 * @return			A {@code Request} object that has additional information, 
	 * 					or {@code null} if the request could not be updated.
	 */
	public Request updateRequest(Request request);
}
