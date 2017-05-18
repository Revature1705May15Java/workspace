package com.revature.main;

import java.util.Scanner;

import com.revature.dao.ConcreteDAO;
import com.revature.dao.DAO;
import com.revature.pojos.Student;

public class Main 
{

	public static void main(String[] args) 
	{
		//Scanner input = new Scanner(System.in);
		DAO dao = new ConcreteDAO();
		
		/*System.out.println("Enter Student ID: ");
		int id = Integer.parseInt(input.nextLine());
		
		System.out.println("Enter Student First Name: ");
		String fn = input.nextLine();
		
		System.out.println("Enter Student Last Name: ");
		String ln = input.nextLine();
		
		System.out.println("Enter Student Email Address: ");
		String email = input.nextLine();
		
		Student stud1 = new Student(email, fn, ln, id);
		
		dao.addStudent(stud1);*/
		
		//dao.getAllStudents();
		
		dao.removeStudent(7825732);
		//dao.removeStudent(320);
		
		/*void run()
		{
			System.out.println("Choose your options: ");
		}*/
	}
}
