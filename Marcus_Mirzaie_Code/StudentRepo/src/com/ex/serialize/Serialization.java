package com.ex.serialize;

import java.io.*;
import java.util.ArrayList;
import com.ex.pojos.Student;

public class Serialization {
	
	
	
//	public static void main(String[] args) {		
////		Student s = new Student();
////		s.setId(0);
////		s.setFirstName("Marcus");
////		s.setLastName("Mirzaie");
////		s.setEmail("Marcus.Mirzaie@outlook.com");
////		
////		writeObject(bytestream, s);
//			
//		readObjects(bytestream);
//	}
	
	public void writeObject(String bs, Object ob){
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(bs))){
			oos.writeObject(ob);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void writeObjects(String bs, ArrayList<Student> obs){
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(bs,true))){
			for(Object ob: obs)
				oos.writeObject(ob);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public Student readObject(String bs){
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(bs))){
			Object ob = ois.readObject();
			Student s = (Student) ob;
			System.out.println(s);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
//	static ArrayList<Student> readObjects(String bs){
//		try(FileInputStream fis = new FileInputStream(bs)){
//			byte[] build = new byte[fis.read()];
//			fis.read(build);
//			Object ob = (Object) build;
//			Student s = (Student) ob;
//			System.out.println(Arrays.asList(s));
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch(ClassCastException e) {
//			e.printStackTrace();
//		}
//		
//		return null;
//		
//	}
}
