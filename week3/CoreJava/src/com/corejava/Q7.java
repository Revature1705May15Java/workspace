package com.corejava;

import java.util.ArrayList;
import java.util.Comparator;
public class Q7 implements Comparator<Q7Employee>{
/*
 Sort two employees based on their name, department, 
 and age using the Comparator interface.
 */
	static Q7Employee emp1=new Q7Employee();
	static Q7Employee emp2=new Q7Employee(); 
	
	
	public void Q7m(){
		
	}
	public static void main(String[] args) {
		emp1.setName("Dave");
		emp2.setName("Dale");
		emp1.setDepartment("Floral");
		emp2.setDepartment("Bakery");
		emp1.setAge(37);
		emp2.setAge(25);
		
	}
	public ArrayList<Q7Employee> sortArray(int switcher,ArrayList<Q7Employee> emps){
		switch(switcher){
		case(1):
			int compare1=compareName(emps.get(0),emps.get(1));
			if(compare1==-1){
				emps.add(emps.get(0));
				emps.remove(0);
			}
			return emps;
		case(2):
			int compare2=compareName(emps.get(0),emps.get(1));
			if(compare2==-1){
				emps.add(emps.get(0));
				emps.remove(0);
			}
			return emps;
		case(3):
			int compare3=compareName(emps.get(0),emps.get(1));
			if(compare3==-1){
				emps.add(emps.get(0));
				emps.remove(0);
			}
			return emps;
		default:
			return null;
		}
	}
	public int compareName(Q7Employee emp1, Q7Employee emp2) {
		return emp1.name.compareTo(emp2.name);
	}
	public int compareDepartment(Q7Employee emp1, Q7Employee emp2) {
		return emp1.department.compareTo(emp2.department);
	}
	public int compareAge(Q7Employee emp1, Q7Employee emp2) {
		return emp1.age.compareTo(emp2.age);
	}
	@Override
	public int compare(Q7Employee e1, Q7Employee e2) {
		return 0;
	}
	
}