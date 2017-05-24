package com.ex.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.ex.pojos.Student;
import com.ex.service.StudentService;

public class Main {
	
	static enum Task {
		MENU, VIEW_ALL, VIEW, ADD, REMOVE, UPDATE, EXIT
	}
	
	static String menuPrompt = "What would you like to do? (input corresponding number)\n"
			+ "1. View all students\n"
			+ "2. View a student\n"
			+ "3. Add a student\n"
			+ "4. Remove a student\n"
			+ "5. Update a student\n"
			+ "6. Save and exit";
	static String[] view = {"Enter the email of the student you want to view:"};
	static String[] add = {"First name:", "Last name:", "Email"};
	static String[] remove = {"Enter the email of the student you want to remove:"};
	static String[] update = {"Enter the email of the student you want to update:",
			"New first name: (enter nothing to leave unchanged)",
			"New last name: (enter nothing to leave unchanged)",
			"New email: (enter nothing to leave unchanged)"};
	static String[] exit = {"Are you sure you want to exit? (y/n)"};

	public static void main(String[] args) {
		Map<Integer, Task> tasks = new HashMap<Integer, Task>();
		tasks.put(1, Task.VIEW_ALL);
		tasks.put(2, Task.VIEW);
		tasks.put(3, Task.ADD);
		tasks.put(4, Task.REMOVE);
		tasks.put(5, Task.UPDATE);
		tasks.put(6, Task.EXIT);
		
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		StudentService service = StudentService.getInstance();
		boolean running = true;
		Task task = Task.MENU;
		
//		System.out.println("Return to menu? (y/n)");
//		reply = in.nextLine();
//		if (reply.equalsIgnoreCase("y")) {
//			task = Task.MENU;
//		}
		while (running) {
			String reply;
			switch(task) {
			case MENU:
				System.out.println(menuPrompt);
				try {
					String input = in.nextLine();
					task = tasks.get(Integer.parseInt(input));
					if (task == null) {
						System.out.println("Invalid input. You must enter a number corresponding to one of the options:");
					}
				} catch (NumberFormatException e) {
					System.out.println("Invalid input. You must enter a number corresponding to one of the options:");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case VIEW_ALL:
				for (Student s: service.getStudentsList()) {
					System.out.println(s);
				}
				task = Task.MENU;
				break;
			case VIEW:
				System.out.println(view[0]);
				String viewEmail = in.nextLine();
				Student s = service.getStudentByEmail(viewEmail);
				if (s != null) {
					System.out.println(s);
				} else {
					System.out.println("Unable to view student. There is no student with that email.");
				}
				System.out.println("Return to menu? (y/n)");
				reply = in.nextLine();
				if (reply.equalsIgnoreCase("y")) {
					task = Task.MENU;
				}
				break;
			case ADD:
				System.out.println(add[0]);
				String fn = in.nextLine();
				if (fn.equals("")) {
					System.out.println("A first name is required. Nothing has been added.");
				}
				System.out.println(add[1]);
				String ln = in.nextLine();
				if (ln.equals("")) {
					System.out.println("A last name is required. Nothing has been added.");
				}
				System.out.println(add[2]);
				String em = in.nextLine();
				if (em.equals("")) {
					System.out.println("An email is required. Nothing has been added.");
				}
				if (service.addStudent(fn, ln, em) != null) {
					System.out.println("A new student has been added.");
				} else {
					System.out.println("Unable to add student. Another student is already using that email.");
				}
				System.out.println("Return to menu? (y/n)");
				reply = in.nextLine();
				if (reply.equalsIgnoreCase("y")) {
					task = Task.MENU;
				}
				break;
			case REMOVE:
				System.out.println(remove[0]);
				String removeEmail = in.nextLine();
				if (removeEmail.equals("")) {
					System.out.println("You must enter an email to specify which student to remove.");
				} else if (service.removeStudentByEmail(removeEmail)) {
					System.out.println("A student has been removed.");
				} else {
					System.out.println("Unable to remove student. There is no student with that email.");
				}
				System.out.println("Return to menu? (y/n)");
				reply = in.nextLine();
				if (reply.equalsIgnoreCase("y")) {
					task = Task.MENU;
				}
				break;
			case UPDATE:
				System.out.println(update[0]);
				String updateEmail = in.nextLine();
				Student old;
				if (updateEmail.equals("")) {
					System.out.println("You must enter an email to specify which student to update.");
				} else if ((old = service.getStudentByEmail(updateEmail)) != null) {
					System.out.println("Updating " + old.toString());
					System.out.println(update[1]);
					String newFirstName = in.nextLine();
					if (newFirstName.equals("")) {
						newFirstName = old.getFirstName();
					}
					System.out.println(update[2]);
					String newLastName = in.nextLine();
					if (newLastName.equals("")) {
						newLastName = old.getLastName();
					}
					System.out.println(update[3]);
					String newEmail = in.nextLine();
					if (newEmail.equals("")) {
						newEmail = old.getEmail();
					}
					if (service.updateStudentByEmail(updateEmail, newFirstName, newLastName, newEmail) != null) {
						System.out.println("A student has been updated.");
					} else {
						System.out.println("Unable to update student. Another student is already using that email.");
					}
				} else {
					System.out.println("Unable to update student. There is no student with that email.");
				}
				System.out.println("Return to menu? (y/n)");
				reply = in.nextLine();
				if (reply.equalsIgnoreCase("y")) {
					task = Task.MENU;
				}
				break;
			case EXIT:
				System.out.println(exit[0]);
				String response = in.nextLine();
				if (response.equalsIgnoreCase("y")) {
					service.saveStudents();
					running = false;
				}
				task = Task.MENU;
				break;
			}
		}
	}
}
