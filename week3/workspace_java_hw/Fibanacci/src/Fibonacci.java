
public class Fibonacci {

	public static void main(String[] args) {
		// F(n) = F(n-1) + F(n-2)
		System.out.println("Fibonacci Number: " + getFibonacci(6));
	}
	
	public static int getFibonacci(int n){
		int result = 0;
		
		if(n < 0) return -1; // for negative numbers, returns -1 to signal incorrect data entry.
		if(n == 0) return 0;
		if(n == 1 || n == 2) return 1;
		
		result = getFibonacci(n-1) + getFibonacci(n-2);
		return result;
	}

}
