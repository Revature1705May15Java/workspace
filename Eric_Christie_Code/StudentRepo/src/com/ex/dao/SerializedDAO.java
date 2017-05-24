package com.ex.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.ex.exceptions.StudentNotFoundException;
import com.ex.pojos.Student;
import com.ex.serialization.StudentSerializer;

/**
 * This class is currently not in use.
 * @author Eric Christie
 *
 */
public class SerializedDAO implements DAO {
	
	static String filename = "src/com/ex/datasource/serialized-data.txt";
	
	
	private ArrayList<Student> students;
	private StudentSerializer serializer;
	
	SerializedDAO() {
		this.serializer = StudentSerializer.getInstance();
		this.students = getAllStudentsFromFile();
	}

	@Override
	public ArrayList<Student> getAllStudents() {
		return this.students;
	}
	
	@Override
	public Student addStudent(Student s) {
		students.add(s);
		serializer.writeAllStudents(filename, students);
		return s;
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
	public Student getStudent(int id) {
		ArrayList<Student> students = getAllStudents();
		
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
		ArrayList<Student> students = getAllStudents();
		
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
		// might be better to avoid using other methods from this class since most of them read the entire file
		Student old = getStudent(id);
		if (removeStudent(old)) {
			addStudent(updated);
			return old;
		} else {
			throw new StudentNotFoundException("There is no student with id: " + id);
		}
		
	}
	
	@Override
	public Student updateStudent(String email, Student updated) throws StudentNotFoundException {
		// might be better to avoid using other methods from this class since most of them read the entire file
		Student old = getStudent(email);
		if (removeStudent(old)) {
			addStudent(updated);
			return old;
		} else {
			throw new StudentNotFoundException("There is no student with email: " + email);
		}
	}
	
	/**
	 * read in all the Student objects from the file and returns an ArrayList containing them
	 * @return an ArrayList of all the Student objects contained in the file when reading the file
	 * is successful, null otherwise
	 */
	private ArrayList<Student> getAllStudentsFromFile() {
		return serializer.readAllStudents(filename);
	}

	@Override
	public boolean persistAllStudents() {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * check if the students instance variable contains all the Student objects from the file
	 * @return true if all Student objects from the file are in the list of students, false otherwise
	 */
//	private boolean hasAllStudents() {
//		
//	}
	
	/**
	 * check if the students instance variable contains all the Student objects from the file
	 * in the same order as they are in the file
	 * @return true if the list of students contains all the Student objects from the file
	 * in the correct order, false otherwise
	 */
//	private boolean hasCorrectStudentsList() {
//		
//	}
}
