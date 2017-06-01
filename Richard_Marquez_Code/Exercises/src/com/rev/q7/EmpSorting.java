package com.rev.q7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmpSorting {
    public static void main(String[] args) {
        List<Employee> emps = new ArrayList<>();
        emps.add(new Employee("richard", "asdf", 12));
        emps.add(new Employee("mark", "asdf", 12));
        emps.add(new Employee("cody", "asdf", 12));
        emps.add(new Employee("eric", "asdf", 12));

        Collections.sort(emps, new Employee());

        for (Employee e : emps) {
            System.out.println(e);
        }
    }
}

