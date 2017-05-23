package com.ex.main;

import java.util.Scanner;

import com.ex.pojos.Student;
import com.ex.service.StudentService;

public class main {

	public static void main(String[] args) {
		run();
		
//		Scanner in = new Scanner(System.in);
//				
//		System.out.println("Enter student Id: ");
//		int id = Integer.parseInt(in.nextLine());
//		System.out.println("Enter student first name: ");
//		String fn = in.nextLine();
//		System.out.println("Enter student last name: ");
//		String ln = in.nextLine();
//		System.out.println("Enter student email address: ");
//		String email = in.nextLine();
//		
//		Student temp = new Student(fn,ln,email,id);
//
//		in.close();
	}
	
	static void run(){
		StudentService service = new StudentService();
		Scanner input = new Scanner(System.in);
		int in = 0;
		boolean again = true;
		
		while(again){
			while(true){
				System.out.println("What would you like to do? \n"
					+ "\n1. Add Student    \n2. Delete Student"
					+ "\n3. Update Student \n4. View all Students"
					+ "\n5. Exit");
				try{
					in = Integer.parseInt(input.nextLine().trim());
					break;
				} catch(NumberFormatException e){
					System.out.println("Invalid entry, try again.");
				}
			}
			
			switch (in){
				case 1:
					System.out.println("Enter student first name: ");
					String fn = input.nextLine();
					System.out.println("Enter student last name: ");
					String ln = input.nextLine();
					System.out.println("Enter student email address: ");
					String email = input.nextLine();
					if(service.addStudent(fn, ln, email) == 0) break;
					else System.out.println("Email address '" + email + "' currently in use. Please try again.");
				case 2:
					System.out.println("Delete not yet implemented.");
					break;
				case 3:
					System.out.println("Update not yet implemented.");
					break;
				case 4:
					service.printAllStudents();
					break;
				case 5:
					System.out.println("Have a good day!");
					again = false;
					break;
			}
			// use  a switch statement to then complete the operation
		}
	}

}