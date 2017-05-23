package com.ex.main;

import java.util.Scanner;

import com.ex.pojos.Student;
import com.ex.service.StudentService;

/*
 * Functionality we need completed:
 * 1. add user - done
 * 2. delete user - done
 * 3.view all - done
 * 4. update user - done
 * 5. find by email - done
 * 
 */

public class main {

	public static void main(String[] args) {
		run();
	}
	
	static void run(){
		StudentService service = new StudentService();
		Scanner input = new Scanner(System.in);
		int in = 0;
		boolean again = true;
		
		while(again){
			while(true){
				System.out.println("\nWhat would you like to do? \n"
					+ "\n1. Add Student                   4. View all Students"
					+ "\n2. Update Student                5. Delete Student"
					+ "\n3. Search for Student by Email   0. Exit");
				try{
					in = Integer.parseInt(input.nextLine().trim());
					break;
				} catch(NumberFormatException e){
					System.out.println("Invalid entry, try again.");
				}
			}
			
			String fullName, email;
			switch (in){
				case 1: // add student
					System.out.println("Enter student full name: ");
					fullName = input.nextLine();
					System.out.println("Enter student email address: ");
					email = input.nextLine();
					if(!service.addStudent(fullName, email)) System.out.println("Email address '" + email + "' currently in use or incorrect name format (first and last only please). Please try again.");
					break;
				case 2: //update student
					System.out.println("To find the student, enter student email address: ");
					email = input.nextLine();
					if(!service.updateStudent(email)) System.out.println("Email address not found.");
					break;
				case 3: // find student by email
					System.out.print("Enter student email: ");
					String studentEmail = input.nextLine().trim();
					if(!service.printStudentByEmail(studentEmail)) System.out.println("Email '" + studentEmail + "' not currently in use.");
					break;
				case 4: // view all students
					service.printAllStudents();
					break;
				case 5: // delete student
					System.out.println("Enter student full name: ");
					fullName = input.nextLine().trim();
					if(!service.deleteStudent(fullName)) System.out.println("Student '" + fullName + "' not found. Please try again.");
					break;			
				case 0: // exit
					System.out.println("Have a good day!");
					again = false;
					break;
			}
			// use  a switch statement to then complete the operation
		}
	}

}
