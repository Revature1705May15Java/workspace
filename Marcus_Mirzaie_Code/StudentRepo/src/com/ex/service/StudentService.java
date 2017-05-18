package com.ex.service;

import java.util.ArrayList;

import com.ex.dao.DAO;
import com.ex.dao.IoDAO;
import com.ex.pojos.Student;

public class StudentService {
	private DAO dao;
	private ArrayList<Student> students;
	
	public StudentService(){
		dao = new IoDAO();
		students = new ArrayList<Student>(dao.getAllStudents());
	}
	
	// create student object taking in only 3 parameters:
	// - fn, ln, email
	// service layer aka business logic layer handles the functionality of
	// getting the most recently used ID and assigning the new student the 
	// next value.
	// - must also only accept unique email address
	//
	
	private int findNextId(){
		int next = 1;
		while(checkId(next)){
			next += 1;
		}
		return next;
	}
	
	private boolean checkId(int id){
		for(Student s: students){
			if(s.getId() == id) return true;
		}
		return false;
	}
	
	private boolean checkEmail(String email){
		for(Student s: students){
			if(s.getEmail().toLowerCase().equals(email)) return true;
		}
		return false;
	}
	
	private boolean verifyNewStudent(int id, String email){
		boolean make = true;
		if(checkId(id)){
			System.out.println("ID: " + id + " is already in use.");
			make = false;
		}
		if(checkEmail(email.toLowerCase())){
			System.out.println("Email: " + email + " is already in use.");
			make = false;
		}
		return make;
	}
	
	public void addStudent(int id, String fn, String ln, String email){
		if(verifyNewStudent(id, email)){
			Student s = new Student(fn, ln, email, id);
			students.add(s);
			dao.addStudent(s);
		}
		else
			System.out.println("Add failed.");
	}
	
	public void addStudent(String fn, String ln, String email){
		int id = findNextId();
		if(verifyNewStudent(id, email)){
			Student s = new Student(fn, ln, email, id);
			students.add(s);
			dao.addStudent(s);
		}
		else
			System.out.println("Add failed.");
	}
	
	public void updateStudent(int id, String fn, String ln, String email){
		for(Student s: students){
			if(!s.getEmail().toLowerCase().equals(email.toLowerCase()))
				if(s.getId() == id){
					System.out.println("ID in use by another account.");
					return;
				}
					
		}
		for(Student s: students){
			if(s.getEmail().toLowerCase().equals(email.toLowerCase())){
				s.setId(id); s.setFirstName(fn); s.setLastName(ln);
				dao.updateStudent(s);
			}
		}
	}
	
	public void removeStudent(String email){
		Student rem = null;
		for(Student s: students){
			if(s.getEmail().toLowerCase().equals(email.toLowerCase())){
				rem = s;
				dao.removeStudent(s);
			}
		}
		if(rem == null)
			System.out.println("No such student record.");
		else
			students.remove(rem);
	}
	
	public void viewStudents(){
		for(Student s: students){
			System.out.println(s);
		}
	}
}
