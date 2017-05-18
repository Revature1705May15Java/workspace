package com.ex.dao;

import com.ex.pojos.Student;
import java.util.*;

// DAO is JUST a reader/writer to the data source
public interface DAO {

	Student addStudent(Student s);
	Student updateStudent(Student updatedStudent);
	
	boolean removeStudent(Student s);
	
	ArrayList<Student> getAllStudents();
	Student getStudentById(int id);
}
