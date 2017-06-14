package com.ex.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CAVE")
public class Cave {
  @Id
  @Column(name="C_ID")
  @SequenceGenerator(name="CAVE_SEQ", sequenceName="CAVE_SEQ")
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CAVE_SEQ")
  private int id;
  @Column(name="AREA")
  private double area;
  @Column(name="RENT")
  private double rent;

  public Cave() {
    super();
    // TODO Auto-generated constructor stub
  }

  public Cave(double area, double rent) {
    super();
    this.area = area;
    this.rent = rent;
  }

  public Cave(int id, double area, double rent) {
    super();
    this.id = id;
    this.area = area;
    this.rent = rent;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public double getArea() {
    return area;
  }

  public void setArea(double area) {
    this.area = area;
  }

  public double getRent() {
    return rent;
  }

  public void setRent(double rent) {
    this.rent = rent;
  }

  @Override
  public String toString() {
    return "Cave [id=" + id + ", area=" + area + ", rent=" + rent + "]";
  }

}
