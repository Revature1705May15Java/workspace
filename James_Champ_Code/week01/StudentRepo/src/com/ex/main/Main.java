package com.ex.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.ex.dao.IoDAO;
import com.ex.exceptions.IllegalCharacterException;
import com.ex.exceptions.InvalidEmailException;
import com.ex.exceptions.NonUniqueEmailException;
import com.ex.pojos.Student;
import com.ex.service.StudentService;

public class Main {
	/**
	 * Used when a user's selection was not an integer, as required.
	 */
	private static final int NOT_A_NUMBER = -1;
	/**
	 * The total number of main menu options.
	 */
	private static final int TOTAL_MAIN_MENU_OPTIONS = 5;
	/**
	 * The total number of update student menu options.
	 */
	private static final int TOTAL_UPDATE_MENU_OPTIONS = 4;
	
	private static StudentService service;
	private static Scanner scan;
	
	public static void main(String[] args) {
		run();
	}

	/**
	 * Creates a new {@code StudentService} and {@code Scanner} object. Continues printing
	 * this program's main menu and prompting the user to choose an option, until the user
	 * chooses to end the program.
	 */
	private static void run() {
		service = new StudentService();
		scan = new Scanner(System.in);
		
		int choice;
		
		do {
			printMenu();
			
			String line = scan.nextLine().trim();
			// TODO: Handle incorrect input
			choice = testInputForInt(line);
			
			System.out.println();
			
			switch(choice) {
				case 1:
					addStudent();
					break;
				case 2:
					removeStudent();
					break;
				case 3:
					updateStudent();
					break;
				case 4:
					printAllStudents();
					break;
				case 5:
					shutDown();
					break;
				default:
					printInvalidSelectionMessage(TOTAL_MAIN_MENU_OPTIONS);
			}
		} while(choice != 5);
		
		scan.close();
	}
	
	/**
	 * Prints this program's main menu. The menu provides the user with the following
	 * options: <br/>
	 * <ol>
	 *   <li>Add Student - Allows the user to add a new student to persistent storage.</li>
	 *   <li>Remove Student - Allows the user to remove an existing student from persistent storage.</li>
	 *   <li>Update Student - Allows the user to change an existing student's first name, last name, 
	 *   or email address.</li>
	 *   <li>View All Students - Prints information about each student to the console</li>
	 *   <li>Exit Program - Writes all student data to a file and ends the program</li>
	 * </ol>
	 */
	private static void printMenu() {
		System.out.println("\t1. Add Student");
		System.out.println("\t2. Remove Student");
		System.out.println("\t3. Update Student");
		System.out.println("\t4. View All Students");
		System.out.println("\t5. Exit Program\n");
		
		System.out.print("\tEnter the number of the task that you would like to perform [1 - 5]: ");
	}
	
	/**
	 * Prompts the user for a new student's first name, last name, and
	 * email address. If the email address is not properly formatted, or 
	 * if another existing student has the same email address, an error 
	 * message is printed to the console. Likewise, if a student's first
	 * or last name contains the delimiter used to separate data in the
	 * student storage file, an error message is printed to the console. 
	 * Otherwise, a new student is created and added to memory.
	 */
	private static void addStudent() {
		System.out.print("\tEnter student's first name: ");
		String firstName = scan.nextLine().trim();
		System.out.print("\n\tEnter student's last name: ");
		String lastName = scan.nextLine().trim();
		System.out.print("\n\tEnter student's email address: ");
		String email = scan.nextLine().trim();
		System.out.println();
		
		
		try {
			service.addStudent(firstName, lastName, email);
			System.out.println("\tStudent successfully added.\n");
		} 
		catch(NonUniqueEmailException e) {
			System.out.println("\tCould not add student.");
			System.out.println("\tA student with the same email address already exists.\n");
			//e.printStackTrace();
		} 
		catch(InvalidEmailException e) {
			System.out.println("\tCould not add student.");
			System.out.println("\tThe given email address is improperly formatted.\n");
			//e.printStackTrace();
		}
		catch(IllegalCharacterException e) {
			System.out.println("\tCould not add student.");
			System.out.println("\tStudent's name cannot contain '" + IoDAO.DELIMITER + "'.\n");
		}
	}
	
	/**
	 * Prompts the user to enter a student's ID number. If a student with the given 
	 * ID number exists, that student is removed from persistent storage and a 
	 * success message is printed.
	 * 
	 * If a student is not found, an error message is printed.
	 */
	private static void removeStudent() {
		System.out.print("\tEnter the ID number of the student that you are removing:");
		
		String line = scan.nextLine().trim();
		System.out.println();
		// TODO: Handle improper input
		int id = Integer.parseInt(line);
		
		if(service.removeStudent(id)) {
			System.out.println("\tStudent successfully removed.\n");
		}
		else {
			System.out.println("\tCould not find student with ID number " + id + ".\n");
		}
	}
	
	/**
	 * Prompts the user for an existing student's ID number. If that student exists, the
	 * update student menu is printed to the console. The user can then change the student's
	 * first name, last name, and email address.
	 * <br>
	 * Students will not be updated if any of the following things occur:
	 * <ol>
	 * 	<li>Updated student has an email that is the same as another stored student's.</li>
	 * 	<li>Updated student's email is not properly formatted.</li>
	 * 	<li>Updated student's first or last name contains the delimiter used in the student
	 * 		data text file.</li>
	 * </ol>
	 */
	private static void updateStudent() {
		System.out.print("\tEnter the ID number of the student that is being updated: ");
		String line = scan.nextLine().trim();
		System.out.println();
		
		int id = testInputForInt(line);
		
		if(id == NOT_A_NUMBER) {
			System.out.println("\tInvalid input:");
			System.out.println("\tPlease enter whole numbers only.\n");
			updateStudent();
		}
		else {
			Student student = service.getStudentById(id);
			
			if(student == null) {
				System.out.println("\tCould not find student with id number " + id + ".\n");
			}
			else {
				Student updatedStudent = student.makeCopy();
			
				int choice;
				
				do {
					printUpdateMenu();
					line = scan.nextLine().trim();
					choice = testInputForInt(line);
				
					switch(choice) {
						case 1:
							System.out.print("\tEnter new first name: ");
							String firstName = scan.nextLine().trim();
							updatedStudent.setFirstName(firstName);
							break;
						case 2:
							System.out.print("\tEnter new last name: ");
							String lastName = scan.nextLine().trim();
							updatedStudent.setLastName(lastName);
							break;
						case 3:
							System.out.print("\tEnter new email address: ");
							String email = scan.nextLine().trim();
							updatedStudent.setEmail(email);
							break;
						case 4:
							if(student.equals(updatedStudent)) {
								System.out.println("\tNo changes made to student's data.\n");
							}
							else {
								try {
									service.updateStudent(updatedStudent);
									System.out.println("\tUpdates completed.\n");
								} 
								catch(InvalidEmailException e) {
									System.out.println("\tCould not update student's data.");
									System.out.println("\tEmail address improperly formatted.\n");
									//e.printStackTrace();
								} 
								catch(NonUniqueEmailException e) {
									System.out.println("\tCould not update student's data.");
									System.out.println("\tA student with the given email address already exists.\n");
									//e.printStackTrace();
								}
								catch(IllegalCharacterException e) {
									System.out.println("\tCould not update student's data.");
									System.out.println("\tStudent's name cannot contain '" + IoDAO.DELIMITER + "'.\n");
								}
							}
						
							break;
						default:
							printInvalidSelectionMessage(TOTAL_UPDATE_MENU_OPTIONS);
					}
				
					System.out.println();
				} while(choice != 4);
			}
		}
	}
	
	/**
	 * Prints a list of options for updating an existing student's information.
	 * Prompts the user to make a selection.
	 */
	private static void printUpdateMenu() {
		System.out.println("\t1. Update student's first name");
		System.out.println("\t2. Update student's last name");
		System.out.println("\t3. Update student's email");
		System.out.println("\t4. Finish updating student's information");
		
		System.out.print("\n\tEnter your selection [1 - 4]: ");
	}
	
	/**
	 * Prints a list of all students to the console. Each student is listed
	 * on its own line.
	 */
	private static void printAllStudents() {
		ArrayList<Student> students = service.getAllStudents();
		
		System.out.println("\tCurrent Students:");
		
		for(Student s : students) {
			System.out.println("\t" + s.toString());
		}
		
		System.out.println();
	}
	
	/**
	 * Called before the program is terminated.  Persists all
	 * student data and prints a message that indicates that the
	 * program has stopped running.
	 */
	private static void shutDown() {
		service.writeAllStudentsToFile();
		System.out.println("\n\nProgram terminated...\n");
	}
	
	// TODO: Document the following methods:
	
	private static int testInputForInt(String s) {
		int result;
		
		try {
			result = Integer.parseInt(s);
		}
		catch(NumberFormatException e) {
			result = NOT_A_NUMBER;
		}
		
		return result;
	}
	
	private static void printInvalidSelectionMessage(int totalSelections) {
		System.out.println("\tInvalid selection:");
		System.out.println("\tPlease enter a whole number between 1 and " + totalSelections + ".\n\n");
	}
}
