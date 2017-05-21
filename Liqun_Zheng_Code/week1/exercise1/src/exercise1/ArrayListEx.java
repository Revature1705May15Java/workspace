package exercise1;

import java.util.ArrayList;

public class ArrayListEx {
	public static void main(String[] args) {
		ArrayList<String> x = new ArrayList<String>();
		ArrayList<String> palindrome = new ArrayList<String>();
		x.add("karan");
		x.add("madam");
		x.add("tom");
		x.add("civic");
		x.add("radar");
		x.add("sexes");
		x.add("jimmy");
		x.add("kayak");
		x.add("john");
		x.add("refer");
		x.add("billy");
		x.add("did");
		System.out.println("Contents of x: " +x);
		
		for(int i = 0; i <x.size(); i++){
			if(checkPalindromes(x.get(i))){
				palindrome.add(x.get(i));
			}
		}
		System.out.println("Contents of Palindromes: " + palindrome);
	}
	public static boolean checkPalindromes(String s){
		boolean result = false;
		String temp = new StringBuilder(s).reverse().toString();
		if(temp.equals(s)){
			result = true;
		}
		return result;
	}
}