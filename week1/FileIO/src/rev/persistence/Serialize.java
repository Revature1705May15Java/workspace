package rev.persistence;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import rev.io.StudentIO;
import rev.pojos.Student;

public class Serialize extends StudentIO {

	public static void main(String[] args) throws FileNotFoundException{
		// TODO Auto-generated method stub

		String filename = "src/rev/logs/serialized.txt";

		StudentIO reader = new StudentIO();
		ArrayList<Student> students = reader.getAllStudents("src/rev/logs/students.txt");
		
		for(Student s : students){
			writeObject(filename, s);
		}




	}

	static void writeObject(String filename, Object obj){
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){

			oos.writeObject(obj); //serialization

		} catch (IOException e) {
			e.printStackTrace();
		}


	}


	static void readObject(String filename){
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))){

			Object obj = ois.readObject(); //deserializationj
			System.out.println(obj);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}


	}

}
