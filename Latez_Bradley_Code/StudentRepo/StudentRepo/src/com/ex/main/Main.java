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
		String fn, ln, email;
		int id=1000;
		
		Student s = new Student();
		Student s2 = new Student();
		System.out.println("Enter First Name");
		fn = in.nextLine();
		s.setFristName(fn);
		System.out.println("Enter Last Name");
		ln = in.nextLine();
		s.setLastName(ln);
		System.out.println("Enter E-mail");
		email = in.nextLine();
		s.setEmail(email);
		
		s = new Student(fn, ln, email, id);
		System.out.println(s);
		dao.addStudent(s);
		id+=1;
		
		System.out.println("Enter First Name");
		fn = in.nextLine();
		System.out.println("Enter Last Name");
		ln = in.nextLine();
		System.out.println("Enter E-mail");
		email = in.nextLine();
		
		s2 = new Student(fn, ln, email, id);
		System.out.println(s2);
		dao.addStudent(s2);
		id+=1;
		
		dao.getAllStudents();
		System.out.println("----remove------");
		dao.removeStudent("Steve@nice");
		
		System.out.println("steve has been removed");
		dao.getAllStudents();
		
		
		Student s3 = s2;
		System.out.println("joe becomes steve");
		dao.updateStudent("joe@cool", s3);
		System.out.println("--update--");
		dao.getAllStudents();
		
		
		
		
		
		
		
		
		
		
		
		
		//StudentService ss = new StudentService();
//		
//		Student temp1 = new Student("Alan","Barlton","A@Barlton",111);
//		dao.addStudent(temp1);
//		
//		Student temp2 = new Student("Baron","Aloe","removeMe",111);
//		dao.addStudent(temp2);
//
//		String rem="A@Barlton";
//
//		System.out.println();
//		System.out.println(dao.getStudentByEmail(rem));
//		
//		dao.removeStudent("removeMe");
//		
//		System.out.println(dao.getAllStudents());
		
		//System.out.println(dao.getAllStudents());
	}
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

