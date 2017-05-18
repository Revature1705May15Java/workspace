// service layer aka busniess logic layer handles the functionality of 

package com.ex.service;

import java.util.ArrayList;

import com.ex.dao.DAO;
import com.ex.dao.IoDAO;
import com.ex.pojos.Student;

public class StudentService {
	
	DAO dao = new IoDAO();
	
	public Student addStudent(String fName, String lName, String email) {
		Student result = null;
		
		if (isUniqueEmail(email)) {
			result = new Student(fName, lName, email, getNextId());
			dao.addStudent(result);
		}
		
		return result;
	}
	
	public Student updateStudent(String fName, String lName, int id) {
		Student updatedStudent = null;
		
		if ((updatedStudent = dao.getStudentById(id)) != null) {
			if (fName != null) updatedStudent.setFirstName(fName);
			if (lName != null) updatedStudent.setLastName(lName);
			
			dao.updateStudent(updatedStudent);
		}
		
		return updatedStudent;
	}
	
	public ArrayList<Student> getAllStudents() {
		return dao.getAllStudents();
	}
	
	public boolean removeStudent(int id) {
		return dao.removeStudent(dao.getStudentById(id));
	}
	
	private int getNextId() {
		int possibleId = 1;
		
		ArrayList<Student> allStudents = getAllStudents();
		
		for (Student s : allStudents) {
			if (s.getId() == possibleId) {
				possibleId++;
			}
		}
		
		return possibleId;
	}
	
	private boolean isUniqueEmail(String possibleEmail) {
		boolean result = true;
		ArrayList<Student> allStudents = getAllStudents();
		
		for (Student s : allStudents) {
			if (s.getEmail().equals(possibleEmail)) {
				result = false;
			}
		}
		
		return result;
	}
	
}
