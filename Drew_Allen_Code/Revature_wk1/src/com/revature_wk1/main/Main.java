package com.revature_wk1.main;

import java.util.Scanner;

import com.revature_wk1.dao.DAO;
import com.revature_wk1.pojos.Student;
import com.revature_wk1.serialize.Serialize;
import com.revature_wk1.service.StudentService;

public class Main 
{
	public static void main(String[] args) 
	{
		DAO studentDAO = new StudentService();
		Scanner userInput = new Scanner(System.in);
		String bytestream = "src/com/revature/serialize/bytestream.txt";
		
		System.out.println("Choose an option: " + "\n" + "1: Add Student" + "\n" + "2: Remove Student" + "\n" +
				"3: Update Student" + "\n" + "4: Get All Students" + "\n" + "5: Find Student by ID" + "\n" + "6: Exit");
		String input = userInput.nextLine();
		
		switch(input)
		{
			case ("1"):
				Student nuStudent = new Student();
				System.out.println("Enter student's first name, last name and email address.");
				
				String fir_Name = userInput.nextLine();
				String last_Name = userInput.nextLine();
				String emailAdd = userInput.nextLine();
				int id = Integer.parseInt(input);
				
				nuStudent.setFname(fir_Name);
				nuStudent.setLname(last_Name);
				nuStudent.setEmail(emailAdd);
				nuStudent.setId(id);
				
				studentDAO.addStudent(nuStudent);
				break;
				
			case ("2"):
				System.out.println("Enter the Student you wish to remove with their ID.");
				input = userInput.nextLine();
				id = Integer.parseInt(input);
				
				studentDAO.removeStudent(id);
				break;
			
			case ("3"):
				Student nuStudent1 = new Student();
				System.out.println("Choose a Student to update by their ID.");
				input = userInput.nextLine();
				id = Integer.parseInt(input);
				System.out.println("Enter new Student first name:");
				fir_Name = userInput.nextLine();
				System.out.println("Enter new Student last name: ");
				last_Name = userInput.nextLine();
				System.out.println("Enter new Student email address: ");
				emailAdd = userInput.nextLine();
				
				nuStudent1.setId(id);
				nuStudent1.setFname(fir_Name);
				nuStudent1.setLname(last_Name);
				nuStudent1.setEmail(emailAdd);
				
				studentDAO.updateStudent(nuStudent1);
				break;
				
			case("4"):
				System.out.println("Here are all the Students listed: ");
				studentDAO.getAllStudents();
				break;
			
			case("5"):
				System.out.println("Enter a Student ID to see their information.");
				id = Integer.parseInt(userInput.nextLine());
				
				studentDAO.getStudentById(id);
				break;
			
			case("6"):
				System.out.println("Exiting...");
				userInput.close();
				break;
				
			default:
				break;
		}
		
		Serialize.writeObjs(bytestream, studentDAO.getAllStudents());
		Serialize.readObjs(bytestream);
	}
}
