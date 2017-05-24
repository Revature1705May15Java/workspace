package com.ex.pojos;

public class Customer {
  int id;
  String firstname, lastname, state, email;
  double credit;

  public Customer() {
    super();
  }

  public Customer(String firstname, String lastname, String state, String email, double credit) {
    super();
    this.firstname = firstname;
    this.lastname = lastname;
    this.state = state;
    this.email = email;
    this.credit = credit;
  }

  public Customer(int id, String firstname, String lastname, String state, double credit, String email) {
    super();
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;
    this.state = state;
    this.email = email;
    this.credit = credit;
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

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public double getCredit() {
    return credit;
  }

  public void setCredit(double credit) {
    this.credit = credit;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "Customer [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", state=" + state
        + ", email=" + email + ", credit=" + credit + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    long temp;
    temp = Double.doubleToLongBits(credit);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    result = prime * result + ((email == null) ? 0 : email.hashCode());
    result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
    result = prime * result + id;
    result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
    result = prime * result + ((state == null) ? 0 : state.hashCode());
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
    Customer other = (Customer) obj;
    if (Double.doubleToLongBits(credit) != Double.doubleToLongBits(other.credit))
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
    if (state == null) {
      if (other.state != null)
        return false;
    } else if (!state.equals(other.state))
      return false;
    return true;
  }

}
