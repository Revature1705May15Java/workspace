package com.rev.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.rev.pojos.Student;

public class Serialize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//String filename = "src/com/rev/io/studentlog.txt";
		String bytestream = "src/com/rev/serialization/bytestream.txt";

		Student s = new Student("Doe", "John", 30);
		//writeObject(bytestream, s);
		readObject(bytestream);
	}


	static void writeObject(String bytestream, Object obj){
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(bytestream));){
			oos.writeObject(obj);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	static void readObject(String bytestream){
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(bytestream));){
			Object obj = ois.readObject();
			System.out.println(obj);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
