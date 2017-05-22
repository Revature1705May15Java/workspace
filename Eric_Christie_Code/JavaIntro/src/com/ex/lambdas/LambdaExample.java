package com.ex.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class LambdaExample {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(0,1,2,3,4,5,6,7,8,9);
		
//		list.forEach(element -> {System.out.println(element);});
		
		eval(list, (num) -> true);
		System.out.println();
		eval(list, (num) -> {
			return (num % 2 == 0);
		});
	}
	
	public static void eval(List<Integer> list, Predicate<Integer> predicate) {
		for (Integer i: list) {
			if (predicate.test(i)) {
				System.out.println(i + " ");
			}
		}
		
		Runnable r1 = new Runnable(){
			@Override
			public void run() {
				System.out.println("running anonymous");
			}
		};
		
		Runnable r2 = () -> System.out.println("running lambda");
		
		r1.run();
		r2.run();
		
		
	}

	VarArgsOperator sum = (Integer[] nums) -> {
		int sum = 0;
		for (int i: nums) {
			sum += i;
		}
		return sum;
	};
}

/*
 * a user-made functional interface
 */
interface MathOperation {
	int operation(int a, int b);
}

interface VarArgsOperator {
	int operation(Integer ... integers);
}