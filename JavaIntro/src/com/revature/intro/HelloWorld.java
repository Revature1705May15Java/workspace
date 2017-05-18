package com.revature.intro;

//import java.util.Scanner;

public class HelloWorld {
	
//	static int k = 0;
//	static {
//		k = 10/0;
//	}
	
	public static void main(String[] args) {
		try {
			System.exit(0);
		}
		finally {         
			System.out.println("finally is always executed!");      
		}
	}
	
	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//		System.out.println("Hello World!");
//		Scanner input = new Scanner(System.in);
//		System.out.println("Enter an integer");
//		int x = input.nextInt();
//		
//		// switch
//		switch(x) {
//		case(1):
//			System.out.println("right");
//			break;
//		case(2):
//			System.out.println("wrong");
//			break;
//		default:
//			System.out.println("default");
//		}
//		
//		// if-else if-else
//		if (x > 10) {
//			System.out.println("greater than 10");
//		} else if (x == 10) {
//			System.out.println("equal to 10");
//		} else {
//			System.out.println("less than 10");
//		}
//		
//		// short-circuiting
//		int b = 0;
//		if (x == 1 && b++ == 0) {
//			// b will only be incremented if x is equal to 1
//		}
//	
//		// for
//		int[] list = new int[10];
//		for (int i = 0; i < x; i++) {
//			System.out.println("iteration number " + i);
//			list[i] = i;
//		}
//		
//		// for each
//		for(int p: list) {
//			System.out.println(p*p);
//		}
//		
//		// do while
//		do { x++; } while (x < 10);
//		
//		// while
//		while (x > 10) { x--; }
//	}

}

// methods can be implemented in an interface but doing so makes them the default method, whatever that means

// a marker interface has no implementation (no methods or fields)
// ex: Serializable, Cloneable,

// method that is invoked depends on the class of the actual object that is instantiated via the new keyword
// instance methods are overridden while instance variables are hidden