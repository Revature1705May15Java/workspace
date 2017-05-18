package com.rev.exceptions;

import java.util.*;

public class AssertEx {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter an int >= 0 " );
		
		int x =  in.nextInt();
		
		methodA(x);
		methodB(x);
	}
	
	static void methodA(int num){
		if (num>=0){
			System.out.println("great");
		}else{
			System.out.println("ERR");
		}
	}
	static void methodB(int num){
		assert(num>=0):"" + num + "entered it's a number less than 0" ;
		System.out.println("great");
	}

}
