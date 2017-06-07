package com.hw.q12;

/**
 * Write a program to store numbers from 1 to 100 in an array. 
 * Print out all the even numbers from the array. 
 * Use the enhanced FOR loop for printing out the numbers.
 * @author Gian-Carlo
 *
 */
public class DisplayEvens {

	public static void main(String[] args) {
		int[] nums = new int[100];
		for (int i = 0; i < 100; i++)
			nums[i] = i + 1;
		for (int n : nums) {
			if (n % 2 == 0)
				System.out.print(n + " ");
		}
	}

}
