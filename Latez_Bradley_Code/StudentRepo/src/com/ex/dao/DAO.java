package com.ex.dao;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.ex.pojos.Student;
public interface DAO {
	
	Student addStudent(Student s);
	boolean removeStudent(Student s);
	ArrayList<Student> getAllStudents();
	Student getStudentById(int id) throws FileNotFoundException;
	
	Student updateStudent(Student updatedStudent);
	Student updateStudent(int id, Student updatedStudent);
	Student getStudentById(int id, ArrayList<Student> a) ;
	Student updateStudent(int id, ArrayList<Student> a);
	
	
	
	
	Student updateStudent(int id, ArrayList<Student> a, String fn, String ln, String em);

	
	
	
	
	
}
