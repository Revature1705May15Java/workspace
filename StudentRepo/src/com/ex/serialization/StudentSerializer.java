package com.ex.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.ex.pojos.Student;

public class StudentSerializer {
	
	public static void writeStudent(String bytestream, Student s) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(bytestream/*, false*/));) {
			oos.writeObject(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeAllStudents(String bytestream, Iterable<Student> students) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(bytestream/*, false*/));) {
			for (Student s: students) {
				oos.writeObject(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void appendStudent(String bytestream, Student s) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(bytestream, true));) {
			oos.writeObject(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Student readNextStudent(String bytestream) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(bytestream));) {
			Student s = (Student) ois.readObject();
			System.out.println(s);
			return s;
		} catch (IOException | ClassNotFoundException e) { // this will have to be changed if we want to 
			e.printStackTrace();
			return null;
		}
	}
	
	public static ArrayList<Student> readAllStudents(String bytestream) {
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

	public static void main(String[] args) {
		String bytestream = "src/com/ex/serialization/bytestream2.txt";
		
		ArrayList<Student> students = new ArrayList<Student>();
		for (int i = 0; i < 10; i++) {
			String fname = "Student" + i;
			String lname = "S" + i;
			String email = fname + "." + lname + "@email.com";
			students.add(new Student(fname, lname, email, i));
		}
	}

}
