package com.revature.ers.dao;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.revature.ers.pojos.Request;
import com.revature.ers.pojos.RequestState;
import com.revature.ers.pojos.User;

/*
 * TODO remove unused DAO methods
 */

public interface DAO {
  
  /**
   * Insert a record into the user table.
   * @param email
   * @param password The new User's plaintext password, which is stored as a salted hash
   * @param firstname
   * @param lastname
   * @param isManager
   * @return true if successful, false otherwise
   */
  boolean addUser(String email, String temporaryPassword, String firstname, String lastname, boolean isManager);
  
  /**
   * Insert a record into the request table.
   * @param requester
   * @param amount
   * @param purpose
   * @return the id for the new request, or null if no request was added
   */
  Integer addRequest(User requester, BigDecimal amount, String purpose);
  
  /**
   * Check if the given password is the correct password for the user with the given email.
   * @param email
   * @param password
   * @return true if password is correct, false otherwise
   */
  boolean checkPassword(String email, String password);
  
  /**
   * Retrieve information for all employees and managers.
   * @return an ArrayList of User objects for all users, in descending order by lastModified timestamp
   */
  ArrayList<User> getAllUsers();
  
  /**
   * Retrieve information for all employees.
   * @return an ArrayList of employee User objects, in descending order by lastModified timestamp
   */
  ArrayList<User> getAllEmployees();
  
  /**
   * Retrieve information for all managers.
   * @return an ArrayList of manager User objects, in descending order by lastModified timestamp
   */
  ArrayList<User> getAllManagers();
  
//  /**
//   * Retrieve information for all requests.
//   * @return an ArrayList of Request objects for all requests, in descending order by id 
//   */
//  ArrayList<Request> getAllRequests();
  
  /**
   * Retrieve all possible request states.
   * @return an ArrayList containing all possible RequestState objects
   */
  ArrayList<RequestState> getAllRequestStates();
  
  /**
   * Retrieve the user with the given id.
   * @param id
   * @return an User object with a null requests variable, or null if no such user exists
   */
  User getUser(int id);
  
  /**
   * Retrieve the user with the given email.
   * @param id
   * @return an User object with a null requests variable, or null if no such user exists
   */
  User getUser(String email);
  
  /**
   * Retrieve the request with the given id.
   * @param id
   * @return a complete Request object (contains all available information from the database), or null if no such request exists
   */
  Request getUnresolvedRequest(Integer id);
  
  /**
   * Retrieve all unresolved requests.
   * @param email
   * @return an ArrayList of complete Request objects, in descending order by id
   */
  ArrayList<Request> getUnresolvedRequests();
  
  /**
   * Retrieve all unresolved requests created by the user with the given email.
   * @param email
   * @return an ArrayList of complete Request objects, in descending order by id
   */
  ArrayList<Request> getUnresolvedRequestsByRequester(String email);
  
  /**
   * Retrieve the request with the given id.
   * @param id
   * @return a complete Request object (contains all available information from the database), or null if no such request exists
   */
  Request getResolvedRequest(Integer id);
  
  /**
   * Retrieve all resolved requests.
   * @param email
   * @return an ArrayList of complete Request objects, in descending order by id
   */
  ArrayList<Request> getResolvedRequests();
  
  /**
   * Retrieve all resolved requests created by the user with the given email.
   * @param email
   * @return an ArrayList of complete Request objects, in descending order by id
   */
  ArrayList<Request> getResolvedRequestsByRequester(String email);
  
//  /**
//   * Retrieve all requests in the given state.
//   * @param stateName
//   * @return an ArrayList of complete Request objects, in descending order by request/resolve date
//   */
//  ArrayList<Request> getRequestsByState(String stateName);
//  
//  /**
//   * Retrieve all requests created by the user with the given email that are in the given state
//   * @param email
//   * @return an ArrayList of complete Request objects, in descending order by request/resolve date
//   */
//  ArrayList<Request> getRequestsByRequesterAndState(String email, String stateName);
//  
//  /**
//   * Make the given user a manager. (This should only be accessible to managers.)
//   * @param e
//   * @return true if successful, false otherwise
//   */
//  boolean promoteEmployee(User e);
  
  /**
   * Update the information for the given user.
   * @param old
   * @param email
   * @param firstname
   * @param lastname
   * @param emailAlertsOn
   * @return true if successful, false otherwise
   */
  boolean updateUser(User old, String email, String firstname, String lastname, boolean emailAlertsOn);
  
  /**
   * Change the password for the given user.
   * @param e
   * @param password
   * @return true if successful, false otherwise
   */
  boolean updateUserPassword(User e, String password);
  
  /**
   * Update the given request to a resolved state.
   * @param r
   * @param resolver
   * @param approved Whether the request is approved or denied
   * @param note
   * @return true if successful, false otherwise
   */
  boolean updateRequest(int requestId, User resolver, RequestState state, String note);
  
//  /**
//   * Get employee information that has been added or updated since the specified time.
//   * @param previous
//   * @return an ArrayList of Employee objects
//   */
//  ArrayList<User> getEmployeeUpdatesSince(LocalDateTime previous);
//  
//  /**
//   * Get request information that has been added or updated since the specified time.
//   * @param previous
//   * @return an ArrayList of Request objects
//   */
//  ArrayList<Request> getRequestUpdatesSince(LocalDateTime previous);
  
}
