package com.revature_wk1.serialize;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.revature_wk1.pojos.Student;

public class Serialize {

	public static void main(String[] args) 
	{
		String bytestream = "src/com/revature/serialize/bytestream.txt";
		Student ss = new Student();
		ArrayList<Student> ss_1 = new ArrayList<>();
		
		writeObj(bytestream, ss);
		readObj(bytestream);
		
		writeObjs(bytestream, ss_1);
		readObjs(bytestream);
	}
	
	public static void writeObj(String bytestream, Student ss)
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
	
	public static void writeObjs(String bytestream, ArrayList<Student> ss)
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
	public static Student readObj(String bytestream)
	{
		Student ss = null;
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(bytestream));)
		{
//			ss = (ArrayList<Student>) ois.readObject();
			ss = (Student) ois.readObject();
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
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Student> readObjs(String bytestream)
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
