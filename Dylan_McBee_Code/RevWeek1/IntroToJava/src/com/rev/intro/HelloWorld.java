package com.rev.intro;

import java.util.Scanner;

abstract class Helper {

}

public class HelloWorld extends Helper {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter an integer");
		int x = scan.nextInt();

		// Switch

		switch (x) {
		case (1):
			System.out.println("right");
			break;
		case (2):
			System.out.println("wrong");
			break;

		default:
			System.out.println("default");
		}
		if(x>10){
			System.out.println("Greater than 10");
		}
		else if (x==10){
			System.out.println("10");
		}
		else{
			System.out.println("Not greater than 10");
		}
		int[] list = new int[10];
		for(int i = 0; i < x; i ++){
			System.out.println("this is interation number " + i);
			list[i] = i;
		}
		for(int p: list){
			System.out.println(p*p);
			if(p == 5)break;
			if(p==7) continue;
			System.out.println(p*p);
			
		}
		do{
		x++;	
		}while(x<10);
	}
		
}
