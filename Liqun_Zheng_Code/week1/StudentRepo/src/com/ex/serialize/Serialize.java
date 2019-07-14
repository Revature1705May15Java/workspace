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

	public static void main(String[] args) 
	{
		String bytestream = "src/com/ex/serialize/bytestream.txt";
		ArrayList<Student> ss = new ArrayList<>();
		ss.add(new Student("Drew", "Allen", "d@email.com", 60));
		ss.add(new Student("Arthur", "Faugue", "af@email.com", 33));
		
		writeObj(bytestream, ss);
		readObj(bytestream);
	}
	
	static void writeObj(String bytestream, ArrayList<Student> ss)
	{
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(bytestream, true));)
		{
			oos.writeObject(ss);
			oos.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	

	@SuppressWarnings("unchecked")
	static ArrayList<Student> readObj(String bytestream)
	{
		ArrayList<Student> ss = null;
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(bytestream));)
		{
			ss = (ArrayList<Student>) ois.readObject();
			//Student ss = (Student) obj;
			System.out.println(ss.toString());
			ois.close();
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ss;
	}
}
