package com.ex.pojos;

import java.util.Set;

public class User {
  
  int id; // consider making id final if you can always provide it to the constructor
  String email, passwordHash, firstname, lastname;
//  Date birthdate, joinDate; // consider trying to use the date-time api
//  String streetAddres, city, state, zipcode;
//  String phone;
  Set<Account> accounts;
  
  public User() { super(); }

  public User(String email, String firstname, String lastname) {
    super();
    this.email = email;
    this.firstname = firstname;
    this.lastname = lastname;
  }

  public User(int id, String email, String firstname, String lastname) {
    super();
    this.id = id;
    this.email = email;
    this.firstname = firstname;
    this.lastname = lastname;
  }

  public User(String email, String passwordHash, String firstname, String lastname) {
    super();
    this.email = email;
    this.passwordHash = passwordHash;
    this.firstname = firstname;
    this.lastname = lastname;
  }

  public User(int id, String email, String passwordHash, String firstname, String lastname) {
    super();
    this.id = id;
    this.email = email;
    this.passwordHash = passwordHash;
    this.firstname = firstname;
    this.lastname = lastname;
  }

  public User(int id, String email, String passwordHash, String firstname, String lastname, Set<Account> accounts) {
    super();
    this.id = id;
    this.email = email;
    this.passwordHash = passwordHash;
    this.firstname = firstname;
    this.lastname = lastname;
    this.accounts = accounts;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPasswordHash() {
    return passwordHash;
  }

  public void setPasswordHash(String passwordHash) {
    this.passwordHash = passwordHash;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public Set<Account> getAccounts() {
    return accounts;
  }

  public void setAccounts(Set<Account> accounts) {
    this.accounts = accounts;
  }

  @Override
  public String toString() {
    return "User [id=" + id + ", email=" + email + ", firstname=" + firstname
        + ", lastname=" + lastname + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((accounts == null) ? 0 : accounts.hashCode());
    result = prime * result + ((email == null) ? 0 : email.hashCode());
    result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
    result = prime * result + id;
    result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
    result = prime * result + ((passwordHash == null) ? 0 : passwordHash.hashCode());
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
    User other = (User) obj;
    if (accounts == null) {
      if (other.accounts != null)
        return false;
    } else if (!accounts.equals(other.accounts))
      return false;
    if (email == null) {
      if (other.email != null)
        return false;
    } else if (!email.equals(other.email))
      return false;
    if (firstname == null) {
      if (other.firstname != null)
        return false;
    } else if (!firstname.equals(other.firstname))
      return false;
    if (id != other.id)
      return false;
    if (lastname == null) {
      if (other.lastname != null)
        return false;
    } else if (!lastname.equals(other.lastname))
      return false;
    if (passwordHash == null) {
      if (other.passwordHash != null)
        return false;
    } else if (!passwordHash.equals(other.passwordHash))
      return false;
    return true;
  }

}
