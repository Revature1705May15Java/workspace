package com.rev.lambdas;

import java.util.Arrays;

import java.util.List;
import java.util.function.Predicate;

public class LambdaEx {
	
	public static void eval(List<Integer> l, Predicate<Integer> predicate){//PREIDCATE<Integer> is the Lamda expression
		for(Integer n: l){
			if(predicate.test(n))
				System.out.print(n+" ");
		}
	}
	
	public static void sum (List<Integer> l, Predicate<Integer>predicate){
		for(Integer x:l){
			if(predicate.test(x))
				System.out.println(x+l.get(x));
		}
		
	}

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
		eval(list, n->true);
		eval(list, n-> n%2==0);// = returns all even numbers
		
		
		
		
	

	}

}
