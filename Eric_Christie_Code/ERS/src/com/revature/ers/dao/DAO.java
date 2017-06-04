package com.revature.ers.dao;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.revature.ers.pojos.Employee;
import com.revature.ers.pojos.Request;
import com.revature.ers.pojos.RequestState;

/*
 * TODO remove unused DAO methods
 */

public interface DAO {
  
  /**
   * TODO find a better way to securely generate random passwords for new users. (currently it is just a hash of the email address)
   * Insert a record into the employee table.
   * @param email
   * @param password The new Employee's plaintext password, which is stored as a salted hash
   * @param firstname
   * @param lastname
   * @param isManager
   * @return true if successful, false otherwise
   */
  boolean addEmployee(String email, String firstname, String lastname, boolean isManager);
  
  /**
   * Insert a record into the request table.
   * @param requester
   * @param amount
   * @param purpose
   * @return the id for the new request, or null if no request was added
   */
  Integer addRequest(Employee requester, BigDecimal amount, String purpose);
  
  /**
   * Check if the given password is the correct password for the employee with the given email.
   * @param email
   * @param password
   * @return true if password is correct, false otherwise
   */
  boolean checkPassword(String email, String password);
  
  /**
   * Retrieve information for all employees.
   * @return an ArrayList of Employee objects for all employees
   */
  ArrayList<Employee> getAllEmployees();
  
  /**
   * Retrieve information for all requests.
   * @return an ArrayList of Request objects for all requests
   */
  ArrayList<Request> getAllRequests();
  
  /**
   * Retrieve all possible request states.
   * @return an ArrayList containing all possible RequestState objects
   */
  ArrayList<RequestState> getAllRequestStates();
  
  /**
   * Retrieve the employee with the given id.
   * @param id
   * @return an Employee object with a null requests variable, or null if no such employee exists
   */
  Employee getEmployee(int id);
  
  /**
   * Retrieve the employee with the given email.
   * @param id
   * @return an Employee object with a null requests variable, or null if no such employee exists
   */
  Employee getEmployee(String email);
  
  /**
   * Retrieve the request with the given id.
   * @param id
   * @return a complete Request object (contains all available information from the database), or null if no such request exists
   */
  Request getRequest(int id);
  
  /**
   * Retrieve all requests created by the employee with the given email.
   * @param email
   * @return an ArrayList of complete Request objects
   */
  ArrayList<Request> getRequestsByRequester(String email); // might not need this
  
  /**
   * Retrieve all requests resolved by the employee with the given email.
   * @param email
   * @return an ArrayList of complete Request objects
   */
  ArrayList<Request> getRequestsByResolver(String email); // might not need this
  
  /**
   * Retrieve all requests in the given state.
   * @param state
   * @return an ArrayList of complete Request objects
   */
  ArrayList<Request> getRequestsByState(RequestState state); // might not need this
  
  /**
   * Make the given employee a manager. (This should only be accessible to managers.)
   * @param e
   * @return true if successful, false otherwise
   */
  boolean promoteEmployee(Employee e);
  
  /**
   * Update the information for the given employee.
   * @param old
   * @param email
   * @param firstname
   * @param lastname
   * @param emailAlertsOn
   * @return true if successful, false otherwise
   */
  boolean updateEmployee(Employee old, String email, String firstname, String lastname, boolean emailAlertsOn);
  
  /**
   * Update the latest logout date and time for the given employee to the current date and time.
   * @param e
   * @param latestLogout
   * @return true if successful, false otherwise
   */
  boolean updateEmployeeLatestLogout(Employee e);
  
  /**
   * Change the password for the given employee.
   * @param e
   * @param password
   * @return true if successful, false otherwise
   */
  boolean updateEmployeePassword(Employee e, String password);
  
  /**
   * Update the given request to a resolved state.
   * @param r
   * @param resolver
   * @param approved Whether the request is approved or denied
   * @param note
   * @return true if successful, false otherwise
   */
  boolean updateRequest(Request r, Employee resolver, RequestState state, String note);
  
}
