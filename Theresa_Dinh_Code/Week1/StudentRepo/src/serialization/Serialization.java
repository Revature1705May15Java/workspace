package serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import pojos.Student;
import studentService.StudentService;

public class Serialization 
{
	public static void main(String[] args)
	{
		String byteStream = "src/serialization/bytestream.txt"; 
		
		StudentService ss = new StudentService(); 
		Student s = ss.addStudent("Jane", "Doe", "doe@email.com");
//		Student s = new Student();
//		s.setId(1);
//		s.setFirstName("a");
//		s.setLastName("s");
//		s.setEmail("c");
		
		//writeObject(byteStream, s); 
		readObject(byteStream); 
	}
	
	static void writeObject(String stream, Object ob)
	{
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(stream));)
		{
			oos.writeObject(ob);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	// to read multiple objects you need the objects to have been written in the same output stream 
	// to deal with that, read all the objects in as strings, put them in a list and then read them all in one
	// 	output stream 
	//  http://stackoverflow.com/questions/7826834/de-serializing-objects-from-a-file-in-java
	static Student readObject(String stream)
	{
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(stream));)
		{
			Object thing = ois.readObject(); //getarraylist, serialize the arraylist, deserialize the arraylist 
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return null; 
		
		
//		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(stream));)
//		{
//			Object ob = ois.readObject(); 
//			Student s = (Student)ob; 
//			System.out.println(s.toString());
//		}
//		catch(FileNotFoundException e)
//		{
//			e.printStackTrace();
//		}
//		catch(IOException e)
//		{
//			e.printStackTrace();
//		}
//		catch(ClassNotFoundException e)
//		{
//			e.printStackTrace();
//		}
//		return null; 
	}
}
