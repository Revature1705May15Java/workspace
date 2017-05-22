package com.ex.dao;

import java.util.ArrayList;

import com.ex.pojos.Student;

public interface DAO {
	
	Student addStudent(Student s);
	boolean removeStudent(Student s);
	Student updateStudent(Student s);
	Student getStudentById(int id);
	Student getStudentByEmail(String email);
	ArrayList<Student> getAllStudents();
	
}
