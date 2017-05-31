package com.ex.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;

import com.ex.dao.DAO;
import com.ex.dao.DbDAO;
import com.ex.logging.Logger;
import com.ex.pojos.Account;
import com.ex.pojos.AccountType;
import com.ex.pojos.User;
import com.ex.util.Mailer;
import com.ex.util.PasswordStorage;
import com.ex.util.PasswordStorage.CannotPerformOperationException;
import com.ex.util.PasswordStorage.InvalidHashException;

public class Service {
  
  private DAO dao = new DbDAO();
  private Logger logger = Logger.getInstance();
  private Mailer mailer = Mailer.getInstance();

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
          if (dao.addUser(email, passwordHash, firstname, lastname)) {
            result = dao.getUser(email);
            result.setPasswordHash(passwordHash);
            result.setAccounts(getCurrentAccounts(result));
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
    String sentCode = null;
    try {
      String code = PasswordStorage.createHash(email);
      boolean success = mailer.sendMail(email,
          "Email Verification - Eric Christie's BankingApp",
          "Your verifiation code is: " + code);
      if (success) {
        logger.log("Sent email verification code " + code + " to " + email);
        sentCode = code;
      }
    } catch (CannotPerformOperationException e) {
      logger.alert(e.getMessage());
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
  public boolean verifyEmail(String email, String inputCode) {
    boolean result = false;
    try {
      result = PasswordStorage.verifyPassword(inputCode, PasswordStorage.createHash(email));
    } catch (CannotPerformOperationException | InvalidHashException e) {
      logger.alert(e.getMessage());
    }
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
    Integer newAccountId = dao.addAccount(u, type);
    if (newAccountId != null) {
      result = dao.getAccount(newAccountId);
      result.setAccountHolders(dao.getCurrentAccountHolderEmails(result));
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
    if (dao.addAccountHolder(a, email)) {
      result = a;
      result.setAccountHolders(dao.getCurrentAccountHolderEmails(result));
    }
    return result;
  }
  
  /**
   * Unlink a user from a account.
   * @param a
   * @param u
   * @return A new Account object with the user's email address removed from accountHolders,
   * or null if no user was unlinked from the account.
   */
  public Account removeAccountHolder(Account a, User u) {
    Account result = null;
    if (dao.unlinkAccount(u, a)) {
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
  public HashSet<Account> getCurrentAccounts(User u) {
    HashSet<Account> accounts = new HashSet<>();
    accounts = dao.getCurrentAccountsForUser(u.getEmail());
    for (Account a: accounts) {
      a.setAccountHolders(dao.getAccountHolderEmails(a));
    }
    return accounts;
  }
  
  
  /**
   * Get all the possible account types.
   * @return The set of all possible AccountTypes.
   */
  public HashSet<AccountType> getAccountTypes() {
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
  public User updateUser(User old, String email, String phash, String fname, String lname) {
    User result = null;
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
  public boolean transfer(Account from, Account to, BigDecimal amount) {
    boolean result = false;
    result = dao.performTransfer(from, to, amount);
    return result;
  }

}
