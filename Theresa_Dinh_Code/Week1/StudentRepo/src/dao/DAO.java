package dao;

import pojos.Student;

import java.util.*;

public interface DAO 
{
	Student addStudent(Student s); 

	boolean removeStudent(Student s); 
	
	ArrayList<Student> getAllStudents(); 
	
	Student getStudentById(int id); 
	
	Student updateStudent(Student s, Student u); 
	
}
