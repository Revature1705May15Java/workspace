package com.ex.p5;

import java.util.ArrayList;
import java.util.List;

public class Prime {

	public static void main(String[] args) {
		int x = 100;
		List<Integer> numbers = new ArrayList<Integer>();
		for(int i = 1; i<x; i++){
			numbers.add(i);
		}
		for (int i = 0; i<numbers.size(); i++){
	        if (!isPrime(numbers.get(i))){
	        	numbers.remove(numbers.get(i));
	            i--;
	            
	        }
	        }
	        System.out.println(numbers);
	    }
	 public static boolean isPrime(int x){
	        boolean itIs = true;
	        for (int i = 2; i < x; i++){
	            if(x%i == 0){
	                itIs = false;  
	            }
	        }
	        return itIs;
	    }
	
	}


