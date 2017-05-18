package com.rev.dao;

import java.util.ArrayList;

import com.rev.pojo.Student;

public interface DAO 
{
	
	Student addStudent (Student s);
	boolean removeStudent(Student s);
	ArrayList <Student> getAllStudents();
	Student getStudentById(int id);
	Student updateStudent(Student updateStudent);

}
