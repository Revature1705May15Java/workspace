package p7;

public class Employee implements Comparable<Employee>
{
	String firstname; 
	String lastname; 
	String department; 
	int age;
	
	
	public Employee(String firstname, String lastname, String department, int age) 
	{
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.department = department;
		this.age = age;
	}

	public String getFirstname() 
	{
		return firstname;
	}

	public void setFirstname(String firstname) 
	{
		this.firstname = firstname;
	}

	public String getLastname() 
	{
		return lastname;
	}
	
	public void setLastname(String lastname) 
	{
		this.lastname = lastname;
	}

	public String getDepartment() 
	{
		return department;
	}

	public void setDepartment(String department) 
	{
		this.department = department;
	}

	public int getAge() 
	{
		return age;
	}

	public void setAge(int age) 
	{
		this.age = age;
	}

	@Override
	// sorts Employees by last name a > b 
	// returns 0 if Employee e is the same as this.Employee
	// returns -1 if this.Employee is less than Employee e
	// returns 1 if this.Employee is greater than Employee e 
	public int compareTo(Employee e) 
	{
		if(this.lastname.compareTo(e.getLastname()) == 0)
			return 0; 
		else if(this.lastname.compareTo(e.getLastname()) == -1)
			return -1; 
		else 
			return 1; 
	} 
	
	
}
