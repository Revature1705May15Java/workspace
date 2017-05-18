package q2q;

import java.util.ArrayList;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fibonacci fib = new Fibonacci();
		fib.fibonacci(0,1,25);
	}

	ArrayList<Integer> aList = new ArrayList<Integer>();
	
	public ArrayList<Integer> fibonacci(int fibN1, int fibN2, int fibLim){
		fibLim -= 1;
		aList.add(fibN1);
		if(fibLim <= 0){
			return aList;
		}
		else{
			fibonacci(fibN2,addFib(fibN1,fibN2),fibLim);
			return aList;
		}
	}
	public int addFib(int fibN1, int fibN2){
		return fibN1+fibN2;
	}

}
