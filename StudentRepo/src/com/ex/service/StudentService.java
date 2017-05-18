package com.ex.service;

import static java.util.Collections.max; // is this the right way to use static imports?

import java.util.ArrayList;

import com.ex.dao.DAO;
import com.ex.dao.IoDAO;
import com.ex.exceptions.StudentNotFoundException;
import com.ex.pojos.Student;

/*
 * how much of this class can be made static?
 * dao, nextId, getAllStudents(), getNextId() ?
 */
public class StudentService {
	
	DAO dao = new IoDAO(); // does it create a singleton if this is made static?
	int nextId = getNextId();
	
	
	/** TODO (try to finish tonight, have done by Friday at latest)
	 * create student object taking in only 3 params: firstName, lastName, email
	 * service layer aka business logic layer handles functionality of getting the most recently
	 * used ID and assigning a new student the next value
	 * -- should also only accept a unique email address
	 * 
	 * StudentService will ensure that no two students have the same id
	 */
	
	public ArrayList<Student> getAllStudents() {
		return dao.getAllStudents();
	}
	
	public Student addStudent(String fName, String lName, String email) {
		if (dao.getStudent(email) == null) {
			Student s = new Student(fName, lName, email, getNextId());
			dao.addStudent(s);
			return s;
		} else {
			return null;
		}
		
	}
	
	public Student getStudentById(int id) {
		return dao.getStudent(id);
	}
	
	public Student getStudentByEmail(String email) {
		return dao.getStudent(email);
	}
	
	public boolean removeStudent(Student s) {
		return dao.removeStudent(s);
	}
	
	public boolean removeStudentById(int id) {
		return dao.removeStudent(dao.getStudent(id));
	}
	
	public boolean removeStudentByEmail(String email) {
		return dao.removeStudent(dao.getStudent(email));
	}
	
	public Student updateStudentById(int id, Student updated) {
		try {
			return dao.updateStudent(id, updated);
		} catch (StudentNotFoundException e) {
			return null;
		}
		
	}
	
	public Student updateStudentByEmail(String email, Student updated) {
		try {
			return dao.updateStudent(email, updated);
		} catch (StudentNotFoundException e) {
			return null;
		}
		
	}
	
	private int getNextId() {
		Student newest = max(getAllStudents(), (s1, s2) -> {
			return (s1.getId() - s2.getId());
		});
		return newest.getId() + 1;
	}
	
	
	
}
	
	
