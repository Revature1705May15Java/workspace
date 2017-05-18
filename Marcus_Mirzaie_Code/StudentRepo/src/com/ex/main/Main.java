package com.ex.main;

import java.util.Scanner;

//import com.ex.dao.DAO;
//import com.ex.dao.IoDAO;
import com.ex.exceptions.StudentNotFoundException;
import com.ex.service.StudentService;
//import com.ex.pojos.Student;

public class Main {

	public static void main(String[] args) throws StudentNotFoundException{
		
		
//		DAO dao = new IoDAO();
		
//		System.out.println("enter student Id:");
//		int id = Integer.parseInt(in.nextLine());
//		System.out.println("enter student firstname:");
//		String fn = in.nextLine();
//		System.out.println("enter student lastname:");
//		String ln = in.nextLine();
//		System.out.println("enter student email:");
//		String e = in.nextLine();
//		
//		Student temp = new Student(fn,ln, e, id);
//		
//		dao.addStudent(temp);

//		dao.getAllStudents();
		
		View prog = new View();

		while(prog.isRunning()){
			prog.choose();
		}
		
	}
	
}

class View{
	
	private Scanner in;
	private boolean running;
	private StudentService serv;
	
	View(){
		in = new Scanner(System.in);		// initialize scanner
		running = true;						// whether to exit
		serv = new StudentService();		// StudentService for interaction
	}
	
	private int select(){
		return in.nextInt();
	}
	
	void displayMenu(){
		System.out.println("What what you like to do?\n"
				+ "1: add student\n"
				+ "2: delete student\n"
				+ "3: update student\n"
				+ "4: view all students\n"
				+ "5: exit");
	}
	
	private void addStudent(){
		System.out.println("How would you like to add the student?\n"
				+ "1: Specify ID\n"
				+ "2: Generate next ID");
		int id; String fn, ln, email;
		switch(select()){
		case(1):
			System.out.print("ID:  "); id = select();
			System.out.print("First Name: "); fn = in.next();
			System.out.print("Last Name: "); ln = in.next();
			System.out.print("Email: "); email = in.next();
			serv.addStudent(id, fn, ln, email);
			break;
		case(2):
			System.out.print("First Name: "); fn = in.next();
			System.out.print("Last Name: "); ln = in.next();
			System.out.print("Email: "); email = in.next();
			serv.addStudent(fn, ln, email);
			break;
		default:
			System.out.println("Invalid choice.");
		}
	}
	
	private void deleteStudent(){
		String email;
		System.out.println("Enter the email of the student you wish to remove: ");
		email = in.next();
		serv.removeStudent(email);
	}
	
	private void updateStudent(){
		int id; String fn, ln, email;
		System.out.println("Enter updated record: ");
		System.out.print("ID:  "); id = select();
		System.out.print("First Name: "); fn = in.next();
		System.out.print("Last Name: "); ln = in.next();
		System.out.print("Email: "); email = in.next();
		serv.updateStudent(id, fn, ln, email);
	}
	
	private void viewStudents(){
		serv.viewStudents();
	}
	
	void choose(){
		displayMenu();
		switch(select()){
		case(1):
			addStudent();
			break;
		case(2):
			deleteStudent();
			break;
		case(3):
			updateStudent();
			break;
		case(4):
			viewStudents();
			break;
		case(5):
			System.out.println("Exiting...");
			setRunning(false);
			break;
		default:
			System.out.println("Invalid Choice, try again...");
		}
	}
	
	private void setRunning(boolean running) {
		this.running = running;
	}

	boolean isRunning(){
		return running;
	}

}