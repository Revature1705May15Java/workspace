package com.revature.ers.service;

import java.util.ArrayList;

import com.revature.ers.dao.DAO;
import com.revature.ers.dao.DbDAO;
import com.revature.ers.pojos.User;
import com.revature.ers.pojos.RequestState;
import com.revature.ers.util.Mailer;
import com.revature.ers.util.TemporaryLogger;

public class ExpenseReimbursementService {
  
  private DAO dao = new DbDAO();
  private TemporaryLogger logger = new TemporaryLogger();
  
  /**
   * Add a new employee into the system and send them an email.
   * @param email
   * @param firstname
   * @param lastname
   * @param isManager
   * @return a complete Employee object representing the newly created employee, or null if no employee was created
   */
  public User registerEmployee(String email, String firstname, String lastname, boolean isManager) {
    User result = null;
    if (dao.addUser(email, firstname, lastname, isManager)) {
      Mailer mailer = Mailer.getInstance();
      if (mailer.sendMail(email, "An Expense Reimbursement System account was created for you.", 
          "Please login and change your password.\nYour current password is your email address.")) {
        logger.info("An account was created for " + firstname + " " + lastname);
        result = dao.getUser(email);
      }
    }
    return result;
  }
  
  /**
   * Sign in as and retrieve all information for an employee. 
   * @param email
   * @param password
   * @return a complete Employee object (with the requests variable containing all requests created by the employee),
   * or null if there is no employee with the given email and password
   */
  public User login(String email , String password) {
    User result = null;
    if (dao.checkPassword(email, password)) {
      result = dao.getUser(email);
      result.setRequests(dao.getRequestsByRequester(email));
      logger.info(result.getFirstname() + " " + result.getLastname() + " logged in");
    }
    return result;
  }
  
  /**
   * Record that the specified employee is logging out at this date and time.
   * @param e
   * @return true if successful, false otherwise
   */
  public boolean logout(User e) {
    boolean success = false;
    success = dao.updateUserLatestLogout(e);
    logger.info(e.getFirstname() + " " + e.getLastname() + " logged out");
    return success;
  }
  
  public ArrayList<RequestState> getRequestStates() {
    return dao.getAllRequestStates();
  }
  
  public ArrayList<User> getEmployees() {
    ArrayList<User> result = dao.getAllUsers();
    
    return result;
  }
  
}
