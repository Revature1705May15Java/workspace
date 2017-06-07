package com.hw.q14;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Write a program that demonstrates the switch case. 
 * Implement the following functionalities in the cases:
	Case 1: Find the square root of a number using the Math class method. 
	Case 2: Display today’s date.
	Case 3: Split the following string and store it in a sting array. 
		“I am learning Core Java”
 * @author Gian-Carlo
 *
 */
public class Switch {
	public static void main(String[] args) {
		switchCase();
	}
	
	public static void switchCase() {
		int input = 3;
		
		switch(input) {
			case 1:
				int num = 64;
				System.out.println("Square root of " + num + " is " + Math.sqrt(64));
				break;
			case 2:
				System.out.println("Today's date is: " + LocalDate.now());
				break;
			case 3:
				String[] tokens = "I am learning Core Java".split(" ");
				for (String s : tokens) {
					System.out.println(s);
				}
				break;
		}
	}
}
