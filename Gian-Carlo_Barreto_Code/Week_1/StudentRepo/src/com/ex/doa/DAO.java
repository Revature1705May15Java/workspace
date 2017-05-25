package com.ex.doa;

import java.util.ArrayList;

import com.ex.pojos.Student;

public interface DAO {
	public Student addStudent(Student s);
	public boolean removeStudent(String email);
	public ArrayList<Student> getAllStudents();
	public Student getStudentByEmail(String email);
	public Student updateStudent(Student updatedStudent);
}
