package com.ex.p20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class DataFile {
	
	/*
	 * Organizes the data of the given string to show the name, 
	 * age, and the state in separate lines
	 */
	String printLine(String[] curr){
		
		String s = "Name: " + curr[0] + " " + curr[1] + "\n" + "Age: " + curr[2] + "\n" + "State: "
				+ curr[3] + " State";
		return s;
	}
	
	public static void main(String[] args) {
		/*
		 * Create the Data.txt file with 4 separate names added in
		 */
		try(PrintWriter file = new PrintWriter("src/com/ex/p20/Data.txt", "UTF-8");){
			
			file.println("Mickey:Mouse:35:Arizona");
			file.println("Hulk:Hogan:50:Virginia");
			file.println("Roger:Rabbit:22:California");
			file.print("Wonder:Woman:18:Montana");
			
		}catch(IOException e){
			e.printStackTrace();
		}
		
		/*
		 * Read the given txt file and prints it out to the console
		 */
		try(BufferedReader br = new BufferedReader(new FileReader("src/com/ex/p20/Data.txt"));){
			
			String line = null; //current line place holder
			
			DataFile file = new DataFile();
			while((line = br.readLine()) != null){
				 String[] curr = line.split(":");
				 System.out.println(file.printLine(curr));
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
