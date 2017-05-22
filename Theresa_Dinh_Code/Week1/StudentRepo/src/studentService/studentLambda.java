package studentService;

import java.util.ArrayList;

import pojos.Student;

public class studentLambda 
{
	public static void main(String[] args)
	{
		studentLambda sl = new studentLambda(); 
		StudentService ss = new StudentService(); 
		ss.addStudent("p", "p", "me@email.com"); 
		ArrayList<Student> list = ss.getAllStudents(); 
		
		StudentFunction lastNameSearch = (ArrayList<Student> roster, String str)->sl.search(roster, str);
		StudentFunction checkEmail = (ArrayList<Student> roster, String str)->sl.retrieve(roster, str); 
		
		System.out.println("Last name(s) starting with letter X were found: " + sl.choose(lastNameSearch, list,"X"));
		System.out.println("There exists a student with this email: " + sl.choose(checkEmail, list, "someone@email.com"));
	}
	//how you get to which lambda exp you want 
	private boolean choose(StudentFunction f, ArrayList<Student> al, String str)	
	{
		return f.function(al, str);
	}
	//returns true if any lastnames starting with given letter are in database
	public static boolean search(ArrayList<Student> list, String letter)	
	{
		for(Student s : list)
		{
			if(s.getLastName().startsWith(letter))
			{
				return true;  
			}
				
		}
		return false;
	}
	// tells you if the email is retrievable from the database 
	public static boolean retrieve(ArrayList<Student> list, String email)
	{
		for(Student s : list)
		{
			if(s.getEmail().equals(email))
			{
				return true;  
			}
				
		}
		return false; 
	}
}

interface StudentFunction
{
	 boolean function(ArrayList<Student> al, String str); 
}

