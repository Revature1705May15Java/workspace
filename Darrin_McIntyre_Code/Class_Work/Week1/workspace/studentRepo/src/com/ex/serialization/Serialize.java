package com.ex.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.ex.pojos.Student;

public class Serialize {
	public static void main(String[] args) {
		String bytestream = "src/com/ex/serialization/bytestream.txt";
		
		Student s = new Student();
		s.setId(0);
		s.setFirstName("Michael");
		s.setLastName("Someguy");
		s.setEmail("email.cat@email.com");
		
		//writeObject(bytestream, s);
		//readObject(bytestream);
		readAllObjects(bytestream);
	}
	
	public static void writeObject(String bytestream, Object Obj){
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(bytestream))){
			oos.writeObject(Obj);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Student readObject(String bytestream){
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(bytestream))){
			Object obj = ois.readObject();
			Student s = (Student) obj;
			System.out.println(s.toString());

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	public static Student readAllObjects(String bytestream){
		boolean nextObject = true;
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(bytestream))){
			while(nextObject){
				Object obj = ois.readObject();
				Student s = (Student) obj;
				System.out.println(s.toString());
				if(obj == null) nextObject = false;
				System.out.println("Here!");
			} 
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
