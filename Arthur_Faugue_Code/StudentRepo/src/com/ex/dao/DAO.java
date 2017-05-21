package com.ex.dao;

import java.util.ArrayList;
import com.ex.pojos.*;

public interface DAO {
	
	/*
	 * A simple DAO interface that will handle the 
	 * database operations required to manipulate
	 * the Student entity. 
	 */
	Student addStudent(Student s);
	void removeStudent(int id);
	ArrayList<Student> getAllStudents();
	Student getStudentById(int id);
	void updateStudent(Student s);
	int checkId(int id);
	
}
