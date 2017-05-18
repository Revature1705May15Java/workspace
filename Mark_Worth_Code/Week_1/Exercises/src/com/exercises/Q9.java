package com.exercises;

import java.util.ArrayList;

public class Q9 {
	public static void main(String[] args) {
		ArrayList<Integer> nums=new ArrayList<Integer>();
		ArrayList<Integer> primes=new ArrayList<Integer>();
		primes.add(2);
		primes.add(3);
		for(int i=0;i<100;i++){
			nums.add(i);
		}
		for(Integer num:nums){
			Integer highestprime=primes.get(primes.size()-1);
			if((num.compareTo(highestprime)<0)){
				continue;
			}
			
			for(int i=0;i<primes.size()-1;i++){
				if(((num%primes.get(i))==0)){
					break;
				}else if(i==primes.size()-2&&num!=3){
					primes.add(num);
					break;
				}
			}
		}
		for(Integer prime:primes){
			System.out.println(prime);
		}
		
	}
}
