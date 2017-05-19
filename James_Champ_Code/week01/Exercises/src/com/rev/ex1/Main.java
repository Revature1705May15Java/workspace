package com.rev.ex1;

public class Main {
	
	public static void main(String[] args) {
		int[] arr = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
	
		BubbleSort.sort(arr);
		
		for(int i : arr) {
			System.out.print(i + " ");
		}
	}
}
