package com.rev.ex20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileParser {
	private static final String FILE_PATH = "src/com/rev/ex20/Data.txt";
	
	public static void displayFileContents() {
		try(BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
			String line;
			while((line = br.readLine()) != null) {
				String[] splitLine = line.split(":");
				
				System.out.println("Name: " + splitLine[0] + " " + splitLine[1]);
				System.out.println("Age: " + splitLine[2] + " years");
				System.out.println("State: " + splitLine[3] + " State");
			}
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String returnFormattedFileContents() {
		try(BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
			String result = "";
			
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
