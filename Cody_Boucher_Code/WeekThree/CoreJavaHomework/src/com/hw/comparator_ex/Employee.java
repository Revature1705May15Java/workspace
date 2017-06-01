package com.hw.comparator_ex;

//name, department, and age
public class Employee {
	String name;
	String department;
	int age;
	
	public Employee(String name, String department, int age) {
		this.name = name;
		this.department = department;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "\n" + name + ": " + department + ": " + age;
	}
}