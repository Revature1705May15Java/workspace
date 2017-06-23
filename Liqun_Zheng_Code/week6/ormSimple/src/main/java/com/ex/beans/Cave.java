package com.ex.beans;

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
@Table(name="CAVE")
public class Cave implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Cave (String name){
		this.name =name;
	}
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="caveSeq")
	@SequenceGenerator(allocationSize=1,name="caveSeq", sequenceName="CAVE_SEQ")
	@Column(name="CAVE_ID")
	private int id;
	
	@Column(name="CAVE_NAME")
	protected String name;
	
	@OneToMany(mappedBy="cave", fetch=FetchType.EAGER)
	List<Animal> occupants;
	
	
	public Cave(){}
	public Cave(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Cave(int id, String name, List<Animal> occupants) {
		super();
		this.id = id;
		this.name = name;
		this.occupants = occupants;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Animal> getOccupants() {
		return occupants;
	}
	public void setOccupants(List<Animal> occupants) {
		this.occupants = occupants;
	}
	@Override
	public String toString() {
		return "Cave [id=" + id + ", name=" + name + ", occupants=" + occupants + "]";
	}
	
	

}
