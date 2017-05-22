package com.ex.dao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.ex.exceptions.StudentNotFoundException;
import com.ex.pojos.Student;
import com.ex.serialization.StudentSerializer;

// TODO try implementing this class using RandomAccessFile
// TODO use a class that implements Set instead of an ArrayList

public class IoDAO implements DAO {
	
	static String filename = "src/com/ex/datasource/data.txt";
	static String bytestream = "src/com/ex/datasource/serialized-data.txt";
	
	private StudentSerializer serializer;
	private ArrayList<Student> students;
	
	public IoDAO() {
		this.serializer = StudentSerializer.getInstance();
		this.students = deserializeStudentsList();
		for (Student s: students) {
			writeStudent(s);
		}
	}
	
	/**
	 * serialize the ArrayList of Student objects and write it to a file
	 * @return false is an exception is thrown, true otherwise
	 */
	private boolean serializeStudentsList() {
		return serializer.writeStudentsList(bytestream, students);
	}
	
	/**
	 * read in all the Student objects from the file and returns an ArrayList containing them
	 * (This method should only be used in the constructor to initialize the students list)
	 * @return an ArrayList of all the Student objects contained in the file when reading the file
	 * is successful, or an empty ArrayList if serializer.readStudentsList() returns null
	 */
	private ArrayList<Student> deserializeStudentsList() {
		ArrayList<Student> result = serializer.readStudentsList(bytestream);
		if (result == null) {
			return new ArrayList<Student>();
		} else {
			return result;
		}
	}

	@Override
	public ArrayList<Student> getAllStudents() {
		// if the students instance variable always matches the students in data.txt, this should be fine
		return this.students;
	}
	
	@Override
	public boolean persistAllStudents() {
		return serializeStudentsList();
	}
	
	@Override
	public Student addStudent(Student s) {
		students.add(s);
		return writeStudent(s) ? s : null;
	}
	
	@Override
	public boolean removeStudent(Student s) throws StudentNotFoundException {
		boolean removed = students.remove(s);
		if (!removed) {
			throw new StudentNotFoundException("Could not find " + s.toString());
		}
		for (Student stu: students) {
			writeStudent(stu);
		}
		return removed;
	}

	@Override
	public Student getStudent(int id) throws StudentNotFoundException {
		for (Student s: students) {
			if (s.getId() == id) {
				return s;
			}
		}
		throw new StudentNotFoundException("There is no student with id = " + id);
//		return null;
	}

	@Override
	public Student getStudent(String email) throws StudentNotFoundException {
		for (Student s: students) {
			if (s.getEmail().equals(email)) {
				return s;
			}
		}
		throw new StudentNotFoundException("There is no student with email = " + email);
//		return null;
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
	
	@Override
	public Student updateStudent(String email, Student updated) throws StudentNotFoundException {
		Student old = getStudent(email);
		if (removeStudent(old)) {
			addStudent(updated);
			return old;
		} else {
			throw new StudentNotFoundException("There is no student with email: " + email);
		}
	}
	
	/**
	 * write a single Student object to data.txt
	 * @param s
	 * @return true if successful, false if an exception is thrown
	 */
	private boolean writeStudent(Student s) {
		int id = s.getId();
		String fName = s.getFirstName();
		String lName = s.getLastName();
		String email = s.getEmail();
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true));) {
			bw.write("" + id + ":" + fName + ":" + lName + ":" + email + "\n");
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
