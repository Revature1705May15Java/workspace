import java.util.Scanner;

import dao.DAO;
import dao.IOdao;
import pojos.Student;
import studentService.studentService; 

public class Main 
{
	public static void main(String[] args) 
	{
//		Scanner in = new Scanner(System.in); 
//		DAO dao = new IOdao(); 
		studentService ss = new studentService(); //should be using service instead of dao 
		
//		System.out.println("enter id: ");
//		Integer i = Integer.parseInt(in.nextLine());
//		
//		System.out.println("enter first name: ");
//		String s = in.nextLine(); 
//		
//		System.out.println("enter last name: ");
//		String t = in.nextLine(); 
//		
//		System.out.println("enter email: ");
//		String u = in.nextLine(); 
//		
//		dao.addStudent(new Student(i, s, t, u)); 
		ss.addStudent("gary", "stu","someone@gmail.com"); 
		ss.addStudent("mary","sue","some@email.com");
		
		System.out.println(ss.getAllStudents().toString()); 
		
		System.out.println(ss.removeStudent(new Student(1, " ", " ", " "))); 
		System.out.println(ss.getAllStudents().toString());
	}

	void run()
	{
		studentService service = new studentService(); 
		System.out.println("What do \n" + 
				"1: add student \n" + "2: remove Student \n" +
				"3:update Students \n" + "4:view all \n");
		
		//if remove student == true 
		// print ("student removed successfully")
		// else print ("student not found")
	}
}
