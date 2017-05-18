package com.rev.ex1;

public class BubbleSort {

	/**
	 * Sorts a given array of integers using the bubble sort
	 * algorithm.
	 * 
	 * @param arr	The integer array that will be sorted.
	 * @return		A sorted array of integers.
	 */
	public static int[] sort(int[] arr) {
		for(int i = 1; i < arr.length; i++) {
			for(int j = 0; j < arr.length - 1; j++) {
				if(arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		
		return arr;
	}
}
