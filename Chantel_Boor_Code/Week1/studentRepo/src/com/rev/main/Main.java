package com.rev.main;


import java.util.InputMismatchException;
import java.util.Scanner;
import com.rev.dao.IoDAO;
import com.rev.pojo.Student;
import com.rev.service.StudentService;

public class Main {

	public static void main(String[] args) 
	{

		run();
		
	}
	
	static void run()
	{
		
		Scanner in = new Scanner(System.in);
		StudentService ss = new StudentService ();
		boolean c = true;
		
		//runs till user wishes to stop
		while(c)
		{
			//used for menu choice
			int select = 0;
			
			//used to store input data
			String f;
			String l;
			String e;
			
			
			//base menu
			System.out.println("What would you like to do \n"
					+ "1. add user \n "
					+"2. delete user \n"
					+ "3. update users \n"
					+ "4. view all \n"
					+ "5. Find by Email");
			
			try
			{
				select = in.nextInt();
			}catch(InputMismatchException e1)
			{
				select = 0;
			}
			
			//prepares reader
			in.nextLine();
			
			//brings up sub menu based on choice
			switch(select)
			{
			
			case 1:
			{
				//tells if user is added
				boolean added;
				
				//user input
				System.out.println("Enter First Name ");
				f = in.nextLine();
				System.out.println("Enter Last Name ");
				l = in.nextLine();
				System.out.println("Enter Email ");
				e = in.nextLine();
				
				added = ss.addStudent(f, l, e);
				
				if(added)
				{
					System.out.println("Student added!");
				}
				else
				{
					System.out.println("Repeat email address. Student not added.");
				}
				
				
				break;
			}
			case 2:
			{
				//used to tell user if deleted
				boolean deleted = false;
				
				
				System.out.println("Enter email of student you wish to remove");
				e = in.nextLine();
				
				deleted = ss.RemoveStudent(e);
				
				if(deleted)
				{
					System.out.println("Student Removed!");
				}
				else
				{
					System.out.println("Email address not found. Student not removed.");
				}
				
				break;
			}
			case 3:
			{
				//for printing update
				Student up = new Student();
				
				
				//for menu
				int choice;
				boolean update = false;
				
				System.out.println("Enter email of student you wish to update");
				e = in.nextLine();
				
				System.out.println("What would you like to do \n"
						+ "1. Update first name "
						+"2. Update last name");
				
				
				try
				{
					choice = in.nextInt();
				}catch(InputMismatchException e1)
				{
					choice = 0;
				}
				
				//prepares reader
				in.nextLine();
				
				switch(choice)
				{
				case (1):
				{
					System.out.println("Enter Student's first name");
					f = in.nextLine();
					
					up = ss.updateStudent(e, f, choice);
					update = true;
					break;
				}
				case (2):
				{
					System.out.println("Enter Student's last name");
					l = in.nextLine();
					
					up = ss.updateStudent(e, l, choice);
					update = true;
				}
				default:
				{
					System.out.println("Invalid input, please enter 1 or 2");
					break;
				}
				}
						
				if(update)
				{
					System.out.println("Student updated \n" + up);
				}
				else
				{
					System.out.println("Email not found. Could not update.");
				}
				
				break;
			}
			case 4:
			{
				ss.getStudents();
				
				break;
			}
			case 5:
			{
				boolean found = false;
				
				System.out.println("Enter the email of the student you wish to find.");
				
				e = in.nextLine();
				found = ss.findByEmail(e);
				
				if(!found)
				{
					System.out.println("Email not found.");
				}
				
				break;
			}
			default:
			{
				System.out.println("Invalid input, please enter a number 1-3");
			}
			}
			
			System.out.println("Anything else? \n" +
					"1. yes \n" +
					"2. no \n");
			 
			try
			{
				select = in.nextInt();
			}catch(InputMismatchException e2)
			{
				select = 0;
			}
			
			if(select == 2)
				c = false;
		}
		
		in.close();
		ss.serialize();
	}

}
