package com.ex.pojos;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Person {
  private String name;
  private LocalDateTime birthdate;
  private BigDecimal income;
  private ArrayList<String> interests;

  public Person() {
    super();
  }

  public Person(String name, LocalDateTime birthdate, BigDecimal income) {
    super();
    this.name = name;
    this.birthdate = birthdate;
    this.income = income;
  }

  public Person(String name, LocalDateTime birthdate, BigDecimal income, ArrayList<String> interests) {
    super();
    this.name = name;
    this.birthdate = birthdate;
    this.income = income;
    this.interests = interests;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LocalDateTime getBirthdate() {
    return birthdate;
  }

  public void setBirthdate(LocalDateTime birthdate) {
    this.birthdate = birthdate;
  }

  public BigDecimal getIncome() {
    return income;
  }

  public void setIncome(BigDecimal income) {
    this.income = income;
  }

  public ArrayList<String> getInterests() {
    return interests;
  }

  public void setInterests(ArrayList<String> interests) {
    this.interests = interests;
  }

}
