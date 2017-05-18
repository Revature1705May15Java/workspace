package com.rev.q20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PlainTextReader {
	public static void main(String[] args) {
		String filename = "src/com/rev/q20/Data.txt";
		
		ArrayList<Person> people = getPeople(filename);
		displayPeople(people);
	}
	
	public static void displayPeople(ArrayList<Person> people) {
		for (Person p : people) {
			System.out.println("Name: " + p.getfName() + " " + p.getlName());
			System.out.println("Age: " + p.getAge() + " years");
			System.out.println("State: " + p.location);
			System.out.println();
		}
	}
	
	public static ArrayList<Person> getPeople(String filename) {
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String currLine;
			
			ArrayList<Person> people = new ArrayList<>();
			
			while ((currLine = br.readLine()) != null) {
				String[] tokens = currLine.split(":");
				
				String fName = tokens[0];
				String lName = tokens[1];
				int age = Integer.parseInt(tokens[2]);
				String location = tokens[3];
				
				people.add(new Person(fName, lName, age, location));
			}
			
			return people;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}  
	}
}
