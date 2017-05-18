package com.rev.lamda;

import java.util.*;
import java.util.function.Predicate;

public class LamdaEx {

	public static void main(String[] args) {
	
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

		eval(list, n-> n%2 == 0); // n -> n%2 == 0 will check if this function is true
		eval(list, n-> n%5 == 0);
		eval(list, n-> n%5 == 0);
	}
	
	public static void eval(List<Integer> list, Predicate<Integer> predicate){
		for(Integer n : list){
			if(predicate.test(n)){
				System.out.print(n + " ");
			}
		}
	}
	
	public static void evaluate(List<Integer> list, Predicate<Integer> predicate){
		
	}

}
