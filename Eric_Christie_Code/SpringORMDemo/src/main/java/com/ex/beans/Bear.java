package com.ex.beans;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@NamedQueries({
  @NamedQuery(name="findBearByName", query="from Bear where name = :namevar")
})

@Component
@Entity
@Table(name="BEAR")
@AttributeOverrides({
  @AttributeOverride(name="id", column=@Column(name="BEAR_ID")),
  @AttributeOverride(name="name", column=@Column(name="BEAR_NAME")),
  @AttributeOverride(name="cave", column=@Column(name="BEAR_CAVE"))
})
public class Bear extends Animal implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -6348645824241620133L;

  @Column(name="BEAR_WEIGHT")
  private int weight;

  public Bear() {
    super();
  }

  public Bear(String name, int weight, Cave cave) {
    super();
    this.weight = weight;
    this.name = name;
    this.cave = cave;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

}
