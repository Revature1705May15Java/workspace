package com.ex.p8;

import java.util.ArrayList;
import java.util.Arrays;

public class Palindrome {
	
	void returnPalindromeArray(ArrayList<String> array){
		ArrayList<String> palindrome = new ArrayList<>();
		String check;
		
		for(int i=0;i<array.size();i++){
			check = array.get(i);
			check = new StringBuffer(check).reverse().toString();
			
			if(check.equals(array.get(i))){
				palindrome.add(check);
			}
		}
		System.out.println(palindrome.toString());
	}
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>(Arrays.asList("karan", "madam", "tom", 
				"civic", "radar", "sexes", "jimmy", "kayak", "john",  "refer", "billy", "did"));
		
		Palindrome test = new Palindrome();
		test.returnPalindromeArray(list);
		
		
	}
}
