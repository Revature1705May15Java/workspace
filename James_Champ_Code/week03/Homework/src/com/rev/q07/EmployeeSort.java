package com.rev.q07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeSort {
	public static void main(String[] args) {
		Employee empOne = new Employee("Bob", "Franklin", "Automotive", 33);
		Employee empTwo = new Employee("Jesse", "Bobessie", "Automotive", 44);
		Employee empThree = new Employee("Alice", "Bobessie", "Accounting", 22);
		Employee empFour = new Employee("Alice", "Bobessie", "Sales", 64);
		Employee empFive = new Employee("Alice", "Bobessie", "Sales", 33);
		
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(empOne);
		empList.add(empTwo);
		empList.add(empThree);
		empList.add(empFour);
		empList.add(empFive);
		
		Collections.sort(empList, empTwo);
		
		for(Employee e : empList) {
			System.out.println(e.toString());
		}
	}
}

class Employee implements Comparator<Employee>{
	String firstName;
	String lastName;
	String department;
	int age;
	
	public Employee(String first, String last, String dept, int age) {
		firstName = first;
		lastName = last;
		department = dept;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return lastName + ", " + firstName + "\tDept: " + department + "\tAge: " + age;
	}

	@Override
	public int compare(Employee em1, Employee em2) {
		int result = em1.lastName.compareToIgnoreCase(em2.lastName);
		
		if(result == 0) {
			result = em1.firstName.compareToIgnoreCase(em2.firstName);
			
			if(result == 0) {
				result = em1.department.compareToIgnoreCase(em2.department);
				
				if(result == 0) {
					result = ((Integer)em1.age).compareTo((Integer)em2.age);
				}
			}
		}
		
		return result;
	}
}
