package com.hw.switchex;

import java.time.LocalDate;
import java.util.Scanner;

public class SwitchEx {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter choice");
		System.out.println("1: Find the square root of a number");
		System.out.println("2: Display the date");
		System.out.println("3: String fun");
		int userChoice = scan.nextInt();
		
		switch(userChoice) {
		case 1:
			System.out.print("Enter a number: ");
			double num = scan.nextDouble();
			System.out.println(Math.sqrt(num));
			break;
		case 2:
			System.out.println(LocalDate.now());
			break;
		case 3:
			String original = "I am learning Core Java\n";
			System.out.println("String: " + original);
			System.out.println("Array");
			String[] splitString = original.split(" ");
			for(int i = 0; i < splitString.length; i++) {
				System.out.println(splitString[i]);
			}
			break;
		default: 
			System.out.println("something went wrong");
		}
		scan.close();
	}
}
