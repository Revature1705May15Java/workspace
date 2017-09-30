
public class TestingStuff {
	public static void main(String[] args) {
		// Find a number in the Fibonacci sequence.
		System.out.println(fib(0));
		System.out.println(fib(1));
		System.out.println(fib(2));
		System.out.println(fib(5));
		System.out.println(fib(10));
		System.out.println(fib(11));
		System.out.println(fib(12));
		
		// Reverse a string without .reverse or using a temp String.
		String str = "Hello World";
		reverseMe(str);
		
		// Is a number prime?
		int[] nums = {1,2,3,5,7,13,15,17,37,38,39,40};
		
		for(int x : nums){
			isPrime(x);
		}
	}
	
	public static int fib(int num){
		if(num == 0) return 0;
		if(num <= 2) return 1;
		else {
			return fib(num-1) + fib(num-2);
		}
	}
	
	public static void reverseMe(String str){
		for(int i = str.length(); i > 0; i--){
			System.out.print(str.charAt(i-1));
		}
		System.out.println();
	}
	
	public static void isPrime(int x){
		if(x==1) {
			System.out.println(x + " is not prime.");
			return;
		}
	    for(int i=3; i*i <= x; i += 2) {
	        if(x%2 == 0 || x%i == 0){
	        	System.out.println(x + " is not prime.");
	        	return;
	        }
	    }
	    System.out.println(x + " is prime!");
	}
}
