package ex.q07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q07 {
  static void sortEmployees(List<Employee> employees) {
    Collections.sort(employees, (Employee a, Employee b) -> {
      if (a.name.compareTo(b.name) != 0) {
        return a.name.compareTo(b.name);
      } else if (a.department.compareTo(b.department) != 0) {
        return a.department.compareTo(b.department);
      } else {
        return a.age - b.age;
      }
    });
  }
  
  public static void main(String[] args) {
    List<Employee> employees = new ArrayList<>();
    employees.add(new Employee("Bob", 27, "Sales"));
    employees.add(new Employee("Alice", 26, "Sales"));
    sortEmployees(employees);
    System.out.println(employees);
  }
}

class Employee {
  String name;
  int age;
  String department;
  
  public Employee(String name, int age, String department) {
    super();
    this.name = name;
    this.age = age;
    this.department = department;
  }
}