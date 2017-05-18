package com.ex.serialization;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.ex.pojos.Student;

public class Serialize {
	
	public static void main(String[] args) {
		String bytestream = "src/com/ex/serialization/bytestream.txt";
		
//		Student s1 = new Student();
//		s1.setId(1);
//		s1.setFirstName("asdf");
//		s1.setLastName("qwerty");
//		s1.setEmail("a@me.com");
//		
//		Student s2 = new Student();
//		s2.setId(2);
//		s2.setFirstName("richard");
//		s2.setLastName("marquez");
//		s2.setEmail("richie@me.com");
//		
//		ArrayList<Student> students = new ArrayList<>();
//		students.add(s1);
//		students.add(s2);
//		writeObject(bytestream, students);
		
		ArrayList<Student> students = (ArrayList<Student>) readObject(bytestream);
		
		for (Student s : students) {
			System.out.println(s);
		}
	}

	static void writeObject(String bytestream, Object obj) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(bytestream))) {
			oos.writeObject(obj);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static Object readObject(String bytestream) {
		Object obj = null;
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(bytestream))) {
			obj = ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return obj;
	}
}
