package com.ex.dao;

import com.ex.pojos.Student;
import java.util.ArrayList;

public interface DAO {
	
	Student addStudent(Student s);
	
	boolean removeStudent(Student s);
	
	Student updateStudent(Student updatedStudent);
	
	Student getStudentById(int id);
	
	ArrayList<Student> getAllStudents();
	
	void pushChanges(ArrayList<Student> temp);

}
