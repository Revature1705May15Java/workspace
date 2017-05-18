package com.rev.intro;

import java.util.Scanner;

abstract class Helper{
	
	
}

public class HelloWorld extends Helper {
	
	public static void main(String[] args) {
		

		Scanner input = new Scanner(System.in);
		System.out.println("Please enter an integer");
		int x = input.nextInt();
		
		//Switch
		switch(x){
		case(1):
			System.out.println("right");
			break;
		
		case(2):
			System.out.println("wrong");
			break;
			
		default:
			System.out.println("default");
		
		}
		// & v && 
		// simple if
		
		boolean a = false;
		int b = 0;
		if(x == 1 && b++ == 0){
			System.out.println("aughisdhjg");
		}
		else{
			System.out.println("not greater than 10");
		}
		// for loop
		int[] list = new int[10];
		for(int i = 0; i < x; i++){
			System.out.println("this is iteration number " + i);
			list[i] = i;
		}
		
		
		
		//for each/enhanced for 
		for(int p: list){
			System.out.println(p*p);
			if(p ==5)break;
			if(p==7) continue;
			System.out.println(2*p*p);
			
		}
		
		do{
		x--;	
		}while(x<10);
		
//		while(){
//			
//		}
		
		
		
	}
}
