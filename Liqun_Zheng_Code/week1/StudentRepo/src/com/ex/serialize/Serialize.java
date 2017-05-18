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
		String bytestream = "src/com/ex/serialize/bytestream.txt";
		
		Student s = new Student();
		s.setId(0);
		s.setFirstName("uio");
		s.setLastName("gjh");
		s.setEmail("g.kjjk@gmail.com");
		
//		ArrayList<Student> st= new ArrayList<Student>();
//		Student temp = new Student();
//		temp.setFirstName("dan");
//		temp.setLastName("k");
//		temp.setEmail("g.bnds@gmail.com");
//		st.add(temp);
//		temp.setId(2);
//		temp.setFirstName("van");
//		temp.setLastName("in");
//		temp.setEmail("g.bn4s@gmail.com");
//		st.add(temp);
//		temp.setId(4);
//		temp.setFirstName("dn");
//		temp.setLastName("pon");
//		temp.setEmail("g.bn6s@gmail.com");
//		st.add(temp);
//		writeObject(bytestream, s);
		//readObject(bytestream);
		//writeMultiObject(bytestream, st);
		readObj(bytestream);
	}
	
	static void writeObject(String bytestream, Object obj){
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(bytestream));){
			oos.writeObject(obj);
			
		} catch(IOException e){
			e.printStackTrace();
		}
	}
	
	static Student readObject(String bytestream){
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(bytestream));){
			Object obj = ois.readObject();
			Student s = (Student) obj;
			System.out.println(s.toString());
		} catch (FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		}
		
		return null;
	}
	static void writeMultiObject(String bytestream, ArrayList obj){
		try(
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(bytestream));){
			for(int i= 0; i<obj.size(); i++){
				oos.writeObject(obj.get(i));
			}
		} catch(IOException e){
			e.printStackTrace();
		}
	}

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
