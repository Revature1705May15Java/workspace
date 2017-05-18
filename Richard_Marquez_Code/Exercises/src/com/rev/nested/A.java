package com.rev.nested;

// static nested

public class A {
	// Class A will b the outer class to a static class B
	
	static int data = 30;
	
	static class B {
//		static int data = 15;
		
		void message() {
			System.out.println("In inner class. Data is " + data);
		}
	}
	
	public static void main(String[] args) {
		A.B objOfB = new A.B();
		// in order to create obj of B, must use [outer].[inner]
		
		objOfB.message();
	}
}

class C {
	A a = new A();
	// B b = new B(); // not possible
	A.B aB = new A.B();
}