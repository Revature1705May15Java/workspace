package com.ex.exercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Q20 {
	
	static String filename = "src/com/ex/exercises/Data.txt";
	
	static String readFile(String filename) {
		String output = "";
		try (BufferedReader br = new BufferedReader(new FileReader(filename));) {
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] current = line.split(":");
				output += "Name: " + current[0] + " " + current[1] + "\n"
						+ "Age: " + current[2] + " years\n"
						+ "State: " + current[3] + " State\n\n";
			}
		} catch (IOException e) {
			e.printStackTrace();			
		}
		return output;
	}

	public static void main(String[] args) {
		System.out.println(readFile(filename));
	}

}
