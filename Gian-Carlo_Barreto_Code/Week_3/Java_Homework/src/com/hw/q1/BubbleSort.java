package com.hw.q1;

/*
 * Uses bubble sort to sort an array in ascending order
 */
public class BubbleSort {
	public static void main(String[] args) {
		int nums[] = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		nums = bubblesort(nums);
		
		for (int n : nums)
			System.out.print(n + " ");
	}
	
	public static int[] bubblesort(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				// Swaps two elements
				if (nums[i] > nums[j]) {
					int temp = nums[j];
					nums[j] = nums[i];
					nums[i] = temp;
				}
			}
		}
		
		return nums;
	}
}