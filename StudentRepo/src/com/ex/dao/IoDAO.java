package com.ex.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.ex.exceptions.StudentNotFoundException;
import com.ex.pojos.Student;

// TODO try implementing this class using RandomAccessFile

public class IoDAO implements DAO {
	
	static String filename = "src/com/ex/datasource/data.txt";
	
	/*
	 * The methods below are implemented without serialization using BufferedReader
	 */
	@Override
	public Student addStudent(Student s) {
		int id = s.getId();
		String fName = s.getFirstName();
		String lName = s.getLastName();
		String email = s.getEmail();
		
		// this try with resources block should eliminate the need for a finally block
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true));) {
			bw.write("" + id + ":" + fName + ":" + lName + ":" + email + "\n");
			return s;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean removeStudent(Student s) {
		ArrayList<Student> students = getAllStudents();
		boolean removed = students.remove(s);
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, false));) {
			for (Student student: students) {
				bw.write("" + student.getId() + ":" + student.getFirstName() + ":" + student.getLastName()+ ":" + student.getEmail() + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return removed;
	}

	@Override
	public ArrayList<Student> getAllStudents() {
		ArrayList<Student> students = new ArrayList<Student>();
		try (BufferedReader br = new BufferedReader(new FileReader(filename));) {
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] current = line.split(":");
//				Student temp = new Student();
//				temp.setId(Integer.parseInt(current[0]));
//				temp.setFirstName(current[1]);
//				temp.setLastName(current[2]);
//				temp.setLastName(current[3]);
				Student temp2 = new Student(current[1], current[2], current[3], Integer.parseInt(current[0]));
				students.add(temp2);
				System.out.println();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();			
		}
		return students;
	}

	@Override
	public Student getStudent(int id) {
		try (BufferedReader br = new BufferedReader(new FileReader(filename));) {
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] current = line.split(":");
				if (Integer.parseInt(current[0]) == id) {
					return new Student(current[1], current[2], current[3], Integer.parseInt(current[0]));
				}
			}
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Student getStudent(String email) {
		try (BufferedReader br = new BufferedReader(new FileReader(filename));) {
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] current = line.split(":");
				if (current[3].equals(email)) {
					return new Student(current[1], current[2], current[3], Integer.parseInt(current[0]));
				}
			}
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public Student updateStudent(int id, Student updated) throws StudentNotFoundException {
		Student old = getStudent(id);
		if (removeStudent(old)) {
			addStudent(updated);
			return old;
		} else {
			throw new StudentNotFoundException("There is no student with id: " + id);
		}
		
	}
	
	public Student updateStudent(String email, Student updated) throws StudentNotFoundException {
		Student old = getStudent(email);
		if (removeStudent(old)) {
			addStudent(updated);
			return old;
		} else {
			throw new StudentNotFoundException("There is no student with email: " + email);
		}
	}

}
