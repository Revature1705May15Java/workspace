package com.rev.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.rev.pojo.Student;

public class IoDAO implements DAO
{
	
	static String filename = "src/com/rev/dataSource/data.txt";
	static String tempFilename = "src/com/rev/dataSource/tempData.txt";// data source location

	@Override
	public Student addStudent(Student s) {
		
		//gets the parts of the student and assigns them to varivles
		int id = s.getId();
		String fname = s.getFirstName();
		String lname = s.getLastName();
		String email = s.getEmail();
		
		
		//writes varibles to file with a seperator
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename,true)))
		{
			bw.write(""+id + ":" + fname + ":"  + lname + ":" + email+"\n");
			return s;
		}catch (IOException e){
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean removeStudent(Student s)
	{
		
		
		return false;
	}

	@Override
	public ArrayList<Student> getAllStudents() {
		
		//array list used to store and return all students
		ArrayList<Student> students = new ArrayList<Student>();
		
		try{
			
			//set up reader and string that holds current line
			BufferedReader br = new BufferedReader (new FileReader(filename));
			String line = null;
			
			while((line = br.readLine()) != null)
			{
				
				//creates student object based on current line info
				String[] curr = line.split(":");
				Student temp = new Student ();
				
			
				temp.setId(Integer.parseInt(curr[0]));
				temp.setFirstName(curr[1]);
				temp.setLastName(curr[2]);
				temp.setEmail(curr[3]);
				
				//adds the built object to the array
				students.add(temp);
				System.out.println(temp.toString());
				
				
			}
			
		}catch (FileNotFoundException e){
			e.printStackTrace();
			
		}catch(IOException e){
			e.printStackTrace();
		}
		
		
		return students;
	}

	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		
		//student object to hold values and return
		Student s = new Student();
		
		//goes through file and temporarily stores current line as student object
		try{
			
			
			BufferedReader br = new BufferedReader (new FileReader(filename));
			String line = null;
			
			while((line = br.readLine()) != null)
			{
				String[] curr = line.split(":");
				
				s.setId(Integer.parseInt(curr[0]));
				s.setFirstName(curr[1]);
				s.setLastName(curr[2]);
				s.setEmail(curr[3]);
				
				//when id is found in current line, it stops searching
				if(s.getId()==id)
					break;
				
			}
			
		}catch (FileNotFoundException e){
			e.printStackTrace();
			
		}catch(IOException e){
			e.printStackTrace();
		}
		
		
		return s;
	}

	@Override
	public Student updateStudent(Student updateStudent) {
		// TODO Auto-generated method stub
		return null;
	}

}
