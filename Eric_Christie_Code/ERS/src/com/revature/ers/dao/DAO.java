package com.revature.ers.dao;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.revature.ers.pojos.User;
import com.revature.ers.pojos.Request;
import com.revature.ers.pojos.RequestState;

/*
 * TODO remove unused DAO methods
 */

public interface DAO {
  
  /**
   * TODO find a better way to securely generate random passwords for new users. (currently it is just a hash of the email address)
   * Insert a record into the user table.
   * @param email
   * @param password The new User's plaintext password, which is stored as a salted hash
   * @param firstname
   * @param lastname
   * @param isManager
   * @return true if successful, false otherwise
   */
  boolean addUser(String email, String firstname, String lastname, boolean isManager);
  
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
   * @return an ArrayList of User objects for all users
   */
  ArrayList<User> getAllUsers();
  
//  /**
//   * Retrieve information for all employees.
//   * @return an ArrayList of User objects for all employees
//   */
//  ArrayList<User> getAllEmployees();
//  
//  /**
//   * Retrieve information for all managers.
//   * @return an ArrayList of User objects for all managers
//   */
//  ArrayList<User> getAllManagers();
  
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
  Request getRequest(int id);
  
  /**
   * Retrieve all requests created by the user with the given email.
   * @param email
   * @return an ArrayList of complete Request objects
   */
  ArrayList<Request> getRequestsByRequester(String email); // might not need this
  
  /**
   * Retrieve all requests resolved by the user with the given email.
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
   * Make the given user a manager. (This should only be accessible to managers.)
   * @param e
   * @return true if successful, false otherwise
   */
  boolean promoteEmployee(User e);
  
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
   * Update the latest logout date and time for the given user to the current date and time.
   * @param e
   * @param latestLogout
   * @return true if successful, false otherwise
   */
  boolean updateUserLatestLogout(User e);
  
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
  boolean updateRequest(Request r, User resolver, RequestState state, String note);
  
}
