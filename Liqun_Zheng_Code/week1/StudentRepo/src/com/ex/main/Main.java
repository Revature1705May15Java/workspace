package com.ex.main;

import java.io.FileNotFoundException;
import java.util.Scanner;

import com.ex.dao.DAO;
import com.ex.dao.IoDAO;
import com.ex.pojos.Student;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner in = new Scanner(System.in);
		DAO dao = new IoDAO();
	
		boolean repeat = true;
		while(repeat){
		System.out.println("What would you like to do \n"
					+ "1: add user\n"
					+ "2: get student by id\n"
					+ "3: delete user\n"
					+ "4: update users\n"
					+ "5: view all\n"
					+ "6. exit\n");
		
		int input=Integer.parseInt(in.nextLine());
		switch(input){	
			case(1): 	System.out.println("Enter Student ID: ");
						int id = Integer.parseInt(in.nextLine());
						System.out.println("Enter Student First Name: ");
						String fn = in.nextLine();
						System.out.println("Enter Student Last Name: ");
						String ln = in.nextLine();
						System.out.println("Enter Student Email Address: ");
						String e = in.nextLine();
				
						Student temp = new Student(fn, ln, e, id);
						dao.addStudent(temp);
						break;
			case(2):	System.out.println("Enter Student ID: ");
						int checkId = Integer.parseInt(in.nextLine());
						dao.getStudentById(checkId);
						break;
						
			case(3):	Student delete= new Student();
						System.out.println("Enter Student ID: ");
						delete.setId(Integer.parseInt(in.nextLine()));
						System.out.println("Enter Student First Name: ");
						delete.setFirstName(in.nextLine());
						System.out.println("Enter Student Last Name: ");
						delete.setLastName(in.nextLine());
						System.out.println("Enter Student Email Address: ");
						delete.setEmail(in.nextLine());
						System.out.println("delete "+ delete.toString());
						dao.removeStudent(delete);
						break;
						
			case(4):	Student update= new Student();
						System.out.println("Enter Student ID: ");
						update.setId(Integer.parseInt(in.nextLine()));
						System.out.println("Enter Student First Name: ");
						update.setFirstName(in.nextLine());
						System.out.println("Enter Student Last Name: ");
						update.setLastName(in.nextLine());
						System.out.println("Enter Student Email Address: ");
						update.setEmail(in.nextLine());
						System.out.println("update "+ update.toString());
						dao.removeStudent(update);
						break;
			
			case(5):	dao.getAllStudents();
						break;
			case(6):	repeat = false;
						break;
						
			default:	System.out.println("default");
						break;
		}
		}
		in.close();
	}
//	void run{
///		StudentService 
//		System.out.println("What would you like to do \n"
//				+ "1: add user"
//				+ "2: delete user"
//				+ "3: update users"
//				+ "4: view all");
//		switch(input):
//			case(1):
//				addUser();
			
//	}
	
}
