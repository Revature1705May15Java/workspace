package com.ex.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="HONEYPOT")
public class HoneyPot {
  @Id
  @Column(name="H_ID")
  @SequenceGenerator(name="HONEYPOT_SEQ", sequenceName="HONEYPOT_SEQ")
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HONEYPOT_SEQ")
  private int id;
  
  @Column(name="CAPACITY")
  private double capacity;

  public HoneyPot() {
    super();
    // TODO Auto-generated constructor stub
  }

  public HoneyPot(double capacity) {
    super();
    this.capacity = capacity;
  }

  public HoneyPot(int id, double capacity) {
    super();
    this.id = id;
    this.capacity = capacity;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public double getCapacity() {
    return capacity;
  }

  public void setCapacity(double capacity) {
    this.capacity = capacity;
  }

  @Override
  public String toString() {
    return "HoneyPot [id=" + id + ", capacity=" + capacity + "]";
  }

}
