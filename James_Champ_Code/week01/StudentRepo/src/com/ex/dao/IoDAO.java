package com.ex.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.ex.pojos.Student;

// TODO: Add comments.
public class IoDAO implements DAO {
	private static final String STUDENT_FILE_NAME = "src/com/ex/datasource/data.txt";
	
	@Override
	public Student addStudent(Student s) {
		int id = s.getId();
		String firstName = s.getFirstName();
		String lastName = s.getLastName();
		String email = s.getEmail();
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(STUDENT_FILE_NAME, true))) {
			bw.write("" + id + ":" + firstName + ":" + lastName + ":" + email + "\n");
		} 
		catch (IOException e) {
			e.printStackTrace();
			return null;
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
		
		try(BufferedReader br = new BufferedReader(new FileReader(STUDENT_FILE_NAME))) {
			String line;
			while((line = br.readLine()) != null) {
				String[] current = line.split(":");
				Student temp = new Student();
				
				temp.setId(Integer.parseInt(current[0]));
				temp.setFirstName(current[1]);
				temp.setLastName(current[2]);
				temp.setEmail(current[3]);
				
				students.add(temp);
			}
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return students;
	}

	@Override
	public Student getStudentById(int id) {
		return null;
	}

	@Override
	public Student updateStudent(Student updatedStudent) {
		return null;
	}

	public boolean removeAllStudents() {
		File dataFile = new File(STUDENT_FILE_NAME);
		dataFile.delete();
		
		try {
			dataFile.createNewFile();
		} 
		catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
}
