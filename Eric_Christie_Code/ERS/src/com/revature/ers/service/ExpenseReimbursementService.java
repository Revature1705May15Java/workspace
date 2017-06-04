package com.revature.ers.service;

import com.revature.ers.dao.DAO;
import com.revature.ers.dao.DbDAO;
import com.revature.ers.pojos.Employee;
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
   * @return true if successful, false otherwise
   */
  public boolean registerEmployee(String email, String firstname, String lastname, boolean isManager) {
    boolean success = false;
    if (dao.addEmployee(email, firstname, lastname, isManager)) {
      Mailer mailer = Mailer.getInstance();
      success = mailer.sendMail(email, "An Expense Reimbursement System account was created for you.", 
          "Please login and change your password.\nYour current password is your email address.");
    }
    return success;
  }
  
  /**
   * Sign in as and retrieve all information for an employee. 
   * @param email
   * @param password
   * @return a complete Employee object (with the requests variable containing all requests created by the employee)
   */
  public Employee login(String email , String password) {
    Employee result = null;
    if (dao.checkPassword(email, password)) {
      result = dao.getEmployee(email);
      result.setRequests(dao.getRequestsByRequester(email));
      logger.info(result.getFirstname() + " " + result.getLastname() + " logged in.");
    }
    return result;
  }
  
  /**
   * Record that the specified employee is logging out at this date and time.
   * @param e
   * @return true if successful, false otherwise
   */
  public boolean logout(Employee e) {
    boolean success = false;
    success = dao.updateEmployeeLatestLogout(e);
    logger.info(e.getFirstname() + " " + e.getLastname() + " is logging out.");
    return success;
  }
  
}
