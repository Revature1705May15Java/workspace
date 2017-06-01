package com.ex.dao;

import java.math.BigDecimal;
import java.util.HashSet;

import com.ex.pojos.Account;
import com.ex.pojos.AccountType;
import com.ex.pojos.User;

/*
 * This interface does not provide any way to retrieve a user's passwordHash from the database.
 * It is only possible to compare a given String with the passwordHash in the database for a user.
 */

public interface DAO {
  
  /**
   * Add a record to the bankUser table.
   * @param email
   * @param passwordHash The encrypted salted hash of the user's passwordHash.
   * @param firstname
   * @param lastname
   * @return true if successful, false otherwise.
   */
  public boolean addUser(String email, String passwordHash, String firstname, String lastname);
  
  /**
   * Add a record to the account table and the accountHolder table. A new account cannot be created
   * without specifying an accountHolder. A successful operation will affect 2 rows.
   * @param u
   * @param type
   * @return The id of the newly created account, or null if no account was created.
   */
  public Integer addAccount(User u, AccountType type);
  
  /**
   * Avoid using this method.
   * Add a record to the accountHolder table.
   * @param a
   * @param accountHolderId
   * @return true if successful, false otherwise.
   */
  public boolean addAccountHolder(Account a, int accountHolderId);
  
  /**
   * Add an accountHolder for an account.
   * @param a
   * @param accountHolderEmail
   * @return true if successful, false otherwise.
   */
  public boolean addAccountHolder(Account a, String accountHolderEmail);
  
  /**
   * Avoid using this method.
   * Retrieve every user's information. This does not retrieve passwords or accounts.
   * @return A set containing all users.
   */
  public HashSet<User> getAllUsers();
  
  /**
   * Avoid using this method.
   * Retrieve all accounts. This does not retrieve the account holders for an account.
   * @return A set containing all accounts.
   */
  public HashSet<Account> getAllAccounts();
  
  /**
   * Retrieve all account types.
   * @return A set containing all the available AccountTypes.
   */
  public HashSet<AccountType> getAllAccountTypes();
  
  /**
   * Retrieve a user's information. This does not retrieve a user's passwordHash.
   * @param id
   * @return The user with the specified id, or null if no such user exists.
   */
  public User getUser(int id);
  
  /**
   * Retrieve a user's information. This does not retrieve a user's passwordHash.
   * @param username
   * @return The user with the specified email, or null if no such user exists
   */
  public User getUser(String email);
  
  /**
   * Retrieve a user's information. This does not retrieve a user's passwordHash.
   * @param email
   * @param passwordHash
   * @return The user with the specified email, or null if no such user exists 
   * or the email/passwordHash combination was incorrect.
   */
  public User getUser(String email, String passwordHash);
  
  /**
   * Retrieve a user's passwordHash.
   * @param email
   * @return The passwordHash field for a user, or null if no such user exists.
   */
  public String getUserPasswordHash(String email);
  
  /**
   * Retrieve an account.
   * @param id
   * @return A single Account object for the account with the given id, 
   * or null if no such table exists.
   */
  public Account getAccount(int id);
  
  /**
   * Avoid using this method.
   * Retrieve the accounts held by a user.
   * @param username
   * @return The set of accounts that have the specified user as an account holder.
   */
  public HashSet<Account> getAccountsForUser(int id);
  
  /**
   * Retrieve the any accounts that were ever linked to a user.
   * @param email
   * @return The set of accounts that have the specified user as an account holder.
   */
  public HashSet<Account> getAccountsForUser(String email);
  
  /**
   * Avoid using this method.
   * Retrieve the open accounts held by a user.
   * @param username
   * @return The set of accounts that have the specified user as an account holder.
   */
  public HashSet<Account> getCurrentAccountsForUser(int id);
  
  /**
   * Retrieve the open accounts liked to a user.
   * @param email
   * @return The set of accounts that have the specified user as an account holder.
   */
  public HashSet<Account> getCurrentAccountsForUser(String email);
  
  /**
   * Retrieve the account holders for an account.
   * @param a
   * @return The set of email addresses for all the users that are holders of an account.
   */
  public HashSet<String> getAccountHolderEmails(Account a);
  
  /**
   * Retrieve the current account holders for an account.
   * @param a
   * @return The set of email addresses for all the users that are current holders of an account.
   */
  public HashSet<String> getCurrentAccountHolderEmails(Account a);
  
  /**
   * Update the information for a user.
   * @param old
   * @param email
   * @param passwordHash
   * @param firstname
   * @param lastname
   * @return true if successful, false otherwise.
   */
  public boolean updateUser(User old, String email, String passwordHash,
      String firstname, String lastname);
  
  /**
   * Update the balance for an account.
   * @param a
   * @param balance
   * @return true if successful, false otherwise.
   */
  public boolean updateBalance(Account a, BigDecimal balance);
  
  /**
   * Perform a transfer between two accounts.
   * @param fromId
   * @param toId
   * @param amount
   * @return true if successful, false otherwise.
   */
  public boolean performTransfer(int fromId, int toID, BigDecimal amount);
  
  /**
   * Cancel a user's connection to an account. Sets the unlink date for an account holder 
   * to the current date.
   * This action should only be possible if the user is not the only account holder for the account.
   * @param email
   * @param a
   * @return true if successful, false otherwise.
   */
  public boolean unlinkAccount(String email, Account a);
  
  /**
   * Set the close date of an account to the current date.
   * @param a The account being closed.
   * @return true if successful, false otherwise.
   */
  public boolean closeAccount(Account a);

  /**
   * Compare a String with the stored passwordHash for a user.
   * @param email
   * @param passwordHash
   * @return true if the provided String matches the stored passwordHash, false otherwise.
   */
  public boolean checkPasswordHash(String email, String passwordHash);
  
}