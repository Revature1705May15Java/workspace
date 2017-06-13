package com.ex.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PERSON")
public class Person {

  @Id
  @Column(name="P_ID")
  @SequenceGenerator(name="PERSONID_SEQ", sequenceName="PERSONID_SEQ")
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PERSONID_SEQ")
  private int id;
  // how do we set the sequence increment value
  
  @Column(name="FIRSTNAME")
  private String firstname;
  
  @Column(name="LASTNAME")
  private String lastname;

  public Person() { super(); }

  public Person(String firstname, String lastname) {
    super();
    this.firstname = firstname;
    this.lastname = lastname;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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

  @Override
  public String toString() {
    return "Person [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + "]";
  }

}
