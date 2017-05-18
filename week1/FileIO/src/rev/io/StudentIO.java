package rev.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import rev.pojos.Student;

public class StudentIO implements Serializable{

	public static void main(String[] args) throws FileNotFoundException {

		String filename = "src/rev/logs/students.txt"; //Do you know about classpath?

		//writeStudents(filename);
		readStudents(filename);
	}

	static void writeStudents(String filename){
		Student john = new Student(22, "gen", "Doe");
		ArrayList<Student> students = new ArrayList<>();
		students.add(john);

		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true));){ // true boolean in filewriter appends
			for(Student s: students){
				bw.write(""+ s.getAge() + ":" + s.getFirstname() + ":" + s.getLastname()+"\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	static void readStudents(String filename){
		try(BufferedReader br = new BufferedReader(new FileReader(filename));){

			String line = null;
			while((line = br.readLine())!=null){
				String[] students = line.split(":");
				
				System.out.println("Name: " + students[1] + " " + students[2]);
				System.out.println("Age: " + students[0]);
				System.out.println();


			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Student> getAllStudents(String filename){
		ArrayList<Student> students = new ArrayList<Student>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(filename));){

			String line = null;
			while((line = br.readLine())!=null){
				String[] curr = line.split(":");
				
				Student temp = new Student();
				temp.setAge(Integer.parseInt(curr[0]));
				temp.setFirstname(curr[1]);
				temp.setLastname(curr[2]);
				
				students.add(temp);
				System.out.println(temp.toString());


			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return students;
	}

}



