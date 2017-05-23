package com.ex.dao;

import java.util.ArrayList;

import com.ex.pojos.Student;

public interface DAO {

	Student addStudent(Student s);
	
	boolean removeStudent(Student s); // boolean to return t/f if the operation was successful or not.
	
	ArrayList<Student> getAllStudents();
	
	Student getStudentById(int id);
	
	Student updateStudent(Student updateStudent);
}