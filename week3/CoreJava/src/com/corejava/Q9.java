package com.corejava;

import java.util.ArrayList;

public class Q9 {
/*
Create an ArrayList which stores numbers 
from 1 to 100 and prints out all the 
prime numbers to the console.
 */
	public static void Q9m() {
		ArrayList<Integer> nums=new ArrayList<Integer>();
		for(int i=1;i<101;i++){
			nums.add(i);
			if(i==2){
			}
			boolean isPrime=true;
			if(i==1){
			isPrime=false;
			}else{
				isPrime=true;
			}
			for(int j=2;j<i;j++){
//				System.out.println(""+i+"%"+j+"="+(i%j));
				if(i%j==0){
//					System.out.println(i+" is not prime");
					isPrime=false;
					break;
				}
			}
			if(isPrime){
				System.out.println(i+" is prime");
			}
		}
		
	}
	public static void main(String[] args) {
		Q9m();
	}
}
