package com.question.answer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

// Create a notepad file called Data.txt and enter the following: 
// Mickey:Mouse:35:Arizona
// Hulk:Hogan:50:Virginia
// Roger:Rabbit:22:California
// Wonder:Woman:18:Montana
//
// Write a program that would read from the file and print it out to
// the screen in the following format:
//
// Name: Mickey Mouse
// Age: 35 years
// State: Arizona State

public class Q20 {
	FileReader fr;
	BufferedReader br;
	StringBuilder sb;
	
	Q20(){
		try {
			fr = new FileReader("com/question/data/Data.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		br = new BufferedReader(fr);
	}
	
	
	
}
