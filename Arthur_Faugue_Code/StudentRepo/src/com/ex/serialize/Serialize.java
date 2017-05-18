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
		Student s = new Student();
		s.setId(0);
		s.setFirstName("Art");
		s.setLastName("F");
		s.setEmail("a@aol.com");
		arr.add(s);
		
		writeObject(bytestream, arr);
//		System.out.println(s.toString());
//		readObject(bytestream);
		readObjectArray(bytestream);
	}
	
	static void writeObject(String bytestream, Object obj){
		ArrayList<Student> stuOut = new ArrayList<>();
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(bytestream));){
			oos.writeObject(obj);
			oos.close();
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
	//
	static void writeObject(String bytestream, ArrayList<Student> obj){
		int x = 0;
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(bytestream));){
			
			//Writes all objects in the array
			oos.writeObject(obj);
			oos.close();
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
	
	static Student readObject(String bytestream){
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(bytestream));) {
			Object obj = ois.readObject();
			Student s = (Student) obj;
			System.out.println(s.toString());
			ois.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	
	static ArrayList<Student> readObjectArray(String bytestream){
		ArrayList<Student> byt= null;
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(bytestream));){
			byt = (ArrayList<Student>) ois.readObject();
			System.out.println(byt.toString());
			ois.close();
		}catch (IOException e) {
			// TODO: handle exception
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return byt;
	}
}
