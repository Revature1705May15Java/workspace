package com.rev.ex19;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ListOfTen lot = new ListOfTen();
		ArrayList<Integer> list = lot.getList();
		
		System.out.println("All Numbers:");
		for(int i : list) {
			System.out.println(i);
		}
		
		System.out.println("Sum of Evens:");
		System.out.println(lot.addEvens());
		
		System.out.println("Sum of Odds:");
		System.out.println(lot.addOdds());
		
		list = lot.getListLessPrimes();
		System.out.println("Non-Prime Numbers:");
		for(int i : list) {
			System.out.println(i);
		}
	}
}
