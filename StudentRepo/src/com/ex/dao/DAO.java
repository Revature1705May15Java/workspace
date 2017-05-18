package com.ex.dao;

import java.util.ArrayList;

import com.ex.exceptions.StudentNotFoundException;
import com.ex.pojos.Student;

public interface DAO {

	ArrayList<Student> getAllStudents();
	
	Student addStudent(Student s);
	
	boolean removeStudent(Student s);
	
	Student getStudent(int id);
	
	Student getStudent(String email);
	
	Student updateStudent(int id, Student updted) throws StudentNotFoundException;
	
	Student updateStudent(String email, Student updated) throws StudentNotFoundException;
	
}
