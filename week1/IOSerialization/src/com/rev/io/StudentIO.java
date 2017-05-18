package com.rev.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.rev.pojos.Student;

public class StudentIO {
	
	/*
	 * TO DO:
	 * write alternate methods for writing and reading
	 * WRITE: get input from console of name and age- write to file
	 * READ: return ArrayList of students from studentlog.txt
	 */

	public static void main(String[] args) {
		
		String filename = "src/com/rev/io/studentlog.txt";
		//writeStudents(filename);
	//	readStudents(filename);
		
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your name");
		String name = scan.nextLine();
		
		
		
	}
	
	static void writeStudents(String filename){
		Student temp = new Student("Genesis", "Bonds",22);
		Student temp2 = new Student("Jane", "Doe", 25);
		
		ArrayList<Student> students = new ArrayList<>();
		
		students.add(temp);
		students.add(temp2);
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true));){
			
			for(Student s:students){
				bw.write(s.getFirstName() + ":" + s.getLastName() +":" + s.getAge() +"\n");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	static void readStudents (String filename){
		try(BufferedReader br = new BufferedReader(new FileReader(filename));){
			
			String line = null;
			while((line=br.readLine())!=null){
				String[] students = line.split(":");
				System.out.println("Name: " + students[0] + " " + students[1]);
				System.out.println("Age: " + students[2]);
				System.out.println();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
