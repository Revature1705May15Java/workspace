package com.ex.main;

import java.util.Scanner;

import com.ex.dao.DAO;
import com.ex.dao.IoDAO;
import com.ex.pojos.Student;
import com.ex.service.StudentService;

public class Main {
	static DAO dao = new IoDAO();
	static StudentService service = new StudentService();

	public static void main(String[] args) {
		// init scanner
		Scanner in = new Scanner(System.in);
		// make variable for scanner input
		String decision;
		boolean run = true;

		// Start user prompt
		while (run) {
			System.out.println("What would you like to do?");
			System.out.println("1: Add Student");
			System.out.println("2: Remove Student");
			System.out.println("3: Update Student");
			System.out.println("4: Find Student by Email");
			System.out.println("5: View all Students");
			System.out.println("6: Exit");
			decision = in.nextLine();

			switch (decision) {
			case "1":
				System.out.println("Enter student First Name:");
				String fn = in.nextLine();
				System.out.println("Enter student Last Name:");
				String ln = in.nextLine();
				System.out.println("Enter student Email:");
				String e = in.nextLine();
				while (service.isEmailAvailable(e) == false | e.equals("")) {
					System.out.println("Email is not available, please try again");
					e = in.nextLine();
				}
				service.addStudent(fn, ln, e);
				break;
			case "2":
				System.out.println("Enter email of student you wish to remove");
				e = in.nextLine();
				if (service.removeStudent(e)) {
					System.out.println("Student Removed");
				} else {
					System.out.println("Student was unable to be removed");
				}

				break;
			case "3":
				System.out.println("Feature not available in current version");
				break;

			case "4":
				System.out.println("Input Email of Student");
				String email = in.nextLine();
				Student temp = service.getStudentByEmail(email);
				if (temp != null) {
					System.out.println(temp);
				}
				break;
			case "5":
				System.out.println(service.getAllStudents());
				break;
			case "6":
				run = false;
				break;

			}
		}
		in.close();

	}

}
