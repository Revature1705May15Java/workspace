package com.ex.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.ex.doa.DAO;
import com.ex.doa.IoDAO;
import com.ex.pojos.Student;
import com.ex.service.StudentService;

public class Main {
	public static final int ADD = 1;
	public static final int DELETE = 2;
	public static final int VIEWALL = 3;
	public static final int UPDATE = 4;
	public static final int FIND = 5;
	public static final int EXIT = 6;
	
	public static void main(String[] args) {
		run();
	}
	
	
	/**
	 * Display a menu to the user
	 */
	public static void displayMenu() {
		System.out.println("Please select an option from the menu below: ");
		System.out.println("1.  Add a user");
		System.out.println("2.  Delete a user");
		System.out.println("3.  View all students");
		System.out.println("4.  Update a user");
		System.out.println("5.  Find a student by email");
		System.out.println("6.  Exit");
	}
	
	/**
	 * Display the update menu
	 */
	public static void displayUpdateMenu() {
		System.out.println("Which would you like to update: ");
		System.out.println("1. First name");
		System.out.println("2. Last name");
		System.out.println("3. Email");
	}
	
	/**
	 * Get the user's menu choice
	 */
	public static int getUserChoice(Scanner in) {
		int choice = Integer.parseInt(in.nextLine());
		return choice;
	}
	
	public static void executeUpdateMenuChoice(StudentService service, String email, int choice, Scanner in) {
		switch(choice) {
			case (1):
				System.out.println("Please enter the new first name");
				String newFirstName = in.nextLine();
				if (service.updateStudentFirstName(newFirstName, email))
					System.out.println("Student updated successfully");
				else
					System.out.println("Student not updated");
				break;
			case (2):
				System.out.println("Please enter the new last name");
				String newLastName = in.nextLine();
				if (service.updateStudentLastName(newLastName, email))
					System.out.println("Student updated successfully");
				else
					System.out.println("Student not updated");
				break;
			case (3):
				System.out.println("Please enter the new email address");
				String newEmail = in.nextLine();
				if (service.updateStudentEmail(email, newEmail))
					System.out.println("Student updated successfully");
				else
					System.out.println("Student not updated");
				break;
			default:
				System.out.println("Invalid option");
		}
	}
	
	/**
	 * Execute the user's menu choice
	 * @param choice
	 */
	public static void executeUserChoice(StudentService service, int choice, Scanner in) {
		String firstName = null, lastName = null, email = null;
		switch(choice) {
			case (ADD):
				// Add a student
				//in.reset();
				System.out.println("Please enter the student's first name: ");
				firstName = in.nextLine();
				System.out.println("Please enter the student's last name: ");
				lastName = in.nextLine();
				boolean available = false;
				while (!available) {
					System.out.println("Please enter the student's email: ");
					email = in.nextLine();
					available = service.isEmailAvailable(email);
					if (!available)
						System.out.println("Email is not available");
				}
				
				Student s = service.addStudent(firstName, lastName, email);
				System.out.println("Student added succesfully");
				break;
			case (DELETE):
				// Delete a student
				System.out.println("Please enter the email address of the student you want to delete: ");
				email = in.nextLine();
				if (service.removeStudent(email))
					System.out.println("Student removed successfully");
				else
					System.out.println("Student was unable to be removed");
				break;
			case (VIEWALL):
				// View all students
				service.displayStudents();
				break;
			case (UPDATE):
				// Update a student
				System.out.println("Please enter the email of the student that you would like to update: ");
				email = in.nextLine();
				displayUpdateMenu();
				int c = getUserChoice(in); 
				executeUpdateMenuChoice(service, email, c, in);
				break;
			case (FIND):
				// Find a student by email
				System.out.println("Please enter the email address of the student you want to find: ");
				email = in.nextLine();
				service.findStudent(email);
				break;
			case (EXIT):
				// Exit the program
				break;
			default:
				System.out.println("Invalid menu option");
		}
	}
	
	/**
	 * Run the StudentRepo program
	 */
	public static void run() {
		StudentService service = new StudentService();
		Scanner in = new Scanner(System.in);
		int choice = 0;
		
		while (choice != EXIT) {
			displayMenu();
			choice = getUserChoice(in);
			executeUserChoice(service, choice, in);
		}
		in.close();
	}
}
