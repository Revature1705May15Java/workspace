package com.ex.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.ex.dao.DAO;
import com.ex.dao.IoDAO;
import com.ex.pojos.Student;
public class Main {
	static DAO dao = new IoDAO();
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		
//		System.out.println("Enter student Id:");
//		Integer id = Integer.parseInt(in.nextLine());
//		System.out.println("Enter student First Name:");
//		String fn = in.nextLine();
//		System.out.println("Enter student Last Name:");
//		String ls = in.nextLine();
//		System.out.println("Enter student Email:");
//		String e = in.nextLine();
//		
//		Student temp = new Student(fn, ls, e, id);
//		
//		dao.addStudent(temp);
			
		dao.getAllStudents();
		System.out.println("Input ID number");
		Integer id = Integer.parseInt(in.nextLine());
		dao.getStudentById(id);
		in.close();
		
	}
	

}
