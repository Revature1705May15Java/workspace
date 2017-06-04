package com.ex.pojos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

public class Account {
  
  int id; // consider making id final if you can always provide it to the constructor
  BigDecimal balance; // switch to using BigDecimal for account balance
  AccountType type;
  LocalDate dateOpened, dateClosed;
  ArrayList<String> accountHolders;
  
  public Account() { super(); }

  public Account(BigDecimal balance, AccountType type, LocalDate dateOpened, LocalDate dateClosed) {
    super();
    this.balance = balance;
    this.type = type;
    this.dateOpened = dateOpened;
    this.dateClosed = dateClosed;
  }

  public Account(int id, BigDecimal balance, AccountType type, LocalDate dateOpened, LocalDate dateClosed) {
    super();
    this.id = id;
    this.balance = balance;
    this.type = type;
    this.dateOpened = dateOpened;
    this.dateClosed = dateClosed;
  }

  public Account(int id, BigDecimal balance, AccountType type, LocalDate dateOpened, LocalDate dateClosed,
      ArrayList<String> accountHolders) {
    super();
    this.id = id;
    this.balance = balance;
    this.type = type;
    this.dateOpened = dateOpened;
    this.dateClosed = dateClosed;
    this.accountHolders = accountHolders;
  }

  
  public int getId() {
    return id;
  }

  
  public void setId(int id) {
    this.id = id;
  }
  

  public BigDecimal getBalance() {
    return balance;
  }
  

  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }
  

  public AccountType getType() {
    return type;
  }
  

  public void setType(AccountType type) {
    this.type = type;
  }
  

  public LocalDate getDateOpened() {
    return dateOpened;
  }
  

  public void setDateOpened(LocalDate dateOpened) {
    this.dateOpened = dateOpened;
  }
  

  public LocalDate getDateClosed() {
    return dateClosed;
  }
  

  public void setDateClosed(LocalDate dateClosed) {
    this.dateClosed = dateClosed;
  }
  

  public ArrayList<String> getAccountHolders() {
    return accountHolders;
  }
  

  public void setAccountHolders(ArrayList<String> accountHolders) {
    this.accountHolders = accountHolders;
  }

  
  @Override
  public String toString() {
    return "Account [id=" + id + ", balance=" + balance + ", type=" + type + ", dateOpened=" + dateOpened
        + ", dateClosed=" + dateClosed + ", accountHolders=" + accountHolders + "]";
  }

  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((accountHolders == null) ? 0 : accountHolders.hashCode());
    result = prime * result + ((balance == null) ? 0 : balance.hashCode());
    result = prime * result + ((dateClosed == null) ? 0 : dateClosed.hashCode());
    result = prime * result + ((dateOpened == null) ? 0 : dateOpened.hashCode());
    result = prime * result + id;
    result = prime * result + ((type == null) ? 0 : type.hashCode());
    return result;
  }

  
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Account other = (Account) obj;
    if (accountHolders == null) {
      if (other.accountHolders != null)
        return false;
    } else if (!accountHolders.equals(other.accountHolders))
      return false;
    if (balance == null) {
      if (other.balance != null)
        return false;
    } else if (!balance.equals(other.balance))
      return false;
    if (dateClosed == null) {
      if (other.dateClosed != null)
        return false;
    } else if (!dateClosed.equals(other.dateClosed))
      return false;
    if (dateOpened == null) {
      if (other.dateOpened != null)
        return false;
    } else if (!dateOpened.equals(other.dateOpened))
      return false;
    if (id != other.id)
      return false;
    if (type == null) {
      if (other.type != null)
        return false;
    } else if (!type.equals(other.type))
      return false;
    return true;
  }

  
  
}
