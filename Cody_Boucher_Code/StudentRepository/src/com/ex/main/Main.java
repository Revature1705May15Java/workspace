package com.ex.main;

import java.util.Scanner;
import com.ex.service.StudentService;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int userChoice = 0;
		//IoDAO dao = new IoDAO();
//		
//		System.out.println("Enter student Id: ");
//		int id = Integer.parseInt(scan.nextLine());
//		System.out.println("Enter student first name: ");
//		String fn = scan.nextLine();
//		System.out.println("Enter student last name: ");
//		String ln = scan.nextLine();
//		System.out.println("Enter student email address: ");
//		String e = scan.nextLine();
//		scan.close();
//		
//		Student temp = new Student(fn, ln, e, id);
//		temp = dao.addStudent(temp);
		
		StudentService sc = new StudentService();
//		sc.addStudent();
		//dao.getAllStudents();
		//System.out.println(dao.getAllStudents().toString());
		System.out.println("Choose Option Below");
		System.out.println("1) Add Student");
		System.out.println("2) Find Student by ID");
		System.out.println("3) Print All Students");
		System.out.println("4) Remove Student");
		userChoice = scan.nextInt();
		
		switch(userChoice) {
		
			case 1: {
				sc.addStudent();
				break;
			}
			
			case 2: {
				System.out.println("Enter student ID to find");
				int id = scan.nextInt();
				sc.getStudent(id);
				break;
			}
			
			case 3: {
				sc.getStudents();
				break;
			}
			
			case 4: {
				System.out.println("Enter ID of student to remove");
				int id = scan.nextInt();
				sc.removeStudent(id);
				break;
			}
			
			default: {
				System.out.println("Invalid Entry!");
			}
		}
	}
}
