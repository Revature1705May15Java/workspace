package com.ex.dao;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.ex.pojos.Student;


public interface DAO {
	Student addStudent(Student s);
	void removeStudent(Student s);
	ArrayList<Student> getAllStudents() throws FileNotFoundException;
	Student getStudentById(int id);
	void updateStudent(Student updatedStudent);
}
