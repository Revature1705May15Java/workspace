package com.ex.service;

import java.util.ArrayList;

import com.ex.dao.DAO;
import com.ex.dao.IoDAO;
import com.ex.pojos.Student;

public class StudentService {
	DAO dao = new IoDAO();
		
	public boolean checkEmail(String email){//true means email isn't in list
		ArrayList<Student> students=dao.getAllStudents();
		for(Student student:students){
			if(email.equals(student.getEmail())){
				return false;
			}
		}
		return true;
		
	}
	public Student getStudentByEmail(String email){
		if(!checkEmail(email)){
			ArrayList<Student> students=dao.getAllStudents();
			for(Student student:students){
				if(email.equals(student.getEmail())){
					return student;
				}
			}
		}
		return null;
	}
	public String getStudentFirstNameByEmail(String email){
		Student student =getStudentByEmail(email);
		return student.getFirstName();
	}
	public String getStudentLastNameByEmail(String email){
		Student student =getStudentByEmail(email);
		return student.getLastName();
	}
	
	public void editStudent(String fn,String ln,String email){
		if(!checkEmail(email)){//user is in list
			ArrayList<Student> students=dao.getAllStudents();
			for(Student student:students){
				if(email.equals(student.getEmail())){
					student.setFirstName(fn);
					student.setLastName(ln);
					dao.storeAllStudents(students);
				}
			}
		}
	}
	
	public void addStudent(String fn, String ln, String email){
		Student student=new Student();
		student.setEmail(email);
		student.setFirstName(fn);
		student.setLastName(ln);
		student.setId(generateId());
		if(checkEmail(email)){
			dao.addStudent(student);
		}
	}
	
	public int generateId(){
		ArrayList<Student> students=dao.getAllStudents();
		Student lastStudent=students.get(students.size()-1);
		int newId=lastStudent.getId()+1;
		return newId;
	}
	
	public void removeStudent(String email){
		if(!checkEmail(email)){
			ArrayList<Student> students=dao.getAllStudents();
			for(int i=0;i<students.size();i++){
				if(email.equals((students.get(i)).getEmail())){
					students.remove(i);
					dao.storeAllStudents(students);
				}
			}
		}
	}
	
	
	
	public void viewAllStudents(){
		ArrayList<Student> studentList=dao.getAllStudents();
		System.out.println("\nThe current students:\n");
		for(Student student:studentList){
			System.out.println(
			"First Name: "+String.format("%-8s", student.getFirstName())+
			"Last Name: "+String.format("%-12s", student.getLastName())+
			"Email: "+String.format("%-24s", student.getEmail())+
			"ID: "+String.format("%-5s", ""+student.getId()));
		}
	}
	
	public void storeStudents(){
		ArrayList<Student> studentList=dao.getAllStudents();
		dao.storeAllStudents(studentList);
	}
	public static void main(String[] args) {
		StudentService server=new StudentService();
		ArrayList<Student> studentList=server.dao.getAllStudents();
//		Student studentguy=new Student();
//		studentguy.setEmail("studentguy");
//		studentguy.setFirstName("Student");
//		studentguy.setLastName("Guy");
//		studentguy.setId(3);
//		server.dao.addStudent(studentguy);
		
		server.addStudent("Student","Guy","studentguy@gmail.com");
		server.addStudent("Student","Guy","studentguy2@gmail.com");
		server.addStudent("Student","Guy","markworth89@gmail.com");
		server.editStudent("Studenty","Man" , "studentguy2@gmail.com");
		server.removeStudent("studentguy@gmail.com");
//		server.dao.storeAllStudents(studentList);
		server.viewAllStudents();
	}
	
	
	
	
	
	
}
