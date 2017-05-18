package com.revature.dao;

import java.util.ArrayList;

import com.revature.pojos.Student;

public interface DAO 
{
	Student addStudent (Student s);
	void removeStudent (int id);
	ArrayList<Student> getAllStudents();
	Student getStudentById (int id);
	Student updateStudent(Student updatedStudent);
}
