package p17;

import java.util.Scanner;

public class InterestCalculator 
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in); 
		double principal; 
		double rate; 
		double years; 		
		
		// gets principal, rate, years from console input 
		System.out.println("Principal: ");
		principal = keyboard.nextDouble();
		System.out.print("Rate: ");
		rate = keyboard.nextDouble(); 
		System.out.println("Years: ");
		years = keyboard.nextDouble(); 
		
		System.out.println("Interest: " + (principal * rate * years));
		keyboard.close();
	}
}
