package week1.assignment1.q19;

import java.util.ArrayList;

/*
 * Create an ArrayList and insert integers 1 through 10. 
 * Display the ArrayList. 
 * Add all the even numbers up and display the result. 
 * Add all the odd numbers up and display the result. 
 * Remove the prime numbers from the ArrayList and print out the remaining ArrayList.
 */
public class ArrayListQuestion {
	public static void main(String[] args) {
		// Create an ArrayList and insert integers 1 - 10
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (int i = 1; i <= 10; i++)
			numbers.add(i);
		
		System.out.print("Display the ArrayList: ");
		displayList(numbers);
		System.out.println();
		System.out.println("Sum of even numbers: " + addEvenNumbers(numbers));
		System.out.println("Sum of odd numbers: " + addOddNumbers(numbers));
		
		System.out.print("Display the composite numbers: ");
		// Prints each number in the numbers ArrayList using a lambda expression
		removePrimes(numbers).forEach(n->System.out.print(n + " "));
	}
	
	/*
	 * Display an ArrayList
	 * @param an ArrayList
	 */
	public static void displayList(ArrayList<Integer> numbers) {
		for (int num : numbers)
			System.out.print(num + " ");
	}
	
	/*
	 * Add all the even numbers up.
	 * @param an ArrayList
	 */
	public static int addEvenNumbers(ArrayList<Integer> numbers) {
		int sum = 0;
		for (int num : numbers) {
			if (num % 2 == 0)
				sum += num;
		}
		return sum;
	}
	
	/*
	 * Add all the odd numbers up.
	 * @param an ArrayList
	 */
	public static int addOddNumbers(ArrayList<Integer> numbers) {
		int sum = 0;
		for (int num : numbers) {
			if (num % 2 != 0)
				sum += num;
		}

		return sum;
	}
	
	/*
	 * Remove the prime numbers from the ArrayList and print out the remaining ArrayList.
	 */
	public static ArrayList<Integer> removePrimes(ArrayList<Integer> numbers) {
		ArrayList<Integer> composites = new ArrayList<Integer>();
		for (int num : numbers) {
			boolean isComposite = false;
			for (int i = 2; i <= Math.sqrt(num); i++) {
				if (num % i == 0) {
					isComposite = true;
				}
			}
			if (isComposite)
				composites.add(num);
		}
		return composites;
	}
}
