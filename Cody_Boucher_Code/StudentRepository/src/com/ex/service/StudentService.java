package com.ex.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.ex.dao.DAO;
import com.ex.dao.IoDAO;
import com.ex.pojos.Student;


public class StudentService {
	static String filename = "src/com/ex/datasource/data.txt";
	DAO dao = new IoDAO();

	public void addStudent() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter student Id: ");
		int id = Integer.parseInt(scan.nextLine());
		System.out.println("Enter student first name: ");
		String fn = scan.nextLine();
		System.out.println("Enter student last name: ");
		String ln = scan.nextLine();
		System.out.println("Enter student email address: ");
		String e = scan.nextLine();
		scan.close();
		Student temp = new Student(fn, ln, e, id);
		temp = dao.addStudent(temp);
	}
	
	//create student object taking in 3 params
	//fn, ln, email
	//service layer handes the functionality of getting the most recently used ID and assigning the new student the next value
	//accept unique email address
	
	//temp.setId(Integer.parseInt(curr[0]));
	
	public Student getStudent(int id) {
		ArrayList<Student> students = new ArrayList<Student>();
		students = dao.getAllStudents();
		Iterator<Student> itr = students.iterator();
		while(itr.hasNext()) {
			Student student = itr.next();
			if(student.getId() == (id)) {
				System.out.println(student);
				return student;
			}
		}
		System.out.println("Student not found!");
		return null;
	}
	
	public void getStudents() {
		System.out.println("Printing Students");
		ArrayList<Student> students = new ArrayList<Student>();
		students = dao.getAllStudents();
		for(Student s : students) {
			System.out.println(s.toString());
		}
	}
	
	public void removeStudent(int id) {
//		ArrayList<Student> students = new ArrayList<Student>();
//		students = dao.getAllStudents();
//	//	System.out.println(students.toString());
//		Iterator<Student> itr = students.iterator();
//		while(itr.hasNext()) {
//			Student student = itr.next();
//			if(student.getId() == (id)) {
//				itr.remove();
//				//System.out.println("removing");
//				//System.out.println(students.toString());
//			}
//			try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))) {
//				bw.write(student.toString());
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		
		//students = dao.getAllStudents();
		//System.out.println(students.toString());
		
		ArrayList<Student> students = new ArrayList<Student>();
		ArrayList<Student> temp = new ArrayList<Student>();
		students = dao.getAllStudents();
		for (Student s : students) {
			if(s.getId() != id) {
				temp.add(s);
			}
		}
		dao.pushChanges(temp);
		System.out.println("Student Removed");
	}
}	
	

