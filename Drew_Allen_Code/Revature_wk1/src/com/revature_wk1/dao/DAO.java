package com.revature_wk1.dao;

import java.util.ArrayList;

import com.revature_wk1.pojos.Student;

public interface DAO 
{
	Student addStudent (Student s);
	void removeStudent (int id);
	ArrayList<Student> getAllStudents();
	Student getStudentById (int id);
	Student updateStudent(Student updatedStudent);
}
