package com.ex.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ex.pojos.Student;
import com.ex.service.StudentService;

public class IoDAO implements DAO {

	static String fileName = "src/com/ex/datasource/data.txt"; // data source
															// location

	@Override
	public Student addStudent(Student s) {
		int id = s.getId();
		String fName = s.getFirstName();
		String lName = s.getLastName();
		String email = s.getEmail();

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) { // true
																						// param
																						// enables
																						// append
																						// capability
			bw.write("" + id + ":" + fName + ":" + lName + ":" + email + "\n");
			return s;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public boolean removeStudent(String email) {
		List<Student> studentList = getAllStudents();
		boolean removed = false;	
		for(Student s: studentList){
				if(email.equals(s.getEmail())){
					studentList.remove(s);
					removed = true;
					break;
				}
			}
			
		if(removed){
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));){
				for(Student s: studentList){
					bw.write("" + s.getId() + ":" + s.getFirstName() + ":" + s.getLastName() + ":" + s.getEmail() + "\n");
				}
			}catch (IOException e) {
				e.printStackTrace();
				
			}

		}
		
			return removed;
			
		
		
	}

	@Override
	public ArrayList<Student> getAllStudents() {
		ArrayList<Student> students = new ArrayList<Student>();
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileName,true));
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line = null; // current line - placeholder

			while ((line = br.readLine()) != null) {
				String[] curr = line.split(":");

				Student temp = new Student();
				temp.setId(Integer.parseInt(curr[0]));
				temp.setFirstName(curr[1]);
				temp.setLastName(curr[2]);
				temp.setEmail(curr[3]);

				students.add(temp);
				

			}
			br.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
		}
		return students;
	}

	@Override
	public boolean updateStudent(Student updateStudent) {
		
		return false;
	}

	

}
