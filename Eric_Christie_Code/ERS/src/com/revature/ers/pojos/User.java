package com.revature.ers.pojos;

import java.time.LocalDateTime;

public class User {

  private int id;
  private String email, firstname, lastname;
  private boolean isManager, emailAlertsOn, setupDone;
  private LocalDateTime lastModified;
  
  public User() { super(); }

  public User(String email, String firstname, String lastname, boolean isManager, boolean emailAlertsOn, boolean setupDone,
      LocalDateTime lastModified) {
    super();
    this.email = email;
    this.firstname = firstname;
    this.lastname = lastname;
    this.isManager = isManager;
    this.emailAlertsOn = emailAlertsOn;
    this.setupDone = setupDone;
    this.lastModified = lastModified;
  }

  public User(int id, String email, String firstname, String lastname, boolean isManager, boolean emailAlertsOn, boolean setupDone,
      LocalDateTime lastModified) {
    super();
    this.id = id;
    this.email = email;
    this.firstname = firstname;
    this.lastname = lastname;
    this.isManager = isManager;
    this.emailAlertsOn = emailAlertsOn;
    this.setupDone = setupDone;
    this.lastModified = lastModified;
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

  public boolean isSetupDone() {
    return setupDone;
  }

  public void setSetupDone(boolean setupDone) {
    this.setupDone = setupDone;
  }

  public LocalDateTime getLatestLogout() {
    return lastModified;
  }

  public void setLatestLogout(LocalDateTime lastModified) {
    this.lastModified = lastModified;
  }

  @Override
  public String toString() {
    return "User [id=" + id + ", email=" + email + ", firstname=" + firstname + ", lastname=" + lastname
        + ", isManager=" + isManager + ", emailAlertsOn=" + emailAlertsOn + ", setupDone=" + setupDone
        + ", lastModified=" + lastModified + "]";
  }

}
