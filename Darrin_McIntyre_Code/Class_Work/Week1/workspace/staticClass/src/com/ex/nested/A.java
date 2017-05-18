package com.ex.nested;

public class A {
	// Class A will be the outer class to a static class B
	
	static int data = 30;
	
	int x = 35;
	
	static class B{
		void message(){
			System.out.println("In my inner class. Data is " + data);
			System.out.println(this.getClass());
		}
	}
	
	public static void main(String[] args) {
		A.B objectOfB = new A.B();
		B objB = new B();
		// in order to create an object of B, we must use [outterclass].[innerclass]
		
		objectOfB.message();
		objB.message();
	}
}

class C{
	A a = new A();
	//B b = new B(); illegal
	static A.B b = new A.B();
	
	public static void main(String[] args) {
		b.message();
	}
}