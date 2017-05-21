package com.ex.main;

import java.util.Scanner;

import com.ex.pojos.Student;
import com.ex.serialize.Serialize;
import com.ex.service.StudentService;

public class Main {
	
	void run(){
		int x = 0, id, switchNum;
		String fn, ln, em;
		
		Student temp = new Student();
		StudentService stu = new StudentService();
		
		Scanner in = new Scanner(System.in);
		
		/*
		 * Gives the user an set of options to manipulate the database
		 * which in this case is the data.txt file.
		 */
		while(x != 1){
			System.out.println("What would you like to do? \n"
					+ "1: Add user \n"
					+ "2: Delete user \n"
					+ "3: Update user \n"
					+ "4: View all \n"
					+ "5: View user by ID \n"
					+ "6: Exit");
			switchNum = Integer.parseInt(in.nextLine());
			
			switch(switchNum){
				case(1):
					System.out.println("Enter Student Id: ");
					id = Integer.parseInt(in.nextLine());
					System.out.println("Enter Student First Name: ");
					fn = in.nextLine();
					System.out.println("Enter Student Last Name: ");
					ln = in.nextLine();
					System.out.println("Enter Student email: ");
					em = in.nextLine();
					
					temp.setId(id);
					temp.setFirstName(fn);
					temp.setLastName(ln);
					temp.setEmail(em);
					stu.addStudent(temp);
					
					break;
				case(2):
					System.out.println("Enter Student Id of user you want deleted: ");
					id = Integer.parseInt(in.nextLine());
					stu.removeStudent(id);
					
					break;
				case(3):
					System.out.println("Enter Student Id of student you want updated: ");
					id = Integer.parseInt(in.nextLine());
					System.out.println("Enter new Student First Name: ");
					fn = in.nextLine();
					System.out.println("Enter new Student Last Name: ");
					ln = in.nextLine();
					System.out.println("Enter new Student email: ");
					em = in.nextLine();
					
					temp.setId(id);
					temp.setFirstName(fn);
					temp.setLastName(ln);
					temp.setEmail(em);
					stu.updateStudent(temp);
					
					break;
				case(4):
					stu.getAllStudents();
					break;
				case(5):
					System.out.println("Enter Student Id of student you want found: ");
					id = Integer.parseInt(in.nextLine());
					stu.getStudentById(id);
					
					break;
				case(6):
					//Closes the loop terminating the user options
					in.close();
					x=1;
					break;
				default:
					//Uses this option only if the user does not enter the number 1-6
					System.out.println("This is not a valid option.");
					break;
			}
		}
	}

	public static void main(String[] args){
		
		Main runMain =  new Main();
		StudentService stu = new StudentService();
		
		String bytestream = "src/com/ex/serialize/bytestream.txt";
		runMain.run();
		
		//Serializes the students in the bytsteram.txt file to save memory space
		Serialize.writeObject(bytestream, stu.getAllStudents());;
	}
}
