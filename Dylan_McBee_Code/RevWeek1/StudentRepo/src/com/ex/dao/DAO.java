package com.ex.dao;

import java.util.ArrayList;
import java.util.List;

import com.ex.pojos.Student;

public interface DAO {

	Student addStudent(Student s);

	boolean removeStudent(String email);

	ArrayList<Student> getAllStudents();

	
	boolean updateStudent(Student updateStudent);


}
