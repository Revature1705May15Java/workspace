package exercise1;

import java.util.ArrayList;

public class evenOdd {
	public static void main(String[] args) {
		ArrayList<Integer> input = new ArrayList<Integer>();
		for(int i =0; i<10; i++){
			input.add(i+1);
		}
		System.out.println(input.toString());
		evenSum(input);
		oddSum(input);
		input = notPrimeArray(input);

	}
	public static int evenSum(ArrayList<Integer> input){
		int sum=0;
		for(int i =0; i<input.size(); i++){
			if(input.get(i)%2==0){
				sum+=input.get(i);
			}
		}
		System.out.println("Sum of even numbers is "+ sum +"\n");
		return sum;
	}
	
	public static int oddSum(ArrayList<Integer> input){
		int sum=0;
		for(int i =0; i<input.size(); i++){
			if(input.get(i)%2==1){
				sum+=input.get(i);
				
			}
		}
		System.out.println("Sum of odd numbers is "+ sum +"\n");
		return sum;
	}
	
	public static ArrayList<Integer> notPrimeArray(ArrayList<Integer> input){
//		System.out.println(input.get(2));
//		System.out.println(CheckPrime.primeCheck(input.get(2)));
		for(int i =0; i<input.size(); i++){
//			System.out.println(input.get(i));
//			System.out.println(CheckPrime.primeCheck(input.get(i)));
			if(CheckPrime.primeCheck(input.get(i))){	
				input.remove(i);
				i--;
			}				
		}
		System.out.println("Not prime numbers are: " + input.toString());
		return input;
	}
}
