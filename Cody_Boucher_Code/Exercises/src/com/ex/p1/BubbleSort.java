package com.ex.p1;

public class BubbleSort {
	public static void main(String[] args) {
		BubbleSort b = new BubbleSort();
		int[] input = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		for(int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
		b.sort(input);
		System.out.println(" ");
		for(int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
	}
	
	
	
	public int[] sort (int[] myArray) {
		int temp = 0;
		for(int i = 0; i < myArray.length; i++) {
			for(int j = 1; j < myArray.length-i; j++) {
				if(myArray[j-1] > myArray[j]) {
					temp = myArray[j];
					myArray[j] = myArray[j-1];
					myArray[j-1] = temp;	
				}
			}
		}
		return myArray;
	}
}
