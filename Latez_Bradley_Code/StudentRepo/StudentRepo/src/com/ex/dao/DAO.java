package com.ex.dao;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.ex.pojos.Student;
public interface DAO {
	
	Student addStudent(Student s);
	boolean removeStudent(String s);
	ArrayList<Student> getAllStudents();
	Student getStudentById(int id) throws FileNotFoundException;
	Student updateStudent(String e, Student updatedStudent);
	Student getStudentByEmail(String e);
	boolean checkEmail(String e);

	
	
	
	
	
}
