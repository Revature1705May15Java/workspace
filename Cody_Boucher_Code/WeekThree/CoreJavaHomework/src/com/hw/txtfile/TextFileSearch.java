package com.hw.txtfile;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class TextFileSearch {
	static String filename = "src/com/hw/txtfile/Data.txt";
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new FileReader (filename))) {
			String line = null;
			while((line = br.readLine()) != null) {
				String[] curr = line.split(":");
				String fname = "";
				String lname = "";
				int age = 0;
				String state = "";
				fname = curr[0];
				lname = curr[1];
				age = Integer.parseInt(curr[2]);
				state = curr[3];
				System.out.println("\nName: " + fname + " " + lname);
				System.out.println("Age: " + age + " years");
				System.out.println(state + " State");
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
