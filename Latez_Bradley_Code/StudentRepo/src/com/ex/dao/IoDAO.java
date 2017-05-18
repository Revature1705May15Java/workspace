package com.ex.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.ex.pojos.Student;

public class IoDAO implements DAO {
	
	String filename = "src/com/ex/datasource/data.txt";

	@Override
	public Student addStudent(Student s) {
		int id = s.getId();
		String fName = s.getFristName();
		String lname = s.getLastName();
		String email = s.getEmail();
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))){//True @param enables append capabilities
			bw.write(""+id+":"+fName+":"+lname+":"+email +"\n");
			return s;
		}
		catch(IOException e){
			e.printStackTrace();
		return null;
		}
		// TODO Auto-generated method stub
		//return false;
	}

	@Override
	public boolean removeStudent(Student s) {
		/*
		 * 
		 */
		// TODO Auto-generated method stub
		ArrayList <Student> s1 = new ArrayList();
		String line=null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			
			while(br.readLine()!=null){
				String [] sa = 
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ArrayList<Student> getAllStudents() {
		// TODO Auto-generated method stub
		ArrayList<Student> students = new ArrayList<Student>();
		
			try {
				BufferedReader br = new BufferedReader(new FileReader(filename));
				String line = null;
				int count=0;
				
				while((line = br.readLine())!=null){
					String[] curr = line.split(":");
					
					Student temp = new Student();
					temp.setId(Integer.parseInt(curr[0]));
					temp.setFristName(curr[1]);
					temp.setLastName(curr[2]);
					temp.setEmail(curr[3]);
					
					students.add(temp);
					System.out.println(temp);
					System.out.println(line);
					//count++;
					//System.out.println(count);
				}
				
				
			}
			catch(FileNotFoundException e){
				e.printStackTrace();
				
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		
		
		return students;
	}

	@Override
	public Student getStudentById(int id, ArrayList <Student> a)  {
	
		
			for(Student s:a){
				if(id == s.getId())
					System.out.println(""+s);			
			}			
		
		return null;
	}

	@Override
	public Student updateStudent(int id, ArrayList<Student> a,String fn, String ln, String em) {
		
		Student s = getStudentById(id, a);
			if(id == s.getId())
				s.setEmail(em);
				s.setFristName(fn);
				s.setLastName(ln);
				System.out.println("Updated Student:"+s);			
		
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student updateStudent(Student updatedStudent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student getStudentById(int id) throws FileNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student updateStudent(int id, Student updatedStudent) {
		
		return null;
	}

	@Override
	public Student updateStudent(int id, ArrayList<Student> a) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

	

}
