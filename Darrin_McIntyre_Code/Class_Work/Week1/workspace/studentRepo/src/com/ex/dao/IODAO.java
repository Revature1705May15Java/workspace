package com.ex.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.ex.pojos.Student;

public class IODAO implements DAO{

	static String filename = "src/com/ex/datasource/data.txt"; //data source location path.
	@Override
	public Student addStudent(Student s) {
		int id = s.getId();
		String fname = s.getFirstName(), lname = s.getLastName(), email = s.getEmail();
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true));){ // this will close the bufferedwriter after the block is complete automatically.
			bw.write("" + id + ":" + fname + ":" + lname + ":" + email + "\n"); // if an issue occurs it is because someone edited the txtd file.
			return s;
		} catch (IOException e){
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public boolean removeStudent(Student s) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Student> getAllStudents() {
		ArrayList<Student> students = new ArrayList<Student>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(filename));){
			String line = null; // current line, placeholder.
			
			while((line = br.readLine()) != null){
				String[] curr = line.split(":");
				
				Student temp = new Student();
				temp.setId(Integer.parseInt(curr[0]));
				temp.setFirstName(curr[1]);
				temp.setLastName(curr[2]);
				temp.setEmail(curr[3]);
				
				students.add(temp);
				
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return students;
	}

	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student updateStudent(Student updateStudent) {
		// TODO Auto-generated method stub
		return null;
	}
	
}