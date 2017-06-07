package com.hw.q7;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Employee Class
 */
class Employee {
	String name, department;
	int age;
	
	Employee(String n, String d, int a) {
		name = n;
		department = d;
		age = a;
	}
	
	String getName() {
		return name;
	}
	
	String getDepartment() {
		return department;
	}
	
	int getAge() {
		return age;
	}
	
	public String toString() {
		return "Name: " + name + " " + "Department: " + department + " " + "Age: " + age;
	}
}

/**
 * Sort two employees based on their name, department, and age using the Comparator interface.
 * @author Gian-Carlo
 *
 */
public class EmpSort implements Comparator<Employee> {

	public static void main(String[] args) {
		Employee e1 = new Employee("John", "CS", 23);
		Employee e2 = new Employee("John", "CS", 18);
		ArrayList<Employee> emps = new ArrayList<Employee>();
		emps.add(e1);
		emps.add(e2);
		emps.sort(new EmpSort());
		emps.forEach(e -> System.out.println(e));
	}
	
	public int compare(Employee e1, Employee e2) {
		if (e1.getName().compareTo(e2.getName()) < 0) 
			return -1;
		else if (e1.getName().compareTo(e2.getName()) > 0)
			return 1;
		else {
			if (e1.getAge() < e2.getAge())
				return -1;
			else if (e1.getAge() > e2.getAge())
				return 1;
			else
				return 0;
		}
	}
}
