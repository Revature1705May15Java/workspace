package com.revature.ers.pojos;

import java.util.ArrayList;

public class Employee {

  private int id;
  private String email, firstname, lastname;
  private boolean isManager, emailAlertsOn;
  private ArrayList<Request> requests;
  
  public Employee() { super(); }

  public Employee(String email, String firstname, String lastname, boolean isManager, boolean emailAlertsOn) {
    super();
    this.email = email;
    this.firstname = firstname;
    this.lastname = lastname;
    this.isManager = isManager;
    this.emailAlertsOn = emailAlertsOn;
  }

  public Employee(int id, String email, String firstname, String lastname, boolean isManager, boolean emailAlertsOn) {
    super();
    this.id = id;
    this.email = email;
    this.firstname = firstname;
    this.lastname = lastname;
    this.isManager = isManager;
    this.emailAlertsOn = emailAlertsOn;
  }

  public Employee(int id, String email, String firstname, String lastname, boolean isManager, boolean emailAlertsOn,
      ArrayList<Request> requests) {
    super();
    this.id = id;
    this.email = email;
    this.firstname = firstname;
    this.lastname = lastname;
    this.isManager = isManager;
    this.emailAlertsOn = emailAlertsOn;
    this.requests = requests;
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

  public boolean isManager() {
    return isManager;
  }

  public void setAsManager(boolean isManager) {
    this.isManager = isManager;
  }

  public boolean isEmailAlertsOn() {
    return emailAlertsOn;
  }

  public void setEmailAlertsOn(boolean emailAlertsOn) {
    this.emailAlertsOn = emailAlertsOn;
  }

  public ArrayList<Request> getRequests() {
    return requests;
  }

  public void setRequests(ArrayList<Request> requests) {
    this.requests = requests;
  }

  @Override
  public String toString() {
    return "Employee [id=" + id + ", email=" + email + ", firstname=" + firstname + ", lastname=" + lastname
        + ", isManager=" + isManager + ", emailAlertsOn=" + emailAlertsOn + ", requests=" + requests + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((email == null) ? 0 : email.hashCode());
    result = prime * result + (emailAlertsOn ? 1231 : 1237);
    result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
    result = prime * result + id;
    result = prime * result + (isManager ? 1231 : 1237);
    result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
    result = prime * result + ((requests == null) ? 0 : requests.hashCode());
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
    Employee other = (Employee) obj;
    if (email == null) {
      if (other.email != null)
        return false;
    } else if (!email.equals(other.email))
      return false;
    if (emailAlertsOn != other.emailAlertsOn)
      return false;
    if (firstname == null) {
      if (other.firstname != null)
        return false;
    } else if (!firstname.equals(other.firstname))
      return false;
    if (id != other.id)
      return false;
    if (isManager != other.isManager)
      return false;
    if (lastname == null) {
      if (other.lastname != null)
        return false;
    } else if (!lastname.equals(other.lastname))
      return false;
    if (requests == null) {
      if (other.requests != null)
        return false;
    } else if (!requests.equals(other.requests))
      return false;
    return true;
  }

}
