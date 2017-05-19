package studentService;

import java.util.ArrayList;
import dao.DAO;
import dao.IOdao;
import pojos.Student; 

// service class to do all the work 
public class studentService 
{
	DAO dao = new IOdao(); 
	
	static int ID = 1;
	//keeps track of ID
	//increments by 1 after ID is assigned to ensure IDs remain unique  
	
	public Student addStudent(String fn, String ln, String email) //done
	{
		Student temp = new Student(ID++, fn, ln, email); 
//		System.out.println("current ID counter: " + ID);
		return dao.addStudent(temp);  
		//the only time ID should be incremented
	}
	
	// remove students by id, assumes user has correct student id 
	// searches for given student and removes it from the database
	public boolean removeStudent(Student s)//done
	{
		int id = s.getId(); 
		
		for(Student it: getAllStudents())
		{
			if(id == it.getId())
			{
				dao.removeStudent(it); 
				return true; 
			}
		}
		return false; 
	}
	
	public ArrayList<Student> getAllStudents()//done
	{
		return dao.getAllStudents(); 
	}
	
	public Student getStudentById(int id)//done
	{
		ArrayList<Student> list = getAllStudents(); 
		for(Student s : list)
		{
			if(id == s.getId())
				return s; 
		}
		
		return null; //student not found 
	}
	
	//because IDs in database are unique, you can only update student name (and maybe email?) 
	//dao should handle the removal and addition of old/new students in database
	public Student updateStudent(Student oldS, Student newS)//done
	{
		return dao.updateStudent(oldS, newS); 
	}
}
