package com.rev.lambdas;

import java.util.List;
import java.util.function.Predicate;
import java.util.Arrays;

public class LamdaEx {
	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
		List<String> list1 = Arrays.asList("sdf","sdfsd","34r","hth");
//		
//		list.forEach(n->System.out.println(n));
//		
//		for(int n :list){
//			System.out.println(n);
//		}
		eval(list, n->true);
		eval(list, n-> n%2==0);
		
		eval(list, n-> n<5);
		
		evaluate(list1, n->true);
		evaluate(list1, n->n.equals("sdf"));
	}
	public static void eval(List<Integer> list, Predicate<Integer> predicate){
		for(Integer n: list){
			if(predicate.test(n)){
				System.out.print(n + " ");
			}
		}
		System.out.println("\n");
	}
	public static void evaluate(List<String> input, Predicate<String> predicate){
		for(String n: input){
			if(predicate.test(n)){
				System.out.print(n.toString()+ " ");
				
			}
		}
	}
}
