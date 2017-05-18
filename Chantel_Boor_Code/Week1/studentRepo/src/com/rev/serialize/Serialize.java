package com.rev.serialize;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.rev.pojo.Student;

public class Serialize 
{
	public static void main(String[] args)
	{
		String bytestream = "src/com/rev/serialize/bytestream.txt";
		
		Student s = new Student();
		s.setId(0);
		s.setFirstName("Gen");
		s.setLastName("B");
		s.setEmail("genisis.b@gmail.com");
		
		//writeObject(bytestream,s);
		//readObject(bytestream);
		readMultiObject(bytestream);
	}
	
	static void writeObject(String bytestream, Object obj)
	{
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(bytestream,true)))
		{
			oos.writeObject(obj);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static Student readObject(String bytestream)
	{
		
		//use while loop with an end of file exception to break it
		//might work after we get the thing to work in the first place
		try
		{
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(bytestream));
			
			Object obj = ois.readObject();
			Student s = (Student) obj;
			System.out.println(s.toString());
			
		} catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return null;
	}
	
	static Student readMultiObject(String bytestream)
	{
		
		//use while loop with an end of file exception to break it
		//might work after we get the thing to work in the first place
		try
		{
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(bytestream));
			
			
			while(true)
			{
				try
				{
					Object obj = ois.readObject();
					Student s = (Student) obj;
					System.out.println(s.toString());
					
				}catch(IOException e){
					break;
				}catch(ClassNotFoundException e){
					e.printStackTrace();
				}
			}
			
			ois.close();
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		return null;
	}
}
