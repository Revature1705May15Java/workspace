package com.ex.service;

import java.util.ArrayList;

import com.ex.doa.DAO;
import com.ex.doa.IoDAO;
import com.ex.pojos.Student;

public class StudentService {
	IoDAO dao = new IoDAO();
	
	/*
	 * - create student object taking in only 3 params;
	 * - fn, ln, email
	 * service layer aka business logic layer handles the functionality of
	 * getting the most recently used ID and assigning the new student the next value
	 * - must also only accept unique email address
	 */
	public Student addStudent(String firstName, String lastName, String email) {
		ArrayList<Student> students = dao.getAllStudents();
		int id;
		
		if (students.isEmpty())
			id = 1;
		else 
			id = students.get(students.size() - 1).getId() + 1;
		
		Student s = new Student(firstName, lastName, email, id);
		Student addedStudent = dao.addStudent(s);
		
		return addedStudent;
	}
	
	/**
	 * Remove a Student by their email
	 * @param email
	 * @return
	 */
	public boolean removeStudent(String email) {
		return dao.removeStudent(email);
	}
	
	/**
	 * Display all of the students
	 */
	public void displayStudents() {
		ArrayList<Student> students = dao.getAllStudents();
		System.out.println("Displaying all of the students...");
		students.forEach(s -> System.out.println(s));
	}
	
	/**
	 * Updates a Student's first name
	 * @param newFirstName
	 * @param email
	 * @return true if update successful, false otherwise
	 */
	public boolean updateStudentFirstName(String newFirstName, String email) {
		Student s = dao.getStudentByEmail(email);
		s.setFirstName(newFirstName);
		if (dao.updateStudent(s) != null)
			return true;
		else
			return false;
	}
	
	/**
	 * Updates a Student's last name
	 * @param newLastName
	 * @param email
	 * @return true if update successful, false otherwise
	 */
	public boolean updateStudentLastName(String newLastName, String email) {
		Student s = dao.getStudentByEmail(email);
		s.setLastName(newLastName);
		if (dao.updateStudent(s) != null)
			return true;
		else
			return false;
	}
	
	/**
	 * Updates a Student's email address
	 * @param email
	 * @param newEmail
	 * @return ture if update successful, false otherwise
	 */
	public boolean updateStudentEmail(String email, String newEmail) {
		Student s = dao.getStudentByEmail(email);
		s.setEmail(newEmail);
		if (dao.updateStudentByEmail(s, email) != null)
			return true;
		else
			return false;
	}
	
	/**
	 * Finds a specific student by email
	 * @param email
	 */
	public void findStudent(String email) {
		Student s = dao.getStudentByEmail(email);
		
		if (s == null)
			System.out.println("Student was not found");
		else
			System.out.println(s);
	}
	
	/**
	 * Checks to see if an email is available
	 * @param email
	 * @return true if available, false otherwise
	 */
	public boolean isEmailAvailable(String email) {
		ArrayList<Student> students = dao.getAllStudents();
		boolean available = true;
		for (Student student : students) {
			if (email.equals(student.getEmail())) {
				available = false;
				break;
			}
		}
		return available;
	}
}
