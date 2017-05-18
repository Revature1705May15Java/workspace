package palindromes;

import java.util.ArrayList;

public class palindromes {

	static private ArrayList<String> palindromes = new ArrayList<String>();
	
	public static void main(String[] args) {
//		Write a program that stores the following strings in an ArrayList and saves all the palindromes in another ArrayList.
//		“karan”, “madam”, ”tom”, “civic”, “radar”, “sexes”, “jimmy”, “kayak”, “john”,  “refer”, “billy”, “did”
		
		ArrayList<String> words = new ArrayList<String>();
		words.add("karan");
		words.add("madam");
		words.add("tom");
		words.add("civic");
		words.add("radar");
		words.add("sexes");
		words.add("jimmy");
		words.add("kayak");
		words.add("refer");
		words.add("billy");
		words.add("did");
		
		getPalindromes(words);
	}
	
	static ArrayList<String> getPalindromes(ArrayList<String> list) { //returns a subset of the palindromes in the ArrayList, if any.
		System.out.println("List Size is: " + list.size());
		for(int i = 0; i < list.size(); i++) {
			if(isPalindrome(list.get(i))) palindromes.add(list.get(i));
		}
		
		return palindromes;
	}
	
	static boolean isPalindrome(String s){
		if(s.equals(new StringBuffer(s).reverse().toString())) return true;
		
		System.out.print(s + ", ");
		return false;
	}

}
