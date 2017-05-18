package run;

import java.util.ArrayList;
import java.util.Scanner;

import com.ex.pojos.Student;
import com.ex.service.StudentService;

public class Main {
	StudentService svc = new StudentService();
	Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		Main main = new Main();
		main.run();
	}

	public void run() {
		boolean running = true;
		while (running) {
			System.out.println(
					"\t1: Add student\n" +
					"\t2: Delete student\n" +
					"\t3: Update student\n" +
					"\t4: View all\n" +
					"\t5: Quit\n"
					);
			
			System.out.print("What would you like to do? ");
			int choice = Integer.parseInt(input.nextLine());
			
			switch(choice) {
			case 1:
				if (!addStudent()) {
					System.out.println("Please enter valid info and try again.");
				}
				break;
			case 2:
				if (!deleteStudent()) {
					System.out.println("Error attempting to delete student. Please try again.");
				}
				break;
			//default:
			//	System.out.println("asdf");
			//	break;
			case 3:
				if (!updateStudent()) {
					System.out.println("Error attempting to update student. Please try again.");
				}
				break;
			case 4:
				viewStudents();
				break;
			case 5:
				running = false;
				break;
			default:
				System.out.println("Please enter a valid option");
			}
			
			System.out.println(); // Leave some whitespace before next operation
		}
	}
	
	public boolean addStudent() {
		System.out.print("First name: ");
		String fName = input.nextLine();
		
		System.out.print("Last name: ");
		String lName = input.nextLine();
		
		System.out.print("Email address: ");
		String email = input.nextLine();
		
		Student s = svc.addStudent(fName, lName, email);

		return (s != null);
	}
	
	public boolean deleteStudent() {
		System.out.print("Student id: ");
		int id = Integer.parseInt(input.nextLine());
		
		return svc.removeStudent(id);
	}
	
	public boolean updateStudent() {
		System.out.print("Id of student to update: ");
		int id = Integer.parseInt(input.nextLine());
		
		System.out.print("New first name (leave blank to keep old): ");
		String fName = input.nextLine();
		if (fName.isEmpty()) fName = null;
		
		System.out.print("New last name (leave blank to keep old): ");
		String lName = input.nextLine();
		if (lName.isEmpty()) lName = null;
		
		return svc.updateStudent(fName, lName, id) != null;
	}
	
	public void viewStudents() {
		ArrayList<Student> allStudents = svc.getAllStudents();
		
		for (Student s : allStudents) {
			System.out.println(s);
		}
	}
	
}
