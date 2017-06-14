package com.ex.pojos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "BEAR")
public class Bear {

  @Id
  @Column(name = "B_ID")
  @SequenceGenerator(name = "BEAR_SEQ", sequenceName = "BEAR_SEQ")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BEAR_SEQ")
  private int id;
  
  @Column(name = "COLOR")
  private String color;
  
  @Column(name = "BREED")
  private String brred;
  
  @Column(name = "HEIGHT")
  private double height;
  
  @Column(name = "WEIGHT")
  private double weight;
  
  @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
  @JoinColumn(name="BEAR_HOME")
  private Cave dwelling;
  /*
   * a fetching strategy (LAZY or EAGER) is the strategy hibernate uses for retrieving associated 
   * objects if the app needs to navigate the association. Fetch strategies may be declared in the 
   * ORM metadata or overridden by an HQL of criteria query
   */
  
  @OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
  @JoinColumn(name="BEAR_HONEY")
  private HoneyPot pot;
  
  @ManyToMany(fetch=FetchType.LAZY)
  @JoinTable(name="PARENT_CUB",
  joinColumns=@JoinColumn(name="PARENT_ID"),
  inverseJoinColumns=@JoinColumn(name="CUB_ID")
      )
  private Set<Bear> cubs;

  public Bear() {
    super();
    this.cubs = new HashSet<Bear>();
  }

  public Bear(String color, String brred, double height, double weight, Cave dwelling, HoneyPot pot, Set<Bear> cubs) {
    super();
    this.color = color;
    this.brred = brred;
    this.height = height;
    this.weight = weight;
    this.dwelling = dwelling;
    this.pot = pot;
    this.cubs = cubs;
  }

  public Bear(int id, String color, String brred, double height, double weight, Cave dwelling, HoneyPot pot,
      Set<Bear> cubs) {
    super();
    this.id = id;
    this.color = color;
    this.brred = brred;
    this.height = height;
    this.weight = weight;
    this.dwelling = dwelling;
    this.pot = pot;
    this.cubs = cubs;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getBrred() {
    return brred;
  }

  public void setBrred(String brred) {
    this.brred = brred;
  }

  public double getHeight() {
    return height;
  }

  public void setHeight(double height) {
    this.height = height;
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  public Cave getDwelling() {
    return dwelling;
  }

  public void setDwelling(Cave dwelling) {
    this.dwelling = dwelling;
  }

  public HoneyPot getPot() {
    return pot;
  }

  public void setPot(HoneyPot pot) {
    this.pot = pot;
  }

  public Set<Bear> getCubs() {
    return cubs;
  }

  public void setCubs(Set<Bear> cubs) {
    this.cubs = cubs;
  }

  @Override
  public String toString() {
    return "Bear [id=" + id + ", color=" + color + ", brred=" + brred + ", height=" + height + ", weight=" + weight
        + ", dwelling=" + dwelling + ", pot=" + pot + ", cubs=" + cubs + "]";
  }

}
