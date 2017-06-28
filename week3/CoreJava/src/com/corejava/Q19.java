package com.corejava;

import java.util.ArrayList;

public class Q19 {
/*
 *Create an ArrayList and insert integers 1 through 10. 
 *Display the ArrayList. 
 *Add all the even numbers up and display the result. 
 *Add all the odd numbers up and display the result. 
 *Remove the prime numbers from the ArrayList and 
 * print out the remaining ArrayList.
 */
	public static void main(String[] args) {
		ArrayList<Integer> ints=new ArrayList<Integer>();
		for(int i=1;i<11;i++){
			ints.add(i);
		}
		int evensum=0;
		int oddsum=0;
		for(Integer num:ints){
			if(num%2==0){
				evensum=evensum+num;
			}else{
				oddsum=oddsum+num;
			}
		}
		System.out.println(evensum);
		System.out.println(oddsum);
		ArrayList<Integer> primeslist=new ArrayList<Integer>();
		primeslist=getPrimesTo(10);
		for(Integer num:primeslist){
			if(ints.contains(num)){
				ints.remove(num);
			}
		}
		for(Integer num:ints){
			System.out.println("nonprime "+num);
		}
		
		
	}
	public static ArrayList<Integer> getPrimesTo(int num){
		ArrayList<Integer> primes=new ArrayList<Integer>();
		for(int i=1;i<num+1;i++){
			if(i==2){
				primes.add(i);
			}
			boolean isPrime=true;
			if(i==1){
			isPrime=false;
			}else{
				isPrime=true;
			}
			for(int j=2;j<i;j++){
				if(i%j==0){
					isPrime=false;
					break;
				}
			}
			if(isPrime){
				primes.add(i);
			}
		}
		return primes;
	}
}