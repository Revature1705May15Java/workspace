package com.rev.ex19;

import java.util.ArrayList;

import com.rev.ex9.PrimeNumbers;

public class ListOfTen {
	ArrayList<Integer> list;
	
	public ListOfTen() {
		list = new ArrayList<Integer>();
		for(int i = 1; i <= 10; i++) {
			list.add(i);
		}
	}
	
	public ArrayList<Integer> getList() {
		return list;
	}
	
	public int addEvens() {
		int result = 0;
		
		for(int i : list) {
			if(i % 2 == 0) {
				result += i;
			}
		}
		
		return result;
	}
	
	public int addOdds() {
		int result = 0;
		
		for(int i : list) {
			if(i % 2 == 1) {
				result += i;
			}
		}
		
		return result;
	}
	
	public ArrayList<Integer> getListLessPrimes() {
		ArrayList<Integer> result = new ArrayList<Integer>();
		PrimeNumbers pm = new PrimeNumbers(list.size());
		ArrayList<Integer> primes = pm.getPrimes();
		
		for(int i : list) {
			if(!primes.contains(i)) {
				result.add(i);
			}
		}
		
		return result;
	}
}
