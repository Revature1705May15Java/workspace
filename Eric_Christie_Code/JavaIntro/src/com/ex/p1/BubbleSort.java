package com.ex.p1;

import java.util.ArrayList;

public class BubbleSort {
	static ArrayList<Integer> numbers = new ArrayList<>(/*{1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4}*/);
	
	static ArrayList<Integer> sort(ArrayList<Integer> nums) {
		for (int start = 0; start < nums.size(); start++) {
			boolean changed = false;
			for (int i = start; i < nums.size() - 1; i++) {
				int current = nums.get(i);
				if (current > nums.get(i + 1)) {
					nums.set(i, nums.get(i + 1));
					nums.set(i + 1, current);
					changed = true;
				}
			}
			if (!changed) {
				break; // ewww
			}
		}
		return nums;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> answer = sort(numbers);
		for (int i: answer) {
			System.out.println(i);
		}
	}
	
	
}
