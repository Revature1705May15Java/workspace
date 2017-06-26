package com.ex.ers.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ERS_USER")
public class User implements Serializable {
  
  private static final long serialVersionUID = 3133393329796092309L;
  
  @Id
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="userSeq")
  @SequenceGenerator(allocationSize=1, name="userSeq", sequenceName="USER_SEQ")
  @Column(name="USER_ID")
  private int id;
  
  @Column(name="USER_EMAIL")
  private String email;
  
  @Column(name="USER_FIRSTNAME")
  private String firstname;
  
  @Column(name="USER_LASTNAME")
  private String lastname;
  
  @Column(name="USER_ROLE")
  private Boolean isManager;
  
  @OneToMany(mappedBy="requester", fetch=FetchType.LAZY)
  private List<ReimbursementRequest> requests;

  public User() {}

  public User(String email, String firstname, String lastname, Boolean isManager) {
    super();
    this.email = email;
    this.firstname = firstname;
    this.lastname = lastname;
    this.isManager = isManager;
  }

  public User(int id, String email, String firstname, String lastname, Boolean isManager) {
    super();
    this.id = id;
    this.email = email;
    this.firstname = firstname;
    this.lastname = lastname;
    this.isManager = isManager;
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

  public Boolean getIsManager() {
    return isManager;
  }

  public void setIsManager(Boolean isManager) {
    this.isManager = isManager;
  }

  public List<ReimbursementRequest> getRequests() {
    return requests;
  }

  public void setRequests(List<ReimbursementRequest> requests) {
    this.requests = requests;
  }

  @Override
  public String toString() {
    return "User [id=" + id + ", email=" + email + ", firstname=" + firstname + ", lastname=" + lastname
        + ", isManager=" + isManager + ", requests=" + requests + "]";
  }
  
}
