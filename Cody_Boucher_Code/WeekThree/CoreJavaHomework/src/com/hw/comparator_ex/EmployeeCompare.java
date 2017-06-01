package com.hw.comparator_ex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class EmployeeCompare implements Comparator<Employee> {
	
	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static Comparator<Employee> nameComparator = new Comparator<Employee>() {
		@Override
		public int compare(Employee emp1, Employee emp2) {
			return emp1.name.compareTo(emp2.name);
		}
	};
	
	public static Comparator<Employee> departmentComparator = new Comparator<Employee>() {
		@Override
		public int compare(Employee emp1, Employee emp2) {
			return emp1.department.compareTo(emp2.department);
		}
	};
	
	public static Comparator<Employee> ageComparator = new Comparator<Employee>() {
		@Override
		public int compare(Employee emp1, Employee emp2) {
			return Integer.compare(emp1.age, emp2.age);
		}
	};
	
	public static void main(String[] args) {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		
		employees.add(new Employee("John", "Sales", 22));
		employees.add(new Employee("Mike", "Accounting", 26));
		
		Collections.sort(employees, EmployeeCompare.nameComparator);
		System.out.println("\nSorted by name" + employees.toString());
		
		Collections.sort(employees, EmployeeCompare.departmentComparator);
		System.out.println("\nSorted by department" + employees.toString());
		
		Collections.sort(employees, EmployeeCompare.ageComparator);
		System.out.println("\nSorted by age" + employees.toString());
		
	}
}
