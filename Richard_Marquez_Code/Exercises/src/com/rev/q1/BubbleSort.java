package com.rev.q1;

public class BubbleSort {

	public static void main(String[] args) {
//		// Dummy array for testing bubbleSort
//		int[] arr = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
//		
//		// Print unsorted list
//		for (int i = 0; i < arr.length; i++) {
//			System.out.print(arr[i] + " ");
//		}
//		
//		bubbleSort(arr);  // In place sort
//		
//		// Print sorted list
//		System.out.println();
//		for (int i = 0; i < arr.length; i++) {
//			System.out.print(arr[i] + " ");
//		}

	}
	
	// Bubble sort the given int array (ascending)
	// Returns copy of array, sorted
	// (no early exit)
	public int[] sort(int[] input) {
		// Make copy of array
		int[] sorted = new int[input.length];
		System.arraycopy(input, 0, sorted, 0, input.length);
		
		for (int i = 0; i < sorted.length; i++) {
			for (int j = 0; j < sorted.length-1; j++){
				// Check for correct positioning of adjacent elements
				if (sorted[j] > sorted[j+1]) {
					// swap
					int tmp = sorted[j];
					sorted[j] = sorted[j+1];
					sorted[j+1] = tmp;
					
				}
			}
		}
		
		return sorted;
	}

}
