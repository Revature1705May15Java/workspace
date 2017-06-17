package com.revature.ers.service;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.apache.commons.text.RandomStringGenerator;

import com.revature.ers.dao.DAO;
import com.revature.ers.dao.DbDAO;
import com.revature.ers.pojos.Request;
import com.revature.ers.pojos.RequestState;
import com.revature.ers.pojos.User;
import com.revature.ers.util.Mailer;
import com.revature.ers.util.TempLogger;
import com.revature.ers.util.TemporaryToken;

public class ERService {
  
  /*
   * TODO figure out a better way to use the RequestState objects and the getRequestStates() method
   */
  
  private DAO dao = new DbDAO();
  private TempLogger logger = new TempLogger();
  
  /**
   * Add a new employee into the system and send them an email.
   * @param email
   * @param firstname
   * @param lastname
   * @param isManager
   * @return a User object representing the newly created user, or null if no user was created
   */
  public User registerUser(String email, String firstname, String lastname, boolean isManager) {
    User result = null;
    RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange('0', 'z').build();
    String tempPassword = generator.generate(20);
    if (dao.addUser(email, tempPassword, firstname, lastname, isManager)) {
      Mailer mailer = Mailer.getInstance();
      if (mailer.sendMail(email, "An Expense Reimbursement System account was created for you.", 
          "Please login and change your password.\nYour current password is " + tempPassword + ".")) {
        logger.info("An account was created for " + firstname + " " + lastname + " with the temporary password " + tempPassword);
        result = dao.getUser(email);
      }
    }
    return result;
  }
  
  /**
   * Sign in as and retrieve all information for a user. 
   * @param email
   * @param password
   * @return a User object or null if there is no user with the given email and password
   */
  public User login(String email , String password) {
    User result = null;
    if (dao.checkPassword(email, password)) {
      result = dao.getUser(email);
      logger.info(result.getFirstname() + " " + result.getLastname() + " logged in");
    }
    return result;
  }
  
//  /**
//   * Record that the specified user is logging out at this date and time.
//   * @param e
//   * @return true if successful, false otherwise
//   */
//  public boolean logout(User u) {
//    boolean success = false;
//    success = dao.updateUserLatestLogout(u);
//    logger.info(u.getFirstname() + " " + u.getLastname() + " logged out");
//    return success;
//  }
  
  /**
   * Change the specified user's password to the given password.
   * @param u
   * @param password
   * @return true if successful, false otherwise
   */
  public boolean changePassword(User u, String password) {
    boolean success = false;
    success = dao.updateUserPassword(u, password);
    logger.info(u.getFirstname() + " " + u.getLastname() + " changed their password");
    return success;
  }
  
  /**
   * Retrieve the information for the user with the given id.
   * @param id
   * @return a User object for the user with the given id, or null if no such user exists
   */
  public User getUserById(int id) {
    User result = null;
    result = dao.getUser(id);
    return result;
  }
  
  /**
   * Send a password reset token to the given email address if a user with that address exists.
   * @param email
   * @return the password reset token that was generated and sent, or null if no token was sent
   */
  public TemporaryToken sendPasswordResetToken(String email) {
    TemporaryToken token = null;
    if (dao.getUser(email) != null) {
      TemporaryToken generatedToken = new TemporaryToken(email);
      Mailer mailer = Mailer.getInstance();
      if (mailer.sendMail(email, "Expense Reimbursement System - Password Recovery Token",
          "Your password recovery token is " + generatedToken.getToken() + ". This token will expire at "
           + generatedToken.getExpirationTimestamp().format(DateTimeFormatter.RFC_1123_DATE_TIME) + ".")) {
        logger.info("Sent password recovery token to " + email);
        token = generatedToken;
      }
    }
    return token;
  }
  
  /**
   * Set the password for the user with the given email address to the hash of the given password. (provided some checks are passed)
   * @param email
   * @param password
   * @return true if successful, false otherwise
   */
  public boolean resetPassword(TemporaryToken token, String inputToken, String email, String newPassword) {
    boolean success = false;
    if (token.verify(inputToken, email)) {
      success = changePassword(dao.getUser(email), newPassword);
    }
    return success;
  }
  
  /**
   * Retrieve all requests made by the given employee.
   * @param e
   * @return an ArrayList of Request objects
   */
  public ArrayList<Request> getRequestsByEmployee(User e) {
    return dao.getRequestsByRequester(e.getEmail());
  }
  
  /**
   * Retrieve all pending requests made by the given employee.
   * @param e
   * @return an ArrayList of Request objects
   */
  public ArrayList<Request> getPendingRequestsForEmployee(User e) {
    return dao.getRequestsByRequesterAndState(e.getEmail(), "pending");
  }
  
  /**
   * Retrieve all resolved requests made by the given employee.
   * @param e
   * @return an ArrayList of Request objects
   */
  public ArrayList<Request> getResolvedRequestsForEmployee(User e) {
    ArrayList<Request> result = dao.getRequestsByRequesterAndState(e.getEmail(), "approved");
    result.addAll(dao.getRequestsByRequesterAndState(e.getEmail(), "denied"));
    return result;
  }
  
  /**
   * Retrieve all requests from the database.
   * @return an ArrayList containing all the Request objects
   */
  public ArrayList<Request> getRequests() {
    return dao.getAllRequests();
  }
  
  /**
   * Retrieve all pending requests.
   * @return an ArrayList of pending Request objects
   */
  public ArrayList<Request> getPendingRequests() {
    return dao.getRequestsByState("pending");
  }
  
  /**
   * Retrieve all resolved requests.
   * @return an ArrayList of resolved Request objects
   */
  public ArrayList<Request> getResolvedRequests() {
    ArrayList<Request> result = dao.getRequestsByState("approved");
    result.addAll(dao.getRequestsByState("denied"));
    return result;
  }
  
  /**
   * Create a new reimbursement request.
   * @param requester
   * @param amount
   * @param purpose
   * @return a Request object representing the new request, or null if nothing was created
   */
  public Request createRequest(User requester, BigDecimal amount, String purpose) {
    Request result = null;
    Integer id = dao.addRequest(requester, amount, purpose);
    if (id != null) {
      result = dao.getRequest(id);
    }
    return result;
  }
  
  /**
   * Resolve a request by either approving or denying it.
   * @param r
   * @param resolver
   * @param approved
   * @param note
   * @return the updated Request object, or null if nothing was changed
   */
  public Request resolveRequest(Request r, User resolver, Boolean approved, String note) {
    Request result = null;
    RequestState state = approved ? new RequestState(2, "approved") : new RequestState(3, "denied");
    if (dao.updateRequest(r, resolver, state, note)) {
      result = dao.getRequest(r.getId());
      if (dao.getUser(result.getRequesterId()).isEmailAlertsOn()) {
        Mailer mailer = Mailer.getInstance();
        mailer.sendMail(dao.getUser(r.getRequesterId()).getEmail(), "One of your reimbursement requests has been resolved",
            "Your request for " + r.getAmount() + " was " + (approved ? "approved" : "denied") + ". Login to your account to view the request.");
      }
      
    }
    return result;
  }
  
  /**
   * Retrieve all the possible states a request can be in.
   * @return an ArrayList of the different RequestState objects
   */
  public ArrayList<RequestState> getRequestStates() {
    return dao.getAllRequestStates();
  }
  
  /**
   * Retrieve information for all registered users.
   * @return an ArrayList of User objects
   */
  public ArrayList<User> getUsers() {
    return dao.getAllUsers();
  }
  
  /**
   * Retrieve information for all registered employees.
   * @return an ArrayList of all employees
   */
  public ArrayList<User> getEmployees() {
    return dao.getAllEmployees();
  }
  
  /**
   * Retrieve information for all registered managers.
   * @return an ArrayList of all managers
   */
  public ArrayList<User> getManagers() {
    return dao.getAllManagers();
  }
  
  /**
   * Update the account information for the given user. Input null values for any fields that should be left unchanged.
   * @param old the User object with the user's current information
   * @param email new email to set for the user, or null if email should not be changed
   * @param password new password to set for the user, or null if password should not be changed
   * @param firstname new first name to set for the user, or null if first name should not be changed
   * @param lastname new last name to set for the user, or null if last name should not be changed
   * @param emailAlertsOn new email alerts setting to set for the user, or null if it should not be changed
   * @return a User object representing the user's information after the operation, whether the update succeeds or fails
   */
  public User updateUserInformation(User old, String email, String password, String firstname, String lastname, Boolean emailAlertsOn) {
    email = (email != null) ? email : old.getEmail();
    firstname = (firstname != null) ? firstname : old.getFirstname();
    lastname = (lastname != null) ? lastname : old.getLastname();
    emailAlertsOn = (emailAlertsOn != null) ? emailAlertsOn : old.isEmailAlertsOn();
    if (dao.updateUser(old, email, firstname, lastname, emailAlertsOn)) {
      if (password != null) {
        dao.updateUserPassword(old, password);
      }
    }
    logger.info(old + " changed their account information");
    return dao.getUser(old.getId());
  }
  
}
