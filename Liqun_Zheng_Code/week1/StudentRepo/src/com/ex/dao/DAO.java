package com.ex.dao;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.ex.pojos.Student;


public interface DAO {
	void addStudent(Student s);
	Student removeStudent(int id);
	ArrayList<Student> getAllStudents() throws FileNotFoundException;
	Student getStudentByEmail(String email);
	Student updateStudent(Student updatedStudent);
}
