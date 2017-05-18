package com.ex.p3;
import java.util.Scanner;

public class NFactorial {
	
	int Factorial(){
		Scanner reader = new Scanner(System.in);
		System.out.print(" Enter a number: ");
		
		int Input = reader.nextInt();
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
		//close scanner
		reader.close();
		return Temp;
	}
	public static void main(String[] args) {
		
		NFactorial Fact = new NFactorial();
		Fact.Factorial();
		
		
	}
}
