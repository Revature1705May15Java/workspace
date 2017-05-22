package com.rev.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Serialize {

	public static void main(String[] args) {
		String byteStream = "src/com/ex/serialization/bytestream.txt";
		
		Student s = new Student();
		s.setId(0);
		s.setFirstName("first");
		s.setLastName("last");
		s.setEmail("someemail@email.com");
		
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(s);
		
		list.add(new Student(22, "Johnny", "Johns", "email@email.com"));
		
		writeObject(byteStream, list);
		readObject(byteStream);
	}
	
	static void writeObject(String byteStream, Object obj) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(byteStream))) {
			oos.writeObject(obj);
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	@SuppressWarnings("unchecked")
	static void readObject(String byteStream) {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(byteStream))) {
			Object obj = ois.readObject();
			ArrayList<Student> list = (ArrayList<Student>) obj;
			
			for(Student s : list) {
				System.out.println(s.toString());
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
