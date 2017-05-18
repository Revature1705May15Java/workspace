package exercise1;

import java.util.ArrayList;

public class evenOdd {
	public static void main(String[] args) {
		ArrayList<Integer> input = new ArrayList<Integer>();
		for(int i =0; i<10; i++){
			input.add(i+1);
		}
		System.out.println(input.toString());
		int evenSum =0;
		int oddSum = 0;
		for(int i =0; i<input.size(); i++){
			if(input.get(i)%2==0)
			evenSum+=input.get(i);
			else{
				oddSum+=input.get(i);
			}
		}
		System.out.println("Sum of even numbers is "+ evenSum+"\n");
		System.out.println("Sum of odd numbers is "+ oddSum+"\n");
		for(int i =0; i<input.size(); i++){
			if(!CheckPrime.primeCheck(input.get(i))){
				input.remove(i);
			}
		}
		System.out.println("Prime numbers are: " + input.toString());
	}
}
