package com.rev.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class LambdaEx {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

		list.forEach((n) -> {
			//System.out.println(n);
		});
		
		eval(list, n -> true);
		eval(list, n -> n % 2 == 0);
		eval(list, n -> n < 5);
		
		int sum = eval2(list, n -> n % 3 == 0);
		System.out.println("Summation of nums divisible by 3: " + sum);
		
	}
	
	// PREDICATES [use lambdas]
	// predicate is a functional interface
	public static void eval(List<Integer> list, Predicate<Integer> predicate) {
		for (Integer n : list) {
			if (predicate.test(n)) {
				System.out.print(n + " ");
			}
		}
		
		System.out.println();
	}
	
	public static int eval2(List<Integer> list, Predicate<Integer> predicate) {
		int sum = 0;
		
		for (Integer n : list) {
			if (predicate.test(n)) {
				sum += n;
			}
		}
		
		return sum;
	}
	
}
