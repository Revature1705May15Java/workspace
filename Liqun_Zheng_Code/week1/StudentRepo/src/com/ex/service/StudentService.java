package com.ex.service;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.ex.dao.DAO;
import com.ex.dao.IoDAO;
import com.ex.pojos.Student;

public class StudentService {
	
	//Create dao 
	DAO dao = new IoDAO();
	
	
	//AddStudent method
	public Student addStudent(String fn, String ln, String email) throws FileNotFoundException{
		ArrayList<Student> students = dao.getAllStudents();

		Student temp = new Student(fn, ln, email, (students.size()+1) );
		dao.addStudent(temp);
		
		return temp;
	}
	
	//Get student by email method
	public Student getStudentByEmail(String email){
		
		return dao.getStudentByEmail(email);
	}
	
	//Remove student by id
	public Student removeStudent(int id){
		return dao.removeStudent(id);
		
	}
	
	//Get ArrayList of student from method getAllStudents method
	public ArrayList<Student> getAllStudents() throws FileNotFoundException{
		return dao.getAllStudents();
	}
	
	
	//Update student by id
	public Student updateStudent(Student s){
		return dao.updateStudent(s);
	}
	/* create student object talking in only 3 params:
	 * - fn, ln, email
	 * service layer aka business logic layer handles the functionality of getting the most recently used ID and assigning the new student the next value 
	 * must also only accept unique email address
	 */
	
//	public ArrayList<Student> getAllStudents(){
//		return 
}
