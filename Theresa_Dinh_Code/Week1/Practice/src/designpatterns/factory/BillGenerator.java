package designpatterns.factory;

import java.util.Scanner;

public class BillGenerator 
{
	public static void main(String[] args)
	{
		Factory f = new Factory(); 
		
		Scanner keyboard = new Scanner(System.in); 
		
		System.out.println("Enter plan ");
		String choice = keyboard.nextLine(); 
		
		System.out.println("How many months ");
		int units = Integer.parseInt(keyboard.nextLine()); 
		
		Plan p = f.getPlan(choice); 
		System.out.println("The rate for this plan is ");
		p.getRate();
		p.calculateBill(units);
		
		keyboard.close();
	}
}
