package com.revature.ers.pojos;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class User {

  private int id;
  private String email, firstname, lastname;
  private boolean isManager, emailAlertsOn;
  private LocalDateTime latestLogout;
  private ArrayList<Request> requests;
  
  public User() { super(); }

  public User(String email, String firstname, String lastname, boolean isManager, boolean emailAlertsOn,
      LocalDateTime latestLogout) {
    super();
    this.email = email;
    this.firstname = firstname;
    this.lastname = lastname;
    this.isManager = isManager;
    this.emailAlertsOn = emailAlertsOn;
    this.latestLogout = latestLogout;
  }

  public User(int id, String email, String firstname, String lastname, boolean isManager, boolean emailAlertsOn,
      LocalDateTime latestLogout) {
    super();
    this.id = id;
    this.email = email;
    this.firstname = firstname;
    this.lastname = lastname;
    this.isManager = isManager;
    this.emailAlertsOn = emailAlertsOn;
    this.latestLogout = latestLogout;
  }

  public User(int id, String email, String firstname, String lastname, boolean isManager, boolean emailAlertsOn,
      LocalDateTime latestLogout, ArrayList<Request> requests) {
    super();
    this.id = id;
    this.email = email;
    this.firstname = firstname;
    this.lastname = lastname;
    this.isManager = isManager;
    this.emailAlertsOn = emailAlertsOn;
    this.latestLogout = latestLogout;
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

  public LocalDateTime getLatestLogout() {
    return latestLogout;
  }

  public void setLatestLogout(LocalDateTime latestLogout) {
    this.latestLogout = latestLogout;
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
        + ", isManager=" + isManager + ", emailAlertsOn=" + emailAlertsOn + ", latestLogout=" + latestLogout
        + ", requests=" + requests + "]";
  }

}
