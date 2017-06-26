package com.ex.test;

import com.ex.beans.Employee;
import com.ex.service.Service;

public class Tester {
	public static void main(String[] args) {
		Service s = new Service();
		Employee e = new Employee("John", "Doe", "jdoe@gmail.com", "pass", false);
		System.out.println(e);
		System.out.println(s.createEmployee(e));
	}
}
