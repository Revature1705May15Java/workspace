package com.ex.p3;
import java.util.Scanner;

public class NFactorial {
	
	/*
	 * Ask the user for an int and returns the 
	 * factorial for that number.
	 */
	int Factorial(int Input){
		
		int InputMinus = Input - 1;
		int LoopCheck = Input;
		int Temp = 0;
		
		for(int x = 0; x <= LoopCheck ;x++){
			
			if(InputMinus == 0 ){
				break;
			}
			
			Temp = Input * InputMinus;
			InputMinus = InputMinus - 1;
			Input = Temp;
			
		}
		System.out.println(Temp);
		return Temp;
	}
	
	public static void main(String[] args) {
		
		NFactorial Fact = new NFactorial();
		
		/*
		 * Ask the user to enter the number that they would want the
		 * factorial of
		*/
		Scanner reader = new Scanner(System.in);
		System.out.print("Enter a number: ");
		
		int Input = reader.nextInt();
		Fact.Factorial(Input);
		
		reader.close();
	}
}
