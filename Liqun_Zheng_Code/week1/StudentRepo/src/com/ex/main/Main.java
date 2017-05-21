package com.ex.main;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.ex.dao.DAO;
import com.ex.dao.IoDAO;
import com.ex.pojos.Student;
import com.ex.service.StudentService;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		run();
	}
	
	static void run() throws FileNotFoundException{
		//create scanner to get user input option
		Scanner in = new Scanner(System.in);
		StudentService service = new StudentService();
		
		
		
		boolean repeat = true;
		
		//total six options for user to choose from
		while(repeat){
			System.out.println("What would you like to do \n"
					+ "1: add user\n"
					+ "2: get student by email\n"
					+ "3: delete user\n"
					+ "4: update users\n"
					+ "5: view all\n"
					+ "6. exit\n");
		
			int input=Integer.parseInt(in.nextLine());
			switch(input){	
			//case 1 add student
			case(1): 	
						System.out.println("Enter Student First Name: ");
						String fn = in.nextLine();
						System.out.println("Enter Student Last Name: ");
						String ln = in.nextLine();
						String e;
						boolean invaildEmail;
						do{
							System.out.println("Enter Student Email Address: ");
							e = in.nextLine();
							invaildEmail = (service.getStudentByEmail(e)!=null);
							//check email entered by user are already in the file
							if(invaildEmail){
								System.out.println("Already had this email, please re-enter the email");
							}
						}while(invaildEmail);
						
						//call the service to add student to file
						service.addStudent(fn,ln,e);
						break;
						
			//case 2 to get student by email				
			case(2):	System.out.println("Enter Student email: ");
						String email = in.nextLine();
						
						//call the service to get student by email
						service.getStudentByEmail(email);
						break;
						
			//case 3 to delete student by student id				
			case(3):
						System.out.println("Enter Student id: ");
						int tempId = (Integer.parseInt(in.nextLine()));
	
						System.out.println("delete ID"+ tempId);
						service.removeStudent(tempId);
						break;
						
			//case 4 update student by id				
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
						service.updateStudent(update);
						break;
						
			//case 5 print all student from the list	
			case(5):	service.getAllStudents();
						break;
						
			//case 6 exit loop				
			case(6):	repeat = false;
						break;
						
			default:	System.out.println("default");
						break;
			}
		}
		in.close();
	}
}
