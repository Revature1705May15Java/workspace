package com.ex.main;

import java.util.Scanner;

import com.ex.dao.DAO;
import com.ex.dao.IoDAO;
import com.ex.pojos.Student;

public class Main {

	public static void main(String[] args) {
		
		DAO dao = new IoDAO();
		
		Scanner in = new Scanner(System.in);
		
//		System.out.println("Enter student ID:");
//		int id = Integer.parseInt(in.nextLine());
//		System.out.println("Enter student First Name:");
//		String fn=in.nextLine();
//		System.out.println("Enter student Last Name:");
//		String ln=in.nextLine();
//		System.out.println("Enter student Email Address:");
//		String e = in.nextLine();
//		
//		Student temp = new Student(fn, ln, e,id);
//		
//		dao.addStudent(temp);
		
		//dao.getAllStudents();
		
	}
	
	///////////PSEUDO
//	void run{
//		System.out.println("What would you like to do \n"
//				+"1: add user\n"
//				+"2: delete user\n"
//				+"3: update users"
//				+"4: view all");
//	}
	///////////PSEUDO

}

///catch number format exception if the input was a number+" "
