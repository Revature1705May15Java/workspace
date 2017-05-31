package com.ex.service;

import java.util.Set;

import com.ex.dao.DAO;
import com.ex.dao.DbDAO;
import com.ex.logging.Logger;
import com.ex.pojos.AccountType;
import com.ex.pojos.User;

public class BankingService {
  
  private static final BankingService INSTANCE = new BankingService();
  
  public static BankingService getInstance() {
    return BankingService.INSTANCE;
  }
  
  private DAO dao;
  private Logger logger;
  
  private User currentUser; // should I be keeping track of the current user in the service layer?
  
  private BankingService() {
    this.dao = new DbDAO();
    this.logger = Logger.getInstance();
  }
  
  /**
   * Create a new bank user and sign in as that user.
   * @param email
   * @param password
   * @param firstname
   * @param lastname
   * @return The newly created user if successful, null otherwise.
   */
  public User registerUser(String email, String password,
      String firstname, String lastname) {
        return null;
  }
  
  /**
   * Sign in as a specific user.
   * @param username
   * @param password
   * @return The user with the given email address if successful, null otherwise.
   */
  public User loginUser(String email, String password) {
    return null;
  }
  
  /**
   * Sign out of the current session.
   */
  public void logoutUser() {
    
  }
  
}
