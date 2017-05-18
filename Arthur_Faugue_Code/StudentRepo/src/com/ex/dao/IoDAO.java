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
	
	static String filename = "src/com/ex/datasource/data.txt"; // data source file

	@Override
	public Student addStudent(Student s){
		int id = s.getId();
		String fName = s.getFirstName();
		String lName = s.getLastName();
		String email = s.getEmail();
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true));){
			bw.write("" + id + ":" + fName + ":" + lName + ":" + email + "\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return s;
	}

	@Override
	public boolean removeStudent(Student s) {
		return false;
		
	}

	@Override
	public ArrayList<Student> getAllStudents() {
		ArrayList<Student> students = new ArrayList<Student>();
		
		try{
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line = null; //current line place holder
			
			while((line = br.readLine()) != null){
				String[] curr = line.split(":");
				
				Student temp = new Student();
				temp.setId(Integer.parseInt(curr[0]));
				temp.setFirstName(curr[1]);
				temp.setLastName(curr[2]);
				temp.setEmail(curr[3]);
				
				students.add(temp);
				System.out.println(temp.toString());
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			
		}
		return students;
	}

	@Override
	public Student getStudentById(int id) {
		try{
			BufferedReader br = new BufferedReader(new FileReader(filename));
			BufferedReader cr = new BufferedReader(new FileReader(filename));
			String line = null; //current line place holder
			String line2 = cr.readLine(); // next line place holder
			
			while((line = br.readLine()) != null){
				String[] curr = line.split(":");
				
				Student temp = new Student();
				line2 = cr.readLine();
				
				if(Integer.parseInt(curr[0])==id){
					temp.setId(Integer.parseInt(curr[0]));
					temp.setFirstName(curr[1]);
					temp.setLastName(curr[2]);
					temp.setEmail(curr[3]);
					System.out.println(temp.toString());
				}
//				if(line2.isEmpty()){
//					System.out.println("This ID is not used.");
//				}
				
			}
			

			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Student updateStudent(Student updatedStudent) {
		
		return null;
	}

}
