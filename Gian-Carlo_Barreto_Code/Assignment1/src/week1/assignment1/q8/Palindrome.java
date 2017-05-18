package week1.assignment1.q8;

import java.util.ArrayList;

/*
 * Q8. Write a program that stores the following strings in an ArrayList and saves all the palindromes in another ArrayList.
 * “karan”, “madam”, ”tom”, “civic”, “radar”, “sexes”, “jimmy”, “kayak”, “john”,  “refer”, “billy”, “did”
 */
public class Palindrome {
	public static void main(String[] args) {
		ArrayList<String> words = new ArrayList<String>();
		
		// Add the following words to the ArrayList
		// “karan”, “madam”, ”tom”, “civic”, “radar”, “sexes”, “jimmy”, “kayak”, “john”,  “refer”, “billy”, “did”
		words.add("karan");
		words.add("madam");
		words.add("tom");
		words.add("civic");
		words.add("radar");
		words.add("sexes");
		words.add("jimmy");
		words.add("kayak");
		words.add("john");
		words.add("refer");
		words.add("billy");
		words.add("did");
		
		ArrayList<String> palindromes = findPalindromes(words);
		for (String p : palindromes)
			System.out.println(p);
	}
	
	/*
	 * Returns a list of palindromes
	 */
	public static ArrayList<String> findPalindromes(ArrayList<String> words) {
		ArrayList<String> palindromes = new ArrayList<String>();
		
		for (String word : words) {
			StringBuilder rev = new StringBuilder(word);
			if ((rev.reverse().toString()).equals(word))
				palindromes.add(word);
		}
		
		return palindromes;
	}
}
