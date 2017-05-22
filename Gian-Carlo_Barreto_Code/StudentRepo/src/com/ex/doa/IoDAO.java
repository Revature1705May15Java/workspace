package com.ex.doa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.ex.pojos.Student;

public class IoDAO implements DAO {
	static String filename = "src/com/ex/datasource/data.txt";  // data source location

	@Override
	/*
	 * Adds a Student to a file
	 */
	public Student addStudent(Student s) {
		int id = s.getId();
		String fname = s.getFirstName();
		String lname = s.getLastName();
		String email = s.getEmail();
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true));) {
			bw.write("" + id + ":" + fname + ":" + lname + ":" + email + "\n");
			return s;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	

	@Override
	/**
	 * Removes a student
	 * @param email
	 * @return true if removed, false otherewise
	 */
	public boolean removeStudent(String email) {
		ArrayList<Student> students = getAllStudents();
		boolean removed = false;
		for (Student student : students) {
			if (email.equals(student.getEmail())) {
				students.remove(student);
				removed = true;
				break;
			}
		}
		
		if (removed) {
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename));) {
				for (Student student : students) {
					writer.write("" + student.getId() + ":" + student.getFirstName() + ":" 
								 + student.getLastName() + ":" + student.getEmail() + "\n");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return removed;
	}

	@Override
	/*
	 * Get a list of students
	 * @return list of all students
	 */
	public ArrayList<Student> getAllStudents() {
		// Create an empty ArrayList that will hold Students
		ArrayList<Student> students = new ArrayList<Student>();
		
		// Uses a try-with resource to write a Student to a file
		try (BufferedReader br = new BufferedReader(new FileReader(filename));){
			String line = null;  // current line - placeholder
			
			while ((line = br.readLine()) != null) {
				String[] curr = line.split(":");
				Student temp = new Student();
				temp.setId(Integer.parseInt(curr[0]));
				temp.setFirstName(curr[1]);
				temp.setLastName(curr[2]);
				temp.setEmail(curr[3]);
				
				students.add(temp);
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return students;
	}
	
	@Override
	/**
	 * Updates a student's information
	 * @param updatedStudent
	 * @return the updated Student
	 */
	public Student updateStudent(Student updatedStudent) {
		ArrayList<Student> students = getAllStudents();
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getEmail().equals(updatedStudent.getEmail())) {
				students.set(i, updatedStudent);
			}
		}
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename));) {
			for (Student student : students) {
				writer.write("" + student.getId() + ":" + student.getFirstName() + ":" 
							 + student.getLastName() + ":" + student.getEmail() + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return updatedStudent;
	}
	
	/**
	 * Update a Student's email
	 * @param updatedStudent
	 * @param email
	 * @return the updated student
	 */
	public Student updateStudentByEmail(Student updatedStudent, String email) {
		ArrayList<Student> students = getAllStudents();
		for (int i = 0; i < students.size(); i++) {
			if (email.equals(students.get(i).getEmail())) {
				students.set(i, updatedStudent);
			}
		}
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename));) {
			for (Student student : students) {
				writer.write("" + student.getId() + ":" + student.getFirstName() + ":" 
							 + student.getLastName() + ":" + student.getEmail() + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return updatedStudent;
	}

	@Override
	public Student getStudentByEmail(String email) {
		// TODO Auto-generated method stub
		ArrayList<Student> students = getAllStudents();
		for (Student s : students) {
			if (email.equals(s.getEmail())) 
				return s;
		}
		return null;
	}
}
