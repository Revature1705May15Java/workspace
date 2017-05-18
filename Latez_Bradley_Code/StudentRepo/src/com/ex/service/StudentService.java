package com.ex.service;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.ex.dao.DAO;
import com.ex.dao.IoDAO;
import com.ex.pojos.Student;

class StudentService {
	
	DAO dao = new IoDAO();
	
	public Student addStudent(String fn, String ln, String email){
		
		return null;
	}
	
	public Student getStudentById(int id, ArrayList <Student> a)  {
		
		
		for(Student s:a){
			if(id == s.getId())
				System.out.println(""+s);			
		}			
	
	return null;
}
	/*
	 * Create student object taking in only 3 params
	 * fn ln email
	 * service layer aka business logic layer handles the functionality of
	 * getting the most recently used ID and assigning the new student the next value
	 * must also only accept unique email addresses
	 * 
	 */
	
	public ArrayList<Student> getAllStudents() throws FileNotFoundException{
		return dao.getAllStudents();
	}

}
