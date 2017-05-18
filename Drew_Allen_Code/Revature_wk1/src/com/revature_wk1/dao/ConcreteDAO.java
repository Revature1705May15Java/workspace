package com.revature_wk1.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.revature_wk1.pojos.Student;

public class ConcreteDAO implements DAO
{
	
	static String filename = "src/com/revature/datasrc/Datr.txt";

	@Override
	public Student addStudent(Student s) {
		int id = s.getId();
		String fName = s.getFname();
		String lName = s.getLname();
		String email = s.getEmail();
		
		try (BufferedWriter buffer = new BufferedWriter(new FileWriter(filename, true));)
		{
			buffer.write("" + id + ":" + fName + ":" + lName + ":" + email + "\n");
			return s;
		} catch (IOException e) 
		{
			e.printStackTrace();
			return null;
		}
	}
	
	/*@Override
	public boolean removeStudent(Student s)
	{
		try
		{
			BufferedReader rmReader = new BufferedReader(new FileReader(filename));
			BufferedWriter rmBuffer = new BufferedWriter(new FileWriter(filename, true));
			
			String line = null;
			
			while((line = rmReader.readLine())!= null)
			{
				if(line.trim().equals(s))
					continue;
				
				rmBuffer.write(line + System.getProperty("line.separator"));
			}
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return false;
	}*/

	@Override
	public void removeStudent(int id) 
	{
		ArrayList<Student> rStudents = new ArrayList<Student>();
		
		try
		{
			BufferedReader rmReader = new BufferedReader(new FileReader(filename));
			//BufferedWriter rmBuffer = new BufferedWriter(new FileWriter(filename, true));
			
			String line = null;
			
			while((line = rmReader.readLine()) != null)
			{
				Student rStudent = new Student();
				String[] nLine = line.split(":");
				
				rStudent.setId(Integer.parseInt(nLine[0]));
				rStudent.setFname(nLine[1]);
				rStudent.setLname(nLine[2]);
				rStudent.setEmail(nLine[3]);
				
				rStudents.add(rStudent);
				
				if(rStudent.getId() == id)
				{
					//rStudent.setId(0);
					/*rStudent.setId(0);
					rStudent.setFname(null);
					rStudent.setLname(null);
					rStudent.setEmail(null);*/
					rStudents.remove(rStudent);
				}
				
				/*rmBuffer.write("" + rStudent.getId() + ":" + rStudent.getFname() + ":" + rStudent.getLname() + ":" + 
				rStudent.getEmail() + "\n");*/
			}
			
			BufferedWriter rmBuffer = new BufferedWriter(new FileWriter(filename));
			int sId = 0;
			String fName, lName, email;
			for(int i = 0; i < rStudents.size(); i++)
			{
				sId = rStudents.get(i).getId();
				fName = rStudents.get(i).getFname();
				lName = rStudents.get(i).getLname();
				email = rStudents.get(i).getEmail();
				
				rmBuffer.write("" + sId + ":" + fName + ":" + lName + ":" + email + "\n");
			}
			
			rmReader.close();
			rmBuffer.close();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<Student> getAllStudents() {
		ArrayList<Student> gStudents = new ArrayList<Student>();
		
		try
		{
			BufferedReader bufferR = new BufferedReader(new FileReader(filename));
			String line = null;
			while((line = bufferR.readLine()) != null)
			{
				String[] str = line.split(":");
				Student s2 = new Student();
				s2.setId(Integer.parseInt(str[0]));
				s2.setFname(str[2]);
				s2.setLname(str[3]);
				s2.setEmail(str[1]);
				
				gStudents.add(s2);
				System.out.println(s2);
			}
		}
		catch (FileNotFoundException e)
		{
			
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return gStudents;
	}

	@Override
	public Student getStudentById(int id) {
		return null;
	}

	@Override
	public Student updateStudent(Student updatedStudent) {
		return null;
	}

}
