package com.ex.serialization;

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
		 String bytestream="src/com/ex/serialization/bytestream.txt";
		 ArrayList<Student> studentList=new ArrayList<Student>();
		 Student s = new Student();
		 s.setId(0);
		 s.setFirstName("B");
		 s.setLastName("Doe");
		 s.setEmail("mrw@gmail.com");
		 studentList.add(s);
		 writeObject(bytestream,s);
		 Student s2 = new Student();
		 s2.setId(1);
		 s2.setFirstName("a");
		 s2.setEmail("ww@gmail.com");
		 studentList.add(s2);
		 writeArrayList(bytestream,studentList);
		 readObject(bytestream);
	}
	
	static void writeObject(String bytestream,Object obj){
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(bytestream));){
			oos.writeObject(obj);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	static void writeArrayList(String bytestream,ArrayList list){
			try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(bytestream));){
				oos.writeObject(list.get(0));
				oos.writeObject(list.get(1));
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	static Student readObject(String bytestream){
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(bytestream));){
			Object obj =ois.readObject();
			Student s = (Student) obj;
			System.out.println(s.toString());
			Object obj2 =ois.readObject();
			Student s2 = (Student) obj2;
			System.out.println(s2.toString());			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	static Student readAllObjects(String bytestream){
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(bytestream));){
			Object obj =ois.readObject();
			Student s = (Student) obj;
			System.out.println(s.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
