package com.rev.exceptions;

import java.util.Scanner;

public class AssertionsEx {
	
	static void methodA(int a){
		if(a>=0){
			System.out.println("Bigger than 0");
		}
		else
			System.out.println("nah bruh");
	}
	
	static void methodB(int b){
		//NEVER TRY TO CATCH AN ASSERTION ERROR
		assert(b>0) : "YOU DONE FUCKED UP NOW A-ARON";
			System.out.println("Bigger than 0");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		System.out.println("enter an int >=0");
		int x = in.nextInt();
		
		methodA(x);
		methodB(x);
		
		

	}

}
