package com.ex.service;

import java.util.ArrayList;

import com.ex.dao.DAO;
import com.ex.dao.IODAO;
import com.ex.pojos.Student;

public class StudentService {
	DAO dao = new IODAO();
	private int lastId;
	
	
	public StudentService(){
		ArrayList<Student> students = getAllStudents();
		
		lastId = students.get(students.size()-1).getId();
	}
	
	public int addStudent(String fname, String lname, String email){ //return -1 on failure, otherwise 0
		if(checkEmail(email)) return -1;
		
		Student temp = new Student(); // creating a temp student to collect all the information and pass it to the dao where it is written.
		
		temp.setFirstName(fname);
		temp.setLastName(lname);
		temp.setEmail(email);
		temp.setId(getNextAvailableId());
		dao.addStudent(temp);
		return 0;
	}
	
	public void printAllStudents(){
		String fname, lname;
		
		ArrayList<Student> students = getAllStudents();
		int length = students.size();
		
		for(int x = 0; x < length; x++){
			System.out.println("Name: " + students.get(x).getLastName() + ", " + students.get(x).getFirstName()); // Only displays first and last name.
		}
		System.out.println(""); // separating the printed data in the console. Formatting.
	}
	
	int getNextAvailableId(){
		return lastId+1;
	}
	
	boolean checkEmail(String email){
		
		ArrayList<Student> students = getAllStudents();
		int length = students.size();
		
		for(int x = 0; x < length; x++){
			if(students.get(0).getEmail().equals(email)) return true;
		}
		
		return false;
	}
	
	public ArrayList<Student> getAllStudents(){
		return dao.getAllStudents();  // returns a non-formatted response!
	}
	
	
	
	
	/*create student object taking in only 3 params
	     - first name, last name, email
	     - must be a unique e-mail address
	 service layer aka business logic layer handles the functionality of 
	 getting the most recently used ID and assigning the new student the next available ID.
	 
	*/
	
	
	
}
