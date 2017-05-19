package com.rev.classes;

public class NestedStatic {
	// Nested will be outer class to static class B
	
	static int data = 20;
	int x = 33;
	
	static class B {
		static int data = 44;
		void message() {
			System.out.println("In my inner class.  Data is: " + data);
			
			// Cannot reference non-static fields from outer class
			// System.out.println("x: " + x);
		}
	}
	
	public static void main(String[] args) {
		// Must use [OuterClass].[InnerClass] to create class object
		NestedStatic.B objectOfB = new NestedStatic.B();
		objectOfB.message();

		// Also valid:
		B objB = new B();
		objB.message();
	}
}

class C {
	NestedStatic a = new NestedStatic();
	// Not valid:
	// B b = new B();
	
	// Valid:
	NestedStatic.B b = new NestedStatic.B();
}	