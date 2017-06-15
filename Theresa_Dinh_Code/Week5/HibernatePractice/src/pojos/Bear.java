package pojos;

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
@Table(name="BEAR")
public class Bear 
{
	@Id
	@Column(name="BEAR_ID")
	@SequenceGenerator(name="BEARID_SEQ", sequenceName="BEARID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BEARID_SEQ")
	private int id; 

	@Column
	private String furColor; 

	@Column
	private String breed; 
	
	@Column
	private double height; 

	@Column
	private double weight; 

	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="BEAR_HOME")
	private Cave dwelling; 
	// fetching (lazy or eager) determines when objects will be retrieved 

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="POT_ID")
	private HoneyPot pot; 

	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="PARENT_CUB", joinColumns=@JoinColumn(name="PARENT_ID"), 
			inverseJoinColumns=@JoinColumn(name="CUB_ID"))
	private Set<Bear> bearCubs;
	
	public Bear() {
		super();
		this.bearCubs = new HashSet<Bear>(); 
	}

	public Bear(String furColor, String breed, double height, double weight, Cave dwelling, HoneyPot pot,
			Set<Bear> bearCubs) {
		super();
		this.furColor = furColor;
		this.breed = breed;
		this.height = height;
		this.weight = weight;
		this.dwelling = dwelling;
		this.pot = pot;
		this.bearCubs = bearCubs;
	}

	public Bear(int id, String furColor, String breed, double height, double weight, Cave dwelling, HoneyPot pot,
			Set<Bear> bearCubs) {
		super();
		this.id = id;
		this.furColor = furColor;
		this.breed = breed;
		this.height = height;
		this.weight = weight;
		this.dwelling = dwelling;
		this.pot = pot;
		this.bearCubs = bearCubs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFurColor() {
		return furColor;
	}

	public void setFurColor(String furColor) {
		this.furColor = furColor;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
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

	public Set<Bear> getBearCubs() {
		return bearCubs;
	}

	public void setBearCubs(Set<Bear> bearCubs) {
		this.bearCubs = bearCubs;
	}

	@Override
	public String toString() {
		return "Bear [id=" + id + ", furColor=" + furColor + ", breed=" + breed + ", height=" + height + ", weight="
				+ weight + ", dwelling=" + dwelling + ", pot=" + pot + ", bearCubs=" + bearCubs + "]";
	} 
	
	
//	
}
