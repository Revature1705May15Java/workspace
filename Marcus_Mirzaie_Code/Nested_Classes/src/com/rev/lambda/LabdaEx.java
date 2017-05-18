package com.rev.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class LabdaEx {

	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8,9);
		
		eval(list, n->true);
		

	}
	
	public static void eval(List<Integer> list, Predicate<Integer> predicate){
		for(Integer n: list){
			if(predicate.test(n)){
				System.out.println(n + " ");
			}
		}
	}

}
