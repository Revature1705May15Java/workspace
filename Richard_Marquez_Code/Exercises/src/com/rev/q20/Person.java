package com.rev.q20;

public class Person {
	String fName;
	String lName;
	int age;
	String location;
	
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public Person(String fName, String lName, int age, String location) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.age = age;
		this.location = location;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}
