package com.ex.main;

import java.util.Scanner;

import com.ex.service.StudentService;

//import com.ex.dao.DAO;
//import com.ex.dao.IoDAO;

public class Main {
	
	public enum Level {
		MAIN, TASK, SELECTION, INPUT;
	}
	public enum Task {
		
	}
	
	static String mainPrompt = "What would you like to do? (input corresponding number)";
	static String[] mainOptions = {"1. View all students",
			"2. View a student",
			"3. Add a student",
			"4. Remove a student",
			"5. Update a student",
			"6. Exit"};
	static String studentSelectionPrompt = "How would you like to select a student? (input corresponding number)";
	static String[] studentSelectionOptions = {"1. by id", "2. by email"};

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
//		DAO dao = new IoDAO();
		StudentService service = new StudentService();
		boolean running = true;
		Level currentLevel = Level.MAIN;
		
		while (running) {
			switch(currentLevel) {
			case MAIN:
				break;
			case TASK:
				break;
			case SELECTION:
				break;
			case INPUT:
				break;
			}
					
		}
		
		
		System.out.println("Enter student ID: ");
		int id = Integer.parseInt(in.nextLine()); // catch number format exception
		System.out.println("Enter student firstname: ");
		String fn = in.nextLine();
		System.out.println("Enter student lastname: ");
		String ln = in.nextLine();
		System.out.println("Enter student email address: ");
		String em = in.nextLine();
		
		
		
		
	}
}
