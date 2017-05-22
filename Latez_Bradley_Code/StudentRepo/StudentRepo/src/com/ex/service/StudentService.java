package com.ex.service;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.ex.dao.DAO;
import com.ex.dao.IoDAO;
import com.ex.pojos.Student;

class StudentService {
	
	DAO dao = new IoDAO();
	
	public Student addStudent(String fn, String ln, String email){
		ArrayList <Student> s1 = new ArrayList();
		s1 = dao.getAllStudents();
		int id;
		if(s1.size()==0){
			id=1000;
		}
		else
			id=s1.get(s1.size()).getId()+1;
			
		Student s = new Student(fn, ln,email, id);
		return dao.addStudent(s);
	}
	
	public Student getStudentById(int id)  {
		
		
		try {
			return dao.getStudentById(id);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
