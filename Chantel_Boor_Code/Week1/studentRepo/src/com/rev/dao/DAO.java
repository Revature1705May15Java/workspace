package com.rev.dao;

import java.util.ArrayList;

import com.rev.pojo.Student;

public interface DAO 
{
	
	Student addStudent (Student s);
	void removeStudent(ArrayList<Student> s);
	ArrayList <Student> getAllStudents();
	Student getStudentById(int id);
	void updateStudent(ArrayList<Student> updateStudent);

}
