package com.ex.evens;

import java.util.Scanner;

public class Evens {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter number to see if it is even");
		int x = scan.nextInt();
		scan.close();
		boolean even = isEven(x);
		System.out.println(even);
	}
	
	private static boolean isEven(int x){
		
		while(x>0){
			x-=2;
		}
		return x == 0;
	}

}
