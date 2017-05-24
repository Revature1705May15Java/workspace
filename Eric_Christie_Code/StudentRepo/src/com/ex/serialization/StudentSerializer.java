package com.ex.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.ex.pojos.Student;

public class StudentSerializer {
	
	/*
	 * what if this class's constructor took bytestream as a parameter and only allowed 
	 * the creation of one instance for each distinct bytestream filename?
	 * 
	 * could that be considered a singleton serializer for each file or would it be called something else?
	 */
	
	private static final StudentSerializer INSTANCE = new StudentSerializer();
	
	public static StudentSerializer getInstance() { return INSTANCE; }	
	
//	private String byteStream;
	
	private StudentSerializer() {
	}
	
	/**
	 * serializes an ArrayList of Student objects and writes it to a file
	 * @param bytestream
	 * @param students
	 * @return true if the operation was successful, false otherwise
	 */
	public boolean writeStudentsList(String bytestream, ArrayList<Student> students) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(bytestream/*, true*/));) {
			oos.writeObject(students);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * reads an ArrayList of Student objects from a file
	 * @param bytestream
	 * @return the ArrayList that was read from the file, or null if an exception was thrown
	 */
	public ArrayList<Student> readStudentsList(String bytestream) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(bytestream));) {
			@SuppressWarnings("unchecked")
			ArrayList<Student> students = (ArrayList<Student>) ois.readObject(); // how do I check a cast?
			return students;
		} catch (FileNotFoundException e) {
//			e.printStackTrace();
			return null;
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * overwrites the output file and writes one serialized Student object to it
	 * (this method is not very useful)
	 * @param bytestream
	 * @param s
	 * @return true if the operation is successful, false otherwise
	 */
	public boolean writeStudent(String bytestream, Student s) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(bytestream/*, false*/));) {
			oos.writeObject(s);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * iterates over all Student objects, serializing and writing them to the file 
	 * @param bytestream
	 * @param students
	 * @return true if the operation is successful, false otherwise
	 */
	public boolean writeAllStudents(String bytestream, Iterable<Student> students) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(bytestream/*, false*/));) {
			for (Student s: students) {
				oos.writeObject(s);
			}
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * appends a serialized Student object to the end of the file
	 * @param bytestream
	 * @param s
	 * @return true if the operation is successful, false otherwise
	 */
	public boolean appendStudent(String bytestream, Student s) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(bytestream, true));) {
			oos.writeObject(s);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * reads the next Student object from the file
	 * @param bytestream
	 * @return the Student object that is read from the file, or null if an exception was thrown
	 */
	public Student readNextStudent(String bytestream) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(bytestream));) {
			Student s = (Student) ois.readObject();
			System.out.println(s);
			return s;
		} catch (IOException | ClassNotFoundException e) { // this will have to be changed if we want to 
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * reads all Student objects from the file, assuming they were serialized as individual objects
	 * @param bytestream
	 * @return an ArrayList containing all the Student objects in the file, or null if an exception was thrown
	 */
	public ArrayList<Student> readAllStudents(String bytestream) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(bytestream));) {
			ArrayList<Student> result = new ArrayList<Student>();
			int totalBytes = ois.available();
			int remainingBytes = totalBytes;
			System.out.println("Total number of available bytes: " + totalBytes);
			while (remainingBytes > 0) {
				Student s = (Student) ois.readObject();
				result.add(s);
				remainingBytes = ois.available();
				System.out.println("Bytes remaining: " + remainingBytes);
			}
			return result;
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

//	public void main(String[] args) {
//		String bytestream = "src/com/ex/serialization/bytestream2.txt";
//		
//		ArrayList<Student> students = new ArrayList<Student>();
//		for (int i = 0; i < 10; i++) {
//			String fname = "Student" + i;
//			String lname = "S" + i;
//			String email = fname + "." + lname + "@email.com";
//			students.add(new Student(fname, lname, email, i));
//		}
//	}

}
