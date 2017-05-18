package com.ex.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.ex.pojos.Student;

public class Serialize{
	public static void main(String[] args) {
		String bytestream = "src/com/ex/serialization/bytestream.txt";
		
		Student s = new Student();
		s.setId(0);
		s.setFirstName("John");
		s.setLastName("J");
		s.setEmail("John.J@gmail.com");
		readAll(bytestream);
		
	}
	static void writeObject(String bytestream, Object obj) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(bytestream, true))) {
			oos.writeObject(obj);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static Student readObject(String bytestream) {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(bytestream))) {
			Object obj = ois.readObject();
			Student s = (Student) obj;
			System.out.println(s.toString());
	
			
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
	
	static void readAll(String bytestream) {
		Object students = new ArrayList<Student>();
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(bytestream))) {
			students = ois.readObject();
			System.out.println(students.toString());
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
	}
}
