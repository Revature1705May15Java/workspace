package com.ex.serialization;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.ex.pojos.Student;

public class Serialize {
	public static void main(String[] args) {
		String bytestream = "src/com/ex/serialization/bytestream.txt";
		
		ArrayList<Student> students = new ArrayList<Student>();
		Student s = new Student("John", "Doe", "johndoe@gmail.com", 1);
		Student s2 = new Student("Jane", "Doe", "janedoe@gmail.com", 2);
		students.add(s);
		students.add(s2);
		//writeObjects(bytestream, students);
		readAllObjects(bytestream);
	}
	
//	/*
//	 * Serialize an object to a file using a bytestream
//	 */
//	public static void writeObject(String bytestream, Object obj) {
//		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(bytestream, true));) {
//			oos.reset();
//			oos.writeObject(obj);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	
	/*
	 * Serialize an object to a file using a bytestream
	 */
	public static void writeObjects(String bytestream, ArrayList<Student> students) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(bytestream, true));) {
			for (Student student : students)
				oos.writeObject(student);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * Deserialize an object from the byte file.
	 */
	public static Student readObject(String bytestream) {
		try (ObjectInputStream oia = new ObjectInputStream(new FileInputStream(bytestream));) {
			Object obj = oia.readObject();
			Student s = (Student) obj;
			//System.out.println(s);
			return s;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static ArrayList<Student> readAllObjects(String bytestream) {
		ArrayList<Student> students = new ArrayList<Student>();
		try (ObjectInputStream oia = new ObjectInputStream(new FileInputStream(bytestream));) {
			Object obj = null;
			while ((obj = oia.readObject()) != null) {
				students.add((Student) obj);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EOFException e) {

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		students.forEach(s->System.out.println(s));
		return students;
	}
}
