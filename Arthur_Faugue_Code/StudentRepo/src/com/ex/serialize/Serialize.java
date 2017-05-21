package com.ex.serialize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.ex.pojos.Student;

public class Serialize {
	public static void main(String[] args) {
		
		String bytestream = "src/com/ex/serialize/bytestream.txt";
		ArrayList<Student> arr = new ArrayList<Student>();
		
		//Initialize an example Student object.
		Student s = new Student();
		s.setId(0);
		s.setFirstName("Art");
		s.setLastName("F");
		s.setEmail("a@aol.com");
		arr.add(s);
		
		//Used to convert the Student file to a byte stream then back
		writeObject(bytestream, arr);
		readObjectArray(bytestream);
	}
	
	/*
	 * Given an object this method will print to the bytestream.txt
	 * file the serialized representation of the given object.
	 */
	public static void writeObject(String bytestream, Object obj){
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(bytestream));){
			oos.writeObject(obj);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Given an ArrayList of Student objects this method will print to the bytestream.txt
	 * file the serialized representation of the given ArrayList.
	 */
	public static void writeObject(String bytestream, ArrayList<Student> obj){
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(bytestream));){
			
			//Writes all objects in the array
			oos.writeObject(obj);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Returns an un-serialized Students object from the serialized bytestream.txt file
	 * and prints it out to the console
	 */
	public static Student readObject(String bytestream){
		Student s = null;
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(bytestream));) {
			Object obj = ois.readObject();
			s = (Student) obj;
			System.out.println(s.toString());
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return s;
	}
	
	/*
	 * Returns an un-serialized ArrayList of Students from the serialized bytestream.txt file
	 * and prints it out to the console
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<Student> readObjectArray(String bytestream){
		ArrayList<Student> byt= null;
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(bytestream));){
			byt = (ArrayList<Student>) ois.readObject();
			System.out.println(byt.toString());
			ois.close();
		}catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return byt;
	}
}
