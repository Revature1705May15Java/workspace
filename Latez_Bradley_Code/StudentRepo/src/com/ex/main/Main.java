package com.ex.main;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.ex.dao.DAO;
import com.ex.dao.IoDAO;
import com.ex.pojos.Student;

class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		DAO dao = new IoDAO();
		
		
		/**
		System.out.println("Enter Student ID: ");
		int id = Integer.parseInt(in.nextLine());
		System.out.println("Enter Student First Name: ");
		String fn = in.nextLine();
		System.out.println("Enter Student Last Name: ");
		String ln = in.nextLine();
		System.out.println("Enter Student Email Address: ");
		String e = in.nextLine();
		*/
		//Student temp = new Student(fn, ln, e, id);
		//Student temp2 = new Student("Alan","Barlton","A@Barlton",111);
		//dao.addStudent(temp);
		/**
		Student temp2 = new Student("Alan","Barlton","A@Barlton",111);
		dao.addStudent(temp2);
		temp2 = new Student("Blake","Doolam","B@Doolam",222);
		dao.addStudent(temp2);
		temp2 = new Student("Carl","Elder","C@Elder",333);
		dao.addStudent(temp2);
		temp2 = new Student("Duke","Marnfo","D@Marnfo",444);
		dao.addStudent(temp2);
		*/
		
		dao.getAllStudents();
		ArrayList <Student> s = new ArrayList();
		s = dao.getAllStudents();
	
		//System.out.println((String)s.get(4));
		//String line = s.get(0);
		System.out.println(s.contains(222));
		
		dao.getStudentById(111, s);
		
		

		
		
		
		
	}
	/**
	void run(){
		System.out.println("What would you like to do \n"
				+ "1: add user"
				+"2:delete user"
				+"3 update users"
				+"4 view all");
		
		switch(input):
			case(1):
				addUser();
			case(2):
				
		
		}
*/
}
