package exercise1;

import java.util.ArrayList;

public class CheckPrime {
	public static void main(String[] args) {
		ArrayList<Integer> input = new ArrayList<Integer>();
		for (int i = 0; i < 100; i++)
		{
			input.add(i+1);
		}
		ArrayList<Integer> output= new ArrayList<Integer>();
		output = intArrayPrime(input);
		output.toString();

	}
	public static boolean primeCheck(int input){
		if(input == 1 || input == 0){return false;}
		else if(input == 2 || input == 3 ){ return true;}
		else{
			for(int i=2; i< input; i++){
				if(input%i ==0){
					//System.out.println(input + "Number is not prime\n " );
					return  false;
				}
			}
		}
		return true;
	}
	public static ArrayList<Integer> intArrayPrime(ArrayList<Integer> input){
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < input.size(); i++)
		{
			if(primeCheck(input.get(i))){
				System.out.print((i+1)+ ", ");
				result.add(input.get(i));
			}
		}
		return result;
	}
}
