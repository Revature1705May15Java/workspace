package helloworld;

import java.util.Scanner;

import org.omg.CORBA.SystemException;

public class helloworld {

	public static void main(String[] args) {
		System.out.println();   // ctrl+space after typing 'sysout'
		System.out.println("Hello World!!");
		int x = 100_000; // underscore purely for readability.
		System.out.println(x);
//		
//		 ctrl+/ to comment multiple lines.
		Scanner input = new Scanner(System.in); // ctrl+shift+o    will handle importing!
		int z = 0;
		while(true){	
			try{
				System.out.print("Enter a number: ");
				z = Integer.parseInt(input.next());
				break;
			} catch (SystemException e){
				System.out.println("Invalid entry, please enter an int.");
			}
		}
		
		switch(z){
			case 1:
				System.out.println("Case 1");
				break;
			case 2:
				System.out.println("Case 2");
				break;
			default:
				System.out.println("Default!");
		}
		
		for(int i = 0; i < z; i++){
			if(i == 5) continue;
			System.out.println("Count: " + i);
		}
		
		input.close();

	}
	
	
}