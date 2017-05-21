package com.ex.service;

import java.util.ArrayList;

import com.ex.dao.DAO;
import com.ex.dao.IoDAO;
import com.ex.pojos.Student;

public class StudentService {

	DAO dao = new IoDAO();
	
	/*
	 * Given a Student object we will use this method to 
	 * add the data contained in the Student object to the
	 * data.txt file. It will also check if the given student 
	 * id is unique if that is not the case it will provide one for 
	 * the user.
	 */
	public Student addStudent(Student s){
		Student s1 = new Student();
		s1.setEmail(s.getEmail());
		s1.setFirstName(s.getFirstName());
		s1.setLastName(s.getLastName());
		s1.setId(dao.checkId(s.getId()));
		dao.addStudent(s1);
		return s;
	}
	
	/*
	 * Given the id from the user this method will check if the 
	 * given id is present within the data.txt file, if so it will
	 * then proceed to remove that student form the data.txt file.
	 */
	public void removeStudent(int id){
		dao.removeStudent(id);
	}
	
	/*
	 * This method will show a visual representation of the data.txt file,
	 * which will show the in the console.
	 */
	public ArrayList<Student> getAllStudents(){
		return dao.getAllStudents();
	}
	
	/*
	 * Given the student ID this method will print out the information for 
	 * that student as well as return that student as a Student object.
	 */
	public Student getStudentById(int id){
		return dao.getStudentById(id);
	}
	
	/*
	 * This method accepts a Student object that will contain
	 * the ID of the student you will want to replace. If the 
	 * ID matches then the given Student object will replace the 
	 * old data in the data.txt
	 */
	public void updateStudent(Student updatedStudent){
		dao.updateStudent(updatedStudent);
	}
	
}
