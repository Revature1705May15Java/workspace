package com.rev.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaExpression {
	static ArrayList<Integer> oddList;

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 45, 5, 6, 4);
		oddList = new ArrayList<Integer>();
		
		eval(list, n -> n % 2 == 1);
		
		for(int i : oddList) {
			System.out.println(i);
		}
		
		
		String hi = "Hello ";
		Function<String, String> f = (String s) -> s += "World";
		System.out.println(f.apply(hi));
		
		Function<String, Integer> length = (String s) -> s.length();
		System.out.print("Length of String \"Hello \": ");
		System.out.println(length.apply(hi));
		
		Function<ArrayList<Integer>, Integer> sum = (ArrayList<Integer> l) -> {
			int result = 0;
			for(int i : l) {
				result += i;
			}
			return result;
		};
		System.out.print("Sum of oddList elements: ");
		System.out.println(sum.apply(oddList));
	}
	
	public static void eval(List<Integer> list, Predicate<Integer> predicate) {
		for(Integer n : list) {
			if(predicate.test(n)) {
				oddList.add(n);
			}
		}
	}
	
	
}
