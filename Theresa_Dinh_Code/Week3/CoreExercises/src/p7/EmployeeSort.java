package p7;

import java.util.Comparator;

public class EmployeeSort implements Comparator<Employee>
{	
	Employee a = new Employee("Mary", "Sue", "retail", 22); 
	Employee b = new Employee("Gary", "Stu", "retail", 22); 
		
	int n = compare(a, b); 
		
	
	// sorts Employees by last name 
	// returns 0 if Employee a is the same as Employee b 
	// returns -1 if Employee a is less than Employee b 
	// returns 1 if Employee a is greater than Employee b  
	public int compare(Employee a, Employee b) 
	{
		return a.compareTo(b);
	}

}
