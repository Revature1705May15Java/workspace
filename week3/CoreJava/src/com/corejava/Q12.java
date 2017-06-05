package com.corejava;

public class Q12 {
/*
Write a program to store numbers from 1 to 100 
in an array. Print out all the even numbers 
from the array. Use the enhanced FOR loop for 
printing out the numbers.
 */
	public static void Q12m(){
		int[] nums = new int[100];
		for(int i=0;i<100;i++){
			nums[i]=i+1;
		}
		for(int num:nums){
			if(num%2==0){
				System.out.println(num);
			}
		}
		
	}
	public static void main(String[] args) {
		Q12m();
	}
}
