package com.ex.serialize;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.ex.pojos.Student;

public class Serialize {
	
	public static void main(String[] args) {
		String bytestream = "src/com/ex/serialize/bytestream.txt";
		
		Student s = new Student();
		s.setId(0);
		s.setFirstName("Genesis");
		s.setLastName("Bonds");
		s.setEmail("agfkjsgkj");
		
		
		//writeObject(bytestream, s);
		readObject(bytestream);
	}
	
	
	static void writeObject(String bytestream, Object obj){
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(bytestream, true));){
			oos.writeObject(obj);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static Student readObject(String bytestream){
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(bytestream));){
			Object obj = ois.readObject();
			Student s = (Student) obj;
			System.out.println(s.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	

}
