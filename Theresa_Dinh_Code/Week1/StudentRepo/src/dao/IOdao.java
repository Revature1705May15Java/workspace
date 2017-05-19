package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import pojos.Student;


//the concrete part of dao that actually does the reading/writing

public class IOdao implements DAO
{
	static String filename = "src/datasource/data";  

	//takes a given student and adds it to the database
	//returns the Student added 
	@Override
	public Student addStudent(Student s) 
	{
		int id = s.getId(); 
		String fName = s.getFirstName(); 
		String lName = s.getLastName(); 
		String email = s.getEmail(); 
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true)))
		{
			bw.write("" + id + ":" +  fName + ":" + lName + ":" 
					+ email + "\n"); 
			return s; 
		} 
		catch(IOException e)
		{
			e.printStackTrace();
			return null; 
		}
	}

	//assumes that IDs will be unique 
	@Override
	public boolean removeStudent(Student s) //done 
	{
		Integer id = s.getId(); 
		//the id to be checked against
		
		try
		{
			//create temp file for copying 
			File temp = new File("src/datasource/temp"); 
			BufferedReader br = new BufferedReader(new FileReader(filename)); 
			BufferedWriter tempW = new BufferedWriter(new FileWriter(temp, false)); // write to temp
			String line = null; //placeholder
			
			while((line = br.readLine()) != null)
			{
				if(line.startsWith(id.toString()))
				{
					continue; //if a match, don't add this student 
				}
				tempW.write(line + "\n"); 
			}
			tempW.close(); 
			
			BufferedReader tempR = new BufferedReader(new FileReader(temp));
			BufferedWriter dataW = new BufferedWriter(new FileWriter(filename, false)); // write contents from temp over to db
			while((line = tempR.readLine()) != null)
			{
				dataW.write(line + "\n");
			}
			
			dataW.close();
			tempR.close();
			br.close();
			
			return true; //to signify student was removed successfully 
		}
		catch(FileNotFoundException e)	
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace(); 
		}
		return false;
	}

	@Override
	public ArrayList<Student> getAllStudents() //done
	{
		ArrayList<Student> students = new ArrayList<Student>(); 
				
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line = null; //current line and placeholder
			
			while((line = br.readLine()) != null)
			{
				String[] current = line.split(":"); 
				Student temp = new Student(); 
				temp.setId(Integer.parseInt(current[0]));
				temp.setFirstName(current[1]);
				temp.setLastName(current[2]);
				temp.setEmail(current[3]);
				
				students.add(temp); 
				//System.out.println(temp.toString());
			}
				
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return students; 
	}
	
	//I don't think I need to do anything for this? 
	// shouldn't be handled by dao but by service class
	@Override
	public Student getStudentById(int id) 
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	//remove old student and then add "updated" student back in 
	@Override
	public Student updateStudent(Student oldS, Student newS)
	{
		if(removeStudent(oldS)) //if removal was successful, add "new" student 
		{
			return addStudent(newS); 
		}
		return null; 
	}

}
