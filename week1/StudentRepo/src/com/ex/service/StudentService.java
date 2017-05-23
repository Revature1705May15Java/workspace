package com.ex.service;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.ex.dao.DAO;
import com.ex.dao.IODAO;
import com.ex.pojos.Student;

public class StudentService {
	DAO dao = new IODAO();
	private int lastId;
	
	
	public StudentService(){
		ArrayList<Student> students = getAllStudents();
		
		if(students != null) {
			for(int i = 0; i < students.size(); i++){
				if(students.get(i).getId() > lastId) lastId = students.get(i).getId();
			}
		}
		else lastId = 100000; // No students exist yet, IDs begin at this number.
	}
	
	public boolean addStudent(String fullName, String email){ //return -1 on failure, otherwise 0
		if(checkEmail(email)) return false;
		StringTokenizer st = new StringTokenizer(fullName);
		int count = st.countTokens();
		if(count != 2) return false;
		
		Student temp = new Student(); // creating a temp student to collect all the information and pass it to the dao where it is written.
		
		temp.setFirstName(st.nextToken());
		temp.setLastName(st.nextToken());
		temp.setEmail(email);
		temp.setId(getNextAvailableId());
		dao.addStudent(temp);
		return true;
	}
	
	public boolean deleteStudent(String fullName){
		StringTokenizer st = new StringTokenizer(fullName);
		int count = st.countTokens();
		if(count != 2) return false;
		
		Student temp = findStudent(st.nextToken(), st.nextToken());
		if(temp == null)return false;
		
		return dao.removeStudent(temp);
	}
	
	public boolean updateStudent(String email){
		Student temp = findStudent(email);
		
		if(temp == null)return false;

		dao.removeStudent(temp);
		Scanner input = new Scanner(System.in);
		int in;
		
		while(true){
			System.out.println("What would you like to do? \n"
				+ "\n1. Change Name\n2. Change email");
			try{
				in = Integer.parseInt(input.nextLine().trim());
				break;
			} catch(NumberFormatException e){
				System.out.println("Invalid entry, try again.");
			}
		}
		
		String fullName;
		boolean repeat = true;
		do{
			switch (in){
				case 1: // update name
					System.out.println("Enter student full name: ");
					fullName = input.nextLine();
					StringTokenizer st = new StringTokenizer(fullName);
					int count = st.countTokens();
					if(count != 2) {
						System.out.println("Incorrect name format (first and last only please). Please try again.");
						continue;
					}
					temp.setFirstName(st.nextToken());
					temp.setLastName(st.nextToken());
					repeat = false;
					break;
				case 2: //update email address
					System.out.println("Enter student email address: ");
					String emailAddress = input.nextLine();
					if(checkEmail(emailAddress)) { // If the email address is in use, repeat
						System.out.println("Email address '" + emailAddress + "' currently in use.");
						continue;
					}
					temp.setEmail(emailAddress);
					repeat = false;
					break;
			}
		}while(repeat);
			// use  a switch statement to then complete the operation
		dao.addStudent(temp);
		
		return true;
	}
	
	public Student findStudent(String First, String Last){ // does not work correctly if multiple entries of same name.
		ArrayList<Student> students = getAllStudents();
		Student temp = new Student();
		int length = students.size();
		
		for(int x = 0; x < length; x++){
			if(students.get(x).getFirstName().equals(First) && students.get(x).getLastName().equals(Last)){
				temp = students.get(x);
				return temp;
			}
		}
		return null;
	}
	
	public Student findStudent(String email){ // Emails are unique so no issues here.
		ArrayList<Student> students = getAllStudents();
		Student temp = new Student();
		int length = students.size();
		
		for(int x = 0; x < length; x++){
			if(students.get(x).getEmail().equals(email)){
				temp = students.get(x);
				return temp;
			}
		}
		return null;
	}
	
	public boolean printStudentByEmail(String email){
		ArrayList<Student> students = getAllStudents();
		if(students == null) return false;
		
		for(int x = 0; x < students.size(); x++){
			if(students.get(x).getEmail().equals(email)){
				System.out.println("Name: " + students.get(x).getLastName() + ", " + students.get(x).getFirstName() + 
								   "  Email: " + students.get(x).getEmail() + "  ID: " + students.get(x).getId());
			}
		}
		
		return true;
	}
	
	public void printAllStudents(){
		String fname, lname;
		
		ArrayList<Student> students = getAllStudents();
		if(students == null) {
			System.out.println("No students found.");
			return;
		}
		int length = students.size();
		
		for(int x = 0; x < length; x++){
			System.out.println("Name: " + students.get(x).getLastName() + ", " + students.get(x).getFirstName()); // Only displays first and last name.
		}
		System.out.println(""); // separating the printed data in the console. Formatting.
	}
	
	int getNextAvailableId(){
		return ++lastId;
	}
	
	boolean checkEmail(String email){
		
		ArrayList<Student> students = getAllStudents();
		if(students == null) return false;
		int length = students.size();
		
		for(int x = 0; x < length; x++){
			if(students.get(x).getEmail().equals(email)) return true;
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
