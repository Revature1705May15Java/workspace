package com.rev.main;

import com.rev.dao.DAO;

import java.util.Scanner;

import com.rev.dao.DAO;
import com.rev.dao.IoDAO;
import com.rev.pojo.Student;

public class Main {

	public static void main(String[] args) 
	{
		
		
		//Scanner in = new Scanner(System.in);
		DAO dao = new IoDAO ();
		
/*
		System.out.println("enter Student Id: ");
		int id = Integer.parseInt(in.nextLine());
		
		System.out.println("enter Student firstname: ");
		String fn = in.nextLine();
		
		System.out.println("enter Student lastname: ");
		String ln = in.nextLine();
		
		System.out.println("enter Student email: ");
		String e = in.nextLine();
		
		Student temp = new Student(fn,ln,e,id);
		dao.addStudent(temp);
*/
		
		//dao.getAllStudents();
		
	Student s = dao.getStudentById(2);
		
		boolean b = dao.removeStudent(s);
		
		//System.out.println(b);
		
	//	dao.getAllStudents();
		
		//System.out.println(s);
		
		
	}
	
	void run()
	{
		
		System.out.println("What would you like to do \n"
				+ "1. add user "
				+"2. delete user"
				+ "3. update users"
				+ "4. view all");
	}

}
