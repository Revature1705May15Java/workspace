import java.util.Scanner;

import dao.DAO;
import dao.IOdao;
import pojos.Student;
import studentService.StudentService; 

public class Main 
{
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in); 
//		DAO dao = new IOdao(); 
		StudentService ss = new StudentService(); //should be using service instead of dao 
		
//		ss.addStudent("gary", "stu","someone@gmail.com"); 
//		ss.addStudent("mary","sue","some@email.com");
		
//		System.out.println(ss.getAllStudents().toString()); 
		
//		System.out.println(ss.removeStudent(new Student(1, " ", " ", " "))); 
//		System.out.println(ss.getAllStudents().toString());
		
		new Main().run(in); 
	}

	void run(Scanner in)
	{
//		Scanner in = in; 
		StudentService service = new StudentService(); 
		System.out.println("What would you like to do? \n" + 
				"1: Add a Student \n" + "2: Remove a Student \n" +
				"3: Update a Student \n" + "4: View all Students \n");
		System.out.println("Enter a number to choose \n Or enter QUIT to exit");
		
		String userChoice = in.nextLine(); 
		while(!userChoice.equalsIgnoreCase("quit"))
		{
			switch(userChoice)
			{
				case("1"):
				{
					System.out.println("Please enter the first name");
					String fName = in.nextLine(); 
					System.out.println("Please enter the last name");
					String lName = in.nextLine(); 
					System.out.println("Please enter the email"); 
					String email = in.nextLine(); 
					Student s = service.addStudent(fName, lName, email); 
					if(s == null)
					{
						System.out.println("Student not added. \n "
								+ "Please make sure all information is correct "
								+ "and the email has not previously been used."); 
					}
					else
						System.out.println("Student added. Thank you");
					System.out.println("Enter a number to choose \n Or enter QUIT to exit");
					System.out.println("1: Add a Student \n" + "2: Remove a Student \n" +
							"3: Update a Student \n" + "4: View all Students \n");
					userChoice = in.nextLine(); 
					break; 
				}
				case("2"):
				{
					System.out.println("Please enter the first name");
					String fName = in.nextLine(); 
					System.out.println("Please enter the last name");
					String lName = in.nextLine(); 
					System.out.println("Please enter the email"); 
					String email = in.nextLine(); 
					System.out.println("Please enter the ID");
					int id = Integer.parseInt(in.nextLine()); 
					boolean s = service.removeStudent(new Student(id, fName, lName, email)); 
					if(s == false)
					{
						System.out.println("Student not removed. \n "
								+ "Please make sure all information is correct"); 
					}
					else
						System.out.println("Student removed. Thank you");
					System.out.println("Enter a number to choose \n Or enter QUIT to exit");
					System.out.println("1: Add a Student \n" + "2: Remove a Student \n" +
							"3: Update a Student \n" + "4: View all Students \n");
					userChoice = in.nextLine(); 
					break; 
				}
				case("3"):
				{
					System.out.println("Please enter the first name");
					String fName = in.nextLine(); 
					System.out.println("Please enter the last name");
					String lName = in.nextLine(); 
					System.out.println("Please enter the email"); 
					String email = in.nextLine(); 
					System.out.println("Please enter the ID");
					int id = Integer.parseInt(in.nextLine()); 
					
					System.out.println("Please enter the updated name for this student \n"
							+ "Please enter the first name");
					String fNewName = in.nextLine(); 
					System.out.println("Please enter the last name");
					String lNewName = in.nextLine(); 
					
					Student s = service.updateStudent(new Student(id, fName, lName, email), 
							new Student(id, fNewName, lNewName, email));
					if(s == null)
					{
						System.out.println("Student not updated. \n "
								+ "Please make sure all information is correct"); 
					}
					else
						System.out.println("Student updated. Thank you");
					System.out.println("Enter a number to choose \n Or enter QUIT to exit");
					System.out.println("1: Add a Student \n" + "2: Remove a Student \n" +
							"3: Update a Student \n" + "4: View all Students \n");
					userChoice = in.nextLine(); 
					break; 
				}
				case("4"):
				{
					System.out.print("Now printing the full list of students \n" + service.getAllStudents().toString());
					System.out.println("1: Add a Student \n" + "2: Remove a Student \n" +
							"3: Update a Student \n" + "4: View all Students \n");
					System.out.println("Enter a number to choose \n Or enter QUIT to exit");
					userChoice = in.nextLine();
					break; 
				}
				default: 
				{
					System.out.println("Input not recognized. Please enter a valid input.");
					System.out.println("1: Add a Student \n" + "2: Remove a Student \n" +
							"3: Update a Student \n" + "4: View all Students \n");
					System.out.println("Enter a number to choose \n Or enter QUIT to exit");
					userChoice = in.nextLine(); 
					break; 
				}
			}
		}
		System.out.println("Thank you for using this service.");
	}
}
