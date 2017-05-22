package com.ex.service;

import static java.util.Collections.max; // is this the right way to use static imports?

import java.util.ArrayList;

import com.ex.dao.DAO;
import com.ex.dao.IoDAO;
import com.ex.exceptions.StudentNotFoundException;
import com.ex.pojos.Student;

public class StudentService {
	
	private static final StudentService INSTANCE = new StudentService();
	
	public static StudentService getInstance() {
		return StudentService.INSTANCE;
	}
	
	/**
	 * create student object taking in only 3 params: firstName, lastName, email
	 * service layer aka business logic layer handles functionality of getting 
	 * the most recently used ID and assigning a new student the next value
	 * -- should also only accept a unique email address
	 * 
	 * StudentService will ensure that no two students have the same id
	 */
	
	private DAO dao;
	private int nextId;
	
	private StudentService() {
		this.dao = new IoDAO();
		this.nextId  = getNextId();
	}
	
	
	public ArrayList<Student> getStudentsList() {
		return dao.getAllStudents();
	}
	
	public boolean saveStudents() {
		return dao.persistAllStudents();
	}
	
	public Student addStudent(String fName, String lName, String email) {
		try {
			dao.getStudent(email); // throws StudentNotFoundException if no student is found
			return null;
		} catch (StudentNotFoundException e) {
			// add the student only if there are no existing students with the specified email
			Student s = new Student(fName, lName, email, this.nextId);
			dao.addStudent(s);
			this.nextId++;
			return s;
		}		
	}
	
	public Student getStudentByEmail(String email) {
		try {
			return dao.getStudent(email);
		} catch (StudentNotFoundException e) {
			System.out.println("Something went wrong. " + e.getMessage());
			return null;
		}
	}
	
	public boolean removeStudentByEmail(String email) {
		try {
			return dao.removeStudent(dao.getStudent(email));
		} catch (StudentNotFoundException e) {
			System.out.println("Something went wrong. " + e.getMessage());
			return false;
		}
	}
	
	public Student updateStudentByEmail(String email, String newFirstName, String newLastName, String newEmail) {
		try {
			int id = dao.getStudent(email).getId();
			return dao.updateStudent(email, new Student(newFirstName, newLastName, newEmail, id));
		} catch (StudentNotFoundException e) {
			System.out.println("Something went wrong. " + e.getMessage());
			return null;
		}
		
	}
	
//	public Student getStudentById(int id) {
//		try {
//			return dao.getStudent(id);
//		} catch (StudentNotFoundException e) {
//			System.out.println("Something went wrong. " + e.getMessage());
//			return null;
//		}
//	}
//	
//	public boolean removeStudentById(int id) {
//		try {
//			return dao.removeStudent(dao.getStudent(id));
//		} catch (StudentNotFoundException e) {
//			System.out.println("Something went wrong. " + e.getMessage());
//			return false;
//		}
//	}
//	
//	public Student updateStudentById(int id, Student updated) {
//		try {
//			return dao.updateStudent(id, updated);
//		} catch (StudentNotFoundException e) {
//			System.out.println("Something went wrong. " + e.getMessage());
//			return null;
//		}
//		
//	}
	
	private int getNextId() {
		if (dao.getAllStudents().isEmpty()) {
			return 0;
		} else {
			Student newest = max(dao.getAllStudents(), (s1, s2) -> {
				return (s1.getId() - s2.getId());
			});
			return newest.getId() + 1;
		}
	}
	
}
	
	
