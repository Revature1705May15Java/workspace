package com.ex.service;

import java.util.ArrayList;
import java.util.List;

import com.ex.dao.DAO;
import com.ex.dao.IoDAO;
import com.ex.pojos.Student;

public class  StudentService {
	DAO dao = new IoDAO();

	public boolean isEmailAvailable(String email){
		List<Student> studentList = getAllStudents();
		boolean available = true;
		for(Student student : studentList){
			if(email.equals(student.getEmail())){
				available = false;
				break;
			}
		}
		return available;
		
	}
	
	public Student getStudentByEmail(String email) {
		boolean found = false;
		ArrayList<Student> s = dao.getAllStudents();
		for (Student student : s) {
			if (email.equals(student.getEmail())) {
				found = true;
				return student;
			}

		}
		if (found == false) {
			System.out.println("Email not found");
		}
		return null;
	}

	public Student addStudent(String fn, String ln, String email) {
		int id;
		List<Student> studentList = dao.getAllStudents();
		if (studentList.isEmpty()){
			id = 0;
		}
		else{
			id = studentList.get(studentList.size()-1).getId();
			
		}
		id++;
		Student student = new Student(fn, ln, email, id);
		student = dao.addStudent(student);
		return student;

		
	}

	public boolean removeStudent(String email) {
		return dao.removeStudent(email);
		
	}
	/*
	 * - create student object taking in only 3 params - fn, ln, email service
	 * layer aka business logic layer handles the functionality of getting the
	 * most recently used ID and assigning the new student the next value - must
	 * also only accept unique email address
	 */

	public ArrayList<Student> getAllStudents() {
		return dao.getAllStudents();
	}
	public boolean updateStudent(String email){
		Student updateStudent = getStudentByEmail(email);
		return dao.updateStudent(updateStudent);
		
	}
}
