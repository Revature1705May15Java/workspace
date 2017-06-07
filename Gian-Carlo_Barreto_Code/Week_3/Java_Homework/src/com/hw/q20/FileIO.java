package com.hw.q20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class Person {
	String firstName;
	String lastName;
	int age;
	String state;
	
	Person(String firstName, String lastName, int age, String state) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.state = state;
	}
	
	String getFirstName() {
		return this.firstName;
	}
	
	String getLastName() {
		return this.lastName;
	}
	
	int getAge() {
		return this.age;
	}
	
	String getState() {
		return this.state;
	}
	
	public String toString() {
		return "Name: " + this.firstName + " " + this.lastName + "\n"
				+ "Age: " + this.age + " years\n"
				+ "State: " + this.state + " State\n";
	}
}

/*
 * Create a notepad file called Data.txt and enter the following: 
	Mickey:Mouse:35:Arizona
	Hulk:Hogan:50:Virginia
	Roger:Rabbit:22:California
	Wonder:Woman:18:Montana
	
	Write a program that would read from the file and print it out to the screen in the following format:
	
	Name: Mickey Mouse
	Age: 35 years
	State: Arizona State
 */
public class FileIO {
	public static void main(String[] args) {
		String filename = "src/com/hw/q20/data.txt";
		ArrayList<Person> persons = readFile(filename);
		persons.forEach(p->System.out.println(p));
	}
	
	/*
	 * Reads in all the Persons information from a file and stores
	 * the information into an ArrayList of persons
	 * @param filename
	 * @return persons: An ArrayList of Person objects
	 */
	public static ArrayList<Person> readFile(String filename) {
		ArrayList<Person> persons = new ArrayList<Person>();
		try (BufferedReader br = new BufferedReader(new FileReader(filename));) {
			String line = null;
			while((line = br.readLine()) != null) {
				String[] info = line.split(":");
				Person p = new Person(info[0], info[1], Integer.parseInt(info[2]), info[3]);
				persons.add(p);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return persons;
	}
}
