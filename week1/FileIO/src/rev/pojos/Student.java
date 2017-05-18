package rev.pojos;

import java.io.Serializable;

public class Student implements Serializable{
	int age;
	String firstname;
	String lastname;
	
	public Student(){
		
	}

	public Student(int age, String firstname, String lastname) {
		super();
		this.age = age;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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
		return "Student [age=" + age + ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}
	
	
	
	

}
