package tests;

import java.util.Scanner;

public class tests {

	public static void main(String[] args) {
		while(true){
			int x = 0, y = 0, count = 0;
			String input = "z";
			checkInput checker = new checkInput();
			
			Scanner userInput = new Scanner(System.in);
			while(!checker.check(input, count)){
				count++;
				System.out.print("X = ");
				input = userInput.nextLine().trim();
			}
			System.out.println();
			x = Integer.parseInt(input);
			count = 0;
			input = "z";  // to ensure that the next while loop starts correctly.
			
			while(!checker.check(input, count)){
				count++;
				System.out.print("Y = ");
				input = userInput.nextLine().trim();
			}
			y = Integer.parseInt(input);
			
			while(true){
				System.out.print("X = " + x + " and Y = " + y + "\n" + "Enter an operator (Ex: '+' or 'add': ");
				input = userInput.nextLine().trim();
				System.out.println("input = " + input);
				if(input.equals("*") || input.equals("multiply")){
					System.out.println("\n\nAnswer: " + x + " * " + y + " = " + (x*y) + "\n");
					break;
				} else if(input.equals("/") || input.equals("divide") || input.equals("\\")){
					System.out.println("\n\nAnswer: " + x + " / " + y + " = " + (x/y) + "\n");
					break;
				} else if(input.equals("+") || input.equals("add")){
					System.out.println("\n\nAnswer: " + x + " + " + y + " = " + (x+y) + "\n");
					break;
				} else if(input.equals("-") || input.equals("minus") || input.equals("subtract")){
					System.out.println("\n\nAnswer: " + x + " - " + y + " = " + (x-y) + "\n");
					break;
				} else{
					System.out.println("Error, invalid operator.");
				}
			}
			while(true){
				System.out.print("Another? ");
				input = userInput.nextLine().substring(0, 1).toLowerCase();
				if(input.equals("f") || input.equals("t") || input.equals("y") || input.equals("n")) break;
				else System.out.println("Invalid entry - Examples: T/F, true or false.");
			}
			if(input.equals("f") || input.equals("n")) {userInput.close(); break;}
			else System.out.println("\n");
		}
		System.out.println("\nGoodbye!");
		
	}

}
