package com.ex.main;

import java.util.Scanner;

import com.ex.dao.DAO;
import com.ex.dao.IoDAO;
import com.ex.pojos.Student;

public class Main {
	
	void run(){
		System.out.println("What would you like to do? \n"
				+ "1: Add user"
				+ "2: delete user"
				+ "3: update user"
				+ "4. view all");
//		switch(1):
//			case(1):
//				break;
		
	}

	public static void main(String[] args){
		
		DAO dao = new IoDAO();
		
//		Scanner in = new Scanner(System.in);
//		System.out.println("Enter Student Id: ");
//		int id = Integer.parseInt(in.nextLine());
//		System.out.println("Enter Student First Name: ");
//		String fn = in.nextLine();
//		System.out.println("Enter Student Last Name: ");
//		String ln = in.nextLine();
//		System.out.println("Enter Student email: ");
//		String em = in.nextLine();
//		
//		Student temp = new Student(fn, ln, em, id);
//		dao.addStudent(temp);
		
		dao.getStudentById(5);
		
	}
}
