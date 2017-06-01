package com.rev.q7;

import java.util.Comparator;

public class Employee implements Comparator<Employee> {
    String name;
    String dept;
    int age;


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", age=" + age +
                '}';
    }

    public Employee(String name, String dept, int age) {
        this.name = name;
        this.dept = dept;
        this.age = age;
    }

    public Employee() {}

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.name.compareTo(o2.name);
    }
}
