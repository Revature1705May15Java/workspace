package com.ex.dao;

import java.util.ArrayList;

import com.ex.exceptions.StudentNotFoundException;
import com.ex.pojos.Student;

public interface DAO {

	ArrayList<Student> getAllStudents();
	
	boolean persistAllStudents();
	
	Student addStudent(Student s);
	
	boolean removeStudent(Student s) throws StudentNotFoundException;
	
	Student getStudent(int id) throws StudentNotFoundException;
	
	Student getStudent(String email) throws StudentNotFoundException;
	
	Student updateStudent(int id, Student updted) throws StudentNotFoundException;
	
	Student updateStudent(String email, Student updated) throws StudentNotFoundException;
	
}
