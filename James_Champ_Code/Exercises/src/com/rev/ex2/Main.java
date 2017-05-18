package com.rev.ex2;

import java.util.LinkedList;

public class Main {
	public static void main(String[] args) {
		LinkedList<Integer> list = Fibonacci.getSequence(25);
		
		for(int i : list){
			System.out.print(i + " ");
		}
	}
}
