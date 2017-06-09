package com.rev.q14;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

public class SwitchStatement {
	public static void main(String[] args) {
		System.out.println("Results of switch statement selections:\n");
		for(int i = 1; i < 5; i++) {
			System.out.println("Selection " + i + ":");
			executeSwitch(i);
			System.out.println();
		}
	}
	
	private static void executeSwitch(int choice) {
		switch(choice) {
			case 1:
				Random rand = new Random();
				int number = rand.nextInt(Integer.MAX_VALUE);
				double sqrt = Math.sqrt(number);
				System.out.println("The square root of " + number + " is " + sqrt);
				break;
			case 2:
				LocalDateTime now = LocalDateTime.now();
				LocalDate date = now.toLocalDate();
				System.out.println("Today is " + date.toString());
				break;
			case 3:
				String s = "I am learning Core Java";
				String[] split = s.split(" ");
				
				System.out.println("Original String: \"" + s +"\"");
				for(int i = 0; i < split.length; i++){
					System.out.println("String at index " + i + ": " + "\"" + split[i] + "\"");
				}
				break;
			default:
				System.out.println("Invalid Selection\n");
				break;
		}
	}
}
