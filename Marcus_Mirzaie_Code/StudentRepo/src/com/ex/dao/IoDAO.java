package com.ex.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.ex.pojos.Student;

public class IoDAO implements DAO{

	static String filename = "src/com/ex/datasource/data.txt"; //data source location
	
	@Override
	public Student addStudent(Student s) {
		int id = s.getId();
		String fName = s.getFirstName();
		String lName = s.getLastName();
		String email = s.getEmail();
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename,true));){
			bw.write("" + id + ":" + fName + ":" + lName + ":" + email + ":\n");
			bw.close();
			return s;
		} catch(IOException e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean removeStudent(Student s) {
		ArrayList<Student> students = getAllStudents();
		boolean success = false;
		try {
			FileWriter fw = new FileWriter(filename,false);fw.close();
			for(Student st: students){
				if(st.getEmail().toLowerCase().equals(s.getEmail().toLowerCase())){
					success = true;
				}
				else{
					addStudent(st);
				}
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return success;	}

	@Override
	public Student updateStudent(Student s) {
		ArrayList<Student> students = getAllStudents();
		try {
			FileWriter fw = new FileWriter(filename,false);fw.close();
			for(Student st: students){
				if(st.getEmail().toLowerCase().equals(s.getEmail().toLowerCase())){
					st = s;
				}
				addStudent(st);
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return s;
	}

	@Override
	public Student getStudentById(int id) {
		ArrayList<Student> students = getAllStudents();
		for(Student s: students){
			if(s.getId() == id)
				return s;
		}
		return null;
	}

	@Override
	public ArrayList<Student> getAllStudents() {
		ArrayList<Student> students = new ArrayList<Student>();
		BufferedReader br = null;
		try{
			br = new BufferedReader(new FileReader(filename));
			String line = null;
			
			while((line = br.readLine())!=null){
				String[] curr = line.split(":");
				
				Student temp = new Student();
				temp.setId(Integer.parseInt(curr[0]));
				temp.setFirstName(curr[1]);
				temp.setLastName(curr[2]);
				temp.setEmail(curr[3]);
				
				students.add(temp);
				//System.out.println(temp);
			}
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		catch(NumberFormatException e){
			e.printStackTrace();
		}
		finally{
			if(br != null)
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
		return students;
	}

	@Override
	public Student getStudentByEmail(String email) {
		ArrayList<Student> students = getAllStudents();
		for(Student s: students){
			if(s.getEmail().toLowerCase().equals(email.toLowerCase()))
				return s;
		}
		return null;
	}

}
