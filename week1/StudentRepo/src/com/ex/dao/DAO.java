package com.ex.dao;


import java.util.ArrayList;

import com.ex.pojos.Student;


public interface DAO{
	Student addStudent(Student s);
	boolean removeStudent(Student s);
	ArrayList<Student> getAllStudents();
	Student getStudentById(int id);
	Student updateStudent(Student updatedStudent);
	void storeAllStudents(ArrayList<Student> studentList);
	public void emptyFile();
}
