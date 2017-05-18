package com.ex.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.ex.pojos.Student;

public class Serialize {

	public static void main(String[] args) {
		String byteStream = "src/com/ex/serialization/bytestream.txt";

		Student s = new Student();
		s.setId(1);
		s.setFirstName("Dyl");
		s.setLastName("McB");
		s.setEmail("me@gmail.com");

		//writeObject(byteStream, s);
		//readObject(byteStream);
		readAllObjects(byteStream);
	}

	static void writeObject(String byteStream, Object obj) {

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(byteStream, true))) {
			oos.writeObject(obj);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	static Student readObject(String byteStream) {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(byteStream))){
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
	static Student readAllObjects(String byteStream){
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(byteStream))){
			List<String> results = (List<String>)ois.readObject();
			for(String s: results){
				System.out.println(s + "\n");
			}
			
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
