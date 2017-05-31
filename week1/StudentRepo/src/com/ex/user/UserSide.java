package com.ex.user;
import java.util.Scanner;


import com.ex.service.StudentService;

public class UserSide {
	public static void startInput(){
		StudentService server=new StudentService();
		System.out.println("\n\nMain menu\n[1]: View students\n[2]: Add student\n[3]: Search for student\n[4]: Exit program");
		Scanner scan=new Scanner(System.in);
		while(scan.hasNext()){
			int input=scan.nextInt();
			switch(input){
			case(1):
				server.viewAllStudents();
				System.out.println("\n\nMain menu:\n[1]: View students\n[2]: Add student\n[3]: Search for student\n[4]: Exit program");
				break;
			case(2):
				addStudent();
				continue;
			case(3):
				System.out.println("Enter an email: ");
				String email=scan.next();
				if(!server.checkEmail(email)){
					editStudent(email);
				}else{
					System.out.println("email was not found");
					startInput();
				}
				continue;
			case(4):
				System.exit(0);
				
			}
		}
	}
	public static void editStudent(String email){
		StudentService server=new StudentService();
		Scanner scan=new Scanner(System.in);
		String firstName=server.getStudentFirstNameByEmail(email);
		String lastName=server.getStudentLastNameByEmail(email);
		System.out.println("\n\nStudent list editing menu for\n"+firstName+" "+lastName+", email "+email+"\n[1]: Edit student\n[2]: Delete student\n[3]: Return to main menu\n[4]: Exit program");
		while(scan.hasNext()){
			int input=scan.nextInt();
			String fn="";
			String ln="";
			switch(input){
			case(1):
				System.out.println("Enter a new first name:");
				String pattern = "[a-zA-Z]+";
				if(scan.hasNext(pattern)){
					fn=""+scan.next();
				}else{
					System.out.println("incorrect input, use alphanumeric characters");
					editStudent(email);
				}
				System.out.println("Enter a new last name:");
				if(scan.hasNext(pattern)){
					ln=""+scan.next();
				}else{
					System.out.println("incorrect input, use alphanumeric characters");
					editStudent(email);
				}
				server.editStudent(fn, ln, email);
				System.out.println("Name has been changed to "+server.getStudentFirstNameByEmail(email)+" "+server.getStudentLastNameByEmail(email));
				editStudent(email);
				break;
			case(2):
				System.out.println("Confirm deletion of student:\n[1]: Delete\n[2]: Cancel");
				int choice=scan.nextInt();
				if(choice==1){
					server.removeStudent(email);
					startInput();
				}else{
					editStudent(email);
				}
				break;
			case(3):
				startInput();
			case(4):
				System.exit(0);
			}
			
			
		}
	}
	public static void addStudent(){
		StudentService server=new StudentService();
		String fn="";
		String ln="";
		System.out.println("Enter a first name:");
		Scanner scan=new Scanner(System.in);
		String pattern = "[a-zA-Z]+";
		if(scan.hasNext(pattern)){
			fn=""+scan.next();
		}else{
			System.out.println("incorrect input, use alphanumeric characters");
			addStudent();
		}
		System.out.println("Enter a last name:");
		if(scan.hasNext(pattern)){
			ln=""+scan.next();
		}else{
			System.out.println("incorrect input, use alphanumeric characters");
			addStudent();
		}
		System.out.println("Enter an email: ");
		String email=scan.next();
		if(!server.checkEmail(email)){
			System.out.println("Email is already in use, try again");
			startInput();
		}
		System.out.println("Student has been added successfully");
		server.addStudent(fn, ln, email);
		
		startInput();
	}
	public static void main(String[] args) {
		startInput();
	}

}
