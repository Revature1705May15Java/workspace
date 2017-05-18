package com.ex.serialize;

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
		// TODO Auto-generated method stub
		//Creates string byte stream object whose input is reflected in the bytestream.txt file, must update project for file to be shown
		
		String bytestream = "src/com/ex/serialize/bytestream.txt";
		
		Student s = new Student();
		s.setId(0);;
		s.setFristName("Gen");
		s.setLastName("B");
		s.setEmail("gb@gmail.com");
		
		
		
		
		//Writes to file
		writeObject(bytestream, s);
		writeObject(bytestream, s);
		System.out.println(bytestream);
		readObject(bytestream);
		

	}
	
	static void writeObject(String bytestream, Object obj){
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(bytestream));){
			oos.writeObject(obj);
		}
	catch(IOException e){
		e.printStackTrace();
		}

	}
	static void writeObjects(String bytestream, Object obj){
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(bytestream, true));){
			
			
			oos.writeObject(obj);
			
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	
	static Student readObject(String bytestream){
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(bytestream));){
			Object obj = ois.readObject();
			//ois.rea
			Student s = (Student) obj;
			System.out.println(s.toString());
			
		}catch(FileNotFoundException e){
			e.printStackTrace();			
		}catch(IOException e){
			e.printStackTrace();
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		}
		
		
		
		return null;
	}
	
	static Student readObjects(String bytestream){
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(bytestream));){
			
	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}
