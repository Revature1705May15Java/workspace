package com.ex.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import com.ex.dao.DAO;
import com.ex.dao.DbDAO;
import com.ex.logging.Logger;
import com.ex.pojos.Account;
import com.ex.pojos.AccountType;
import com.ex.pojos.User;
import com.ex.util.Mailer;
import com.ex.util.PasswordStorage;
import com.ex.util.PasswordStorage.CannotPerformOperationException;

public class BankingService {
  
  private static final int OPEN_ACCOUNTS_LIMIT = 6;
  private static final int ACCOUNT_HOLDERS_LIMIT = 4;
  
//  private static final BankingService  INSTANCE = new BankingService();
  
  private DAO dao = new DbDAO();
  private Logger logger = Logger.getInstance();

  /**
   * Create a new bank user and sign in as that user.
   * @param email
   * @param password
   * @param firstname
   * @param lastname
   * @return A fully populated User object for the newly created user if successful, 
   * null otherwise.
   */
  public User registerUser(String email, String password, String firstname, String lastname) {
        User result = null;
        try {
          String passwordHash = PasswordStorage.createHash(password);
          if (dao.getUser(email) == null && dao.addUser(email, passwordHash, firstname, lastname)) {
            result = dao.getUser(email);
            result.setPasswordHash(passwordHash);
            result.setAccounts(getCurrentAccounts(result));
            logger.log("registered " + result);
          }
        } catch (Exception e) {
          logger.alert(e.getMessage());
        }
        return result;
  }
  
  /**
   * Send an email containing a verification code.
   * The verification code is currently just the hash of the email address.
   * @param email
   * @return The verification code that was sent in the email, or null if no email was sent.
   */
  public String sendVerificationCode(String email) {
    Mailer mailer = Mailer.getInstance();
    String sentCode = null;
    String code = "123456";//PasswordStorage.createHash(email);
    boolean success = mailer.sendMail(email,
        "Email Verification - Eric Christie's BankingApp",
        "Your verifiation code is: " + code);
    if (success) {
      logger.log("Sent email verification code " + code + " to " + email);
      sentCode = code;
    }
    return sentCode;
  }
  
  /**
   * Check if the email address and verification code are the correct pair.
   * @param email
   * @param inputCode
   * @return true if the verification code is correct for the specified 
   * email address, false otherwise.
   */
  public boolean verifyEmail(String email, String correctCode, String inputCode) {
    boolean result = false;
    result = correctCode.equals(inputCode);
    return result;
  }
  
  /**
   * Sign in as a specific user.
   * @param username
   * @param password
   * @return A fully populated User object for the user with the given email address if successful, 
   * null otherwise.
   */
  public User loginUser(String email, String inputPassword) {
    User result = null;
    try {
      String correctPasswordHash = dao.getUserPasswordHash(email);
      if (PasswordStorage.verifyPassword(inputPassword, correctPasswordHash)) {
        result = dao.getUser(email);
        result.setPasswordHash(correctPasswordHash);
        result.setAccounts(getCurrentAccounts(result));
      }
    } catch (Exception e) {
      logger.alert(e.getMessage());
    }
    return result;
  }
  
  /**
   * Create a new account and link it to a user.
   * @param u
   * @param type
   * @return A fully populated Account object for the newly created account, 
   * or null if no account was created.
   */
  public Account createAccount(User u, AccountType type) {
    Account result = null;
    int numberOfAccounts = getCurrentAccounts(u).size();
    if (numberOfAccounts < OPEN_ACCOUNTS_LIMIT) {
      Integer newAccountId = dao.addAccount(u, type);
      if (newAccountId != null) {
        result = dao.getAccount(newAccountId);
        result.setAccountHolders(dao.getCurrentAccountHolderEmails(result));
        logger.log(u.getEmail() + " created new account " + result);
      }
    } else {
      logger.log("account creation failed - " + u.getEmail() + " already has the maximum number of accounts" );
    }
    return result;
  }
  
  /**
   * Close an account.
   * @param a
   * @return The account that has been closed, or null if no account was closed.
   */
  public Account closeAccount(Account a) {
    Account result = null;
    if (a.getBalance().compareTo(new BigDecimal(0.00)) != 0 && dao.closeAccount(a)) {
      result = a;
      result.setDateClosed(LocalDate.now());
    }
    return result;
  }
  
  /**
   * Link a user to an account.
   * @param a
   * @param username
   * @return An Account object with the newly linked user's email address included in accountHolders,
   * or null if no new user was linked to an account.
   */
  public Account addAccountHolder(Account a, String email) {
    Account result = null;
    int numberOfAccountHolders = dao.getAccountHolderEmails(a).size();
    int numberOfAccounts = getCurrentAccounts(dao.getUser(email)).size();
    if (numberOfAccountHolders < ACCOUNT_HOLDERS_LIMIT && numberOfAccounts < OPEN_ACCOUNTS_LIMIT) {
      if (dao.addAccountHolder(a, email)) {
        result = a;
        result.setAccountHolders(dao.getCurrentAccountHolderEmails(result));
      }
    }
    return result;
  }
  
  /**
   * Unlink a user from a account.
   * @param a
   * @param email
   * @return A new Account object with the user's email address removed from accountHolders,
   * or null if no user was unlinked from the account.
   */
  public Account removeAccountHolder(Account a, String email) {
    Account result = null;
    if (dao.unlinkAccount(email, a)) {
      result = a;
      result.setAccountHolders(dao.getCurrentAccountHolderEmails(result));
    }
    return result;
  }
  
  /**
   * Get all open accounts currently linked to a user.
   * @param u
   * @return A set of fully populated Account objects for all open accounts linked to a user.
   */
  public ArrayList<Account> getCurrentAccounts(User u) {
    ArrayList<Account> accounts = new ArrayList<>();
    accounts = dao.getCurrentAccountsForUser(u.getEmail());
    for (Account a: accounts) {
      a.setAccountHolders(dao.getCurrentAccountHolderEmails(a));
    }
    return accounts;
  }
  
  /**
   * Get all open accounts currently linked to a user.
   * @param email
   * @return A set of fully populated Account objects for all open accounts linked to a user.
   */
  public ArrayList<Account> getCurrentAccounts(String email) {
    ArrayList<Account> accounts = new ArrayList<>();
    accounts = dao.getCurrentAccountsForUser(email);
    for (Account a: accounts) {
      a.setAccountHolders(dao.getCurrentAccountHolderEmails(a));
    }
    return accounts;
  }
  
  
  /**
   * Get all the possible account types.
   * @return The set of all possible AccountTypes.
   */
  public ArrayList<AccountType> getAccountTypes() {
    return dao.getAllAccountTypes();
  }
  
  
  /**
   * Update a user's information.
   * @param old
   * @param email
   * @param phash
   * @param fname
   * @param lname
   * @return The updated information for a user, or null if no changes were made.
   */
  public User updateUser(User old, String email, String password, String fname, String lname) {
    User result = null;
    String phash = null;
    if (password == null) {
      phash = old.getPasswordHash();
    } else {
      try {
        phash = PasswordStorage.createHash(password);
      } catch (CannotPerformOperationException e) {
        logger.alert(e.getMessage());
      }
    }
    if (dao.updateUser(old, email, phash, fname, lname)) {
      result = dao.getUser(old.getId());
      result.setAccounts(getCurrentAccounts(result));
    }
    return result;
  }
  
  /**
   * Deposit money into an account.
   * @param a
   * @param amount
   * @return A new Account object reflecting the balance change.
   */
  public Account deposit(Account a, BigDecimal amount) {
    Account result = null;
    BigDecimal newBalance = a.getBalance().add(amount);
    if(dao.updateBalance(a, newBalance)) {
      result = a;
      result.setBalance(newBalance);
    }
    return result;
  }
  
  /**
   * Withdraw money from an account.
   * @param a
   * @param amount
   * @return A new Account object reflecting the balance change.
   */
  public Account withdraw(Account a, BigDecimal amount) {
    Account result = null;
    BigDecimal newBalance = a.getBalance().subtract(amount);
    if(dao.updateBalance(a, newBalance)) {
      result = a;
      result.setBalance(newBalance);
    }
    return result;
  }
  
  /**
   * Transfer money between two accounts.
   * @param from
   * @param to
   * @param amount
   * @return true if the transfer was successful, false otherwise.
   */
  public boolean transfer(int fromId, int toId, BigDecimal amount) {
    boolean result = false;
    result = dao.performTransfer(fromId, toId, amount);
    return result;
  }

}
