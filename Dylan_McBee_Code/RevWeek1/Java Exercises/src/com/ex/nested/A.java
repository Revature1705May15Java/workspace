package com.ex.nested;

public class A {

	/*Class A will be the outer class to a static class B
	 * 
	 */
	static int data = 30;
	
	int x = 35;
	
	static class B{
		//static int data = 0;
		void message(){
			System.out.println("In my inner class! Data is: " + data);
			System.out.println(this.getClass());
			//System.out.println(x); //Cannot reference x because it is not static.
		}
	}
	
	public static void main(String[] args) {
		A.B objectOfB = new A.B();
		B objB = new B();
		
		objB.message();
		// in order to create an object of B, we must use [outerclass].[innerclass]
		
		objectOfB.message();
	}
}
class C{
	A a = new A();
	// B b = new B(); // not possible
	static A.B aB = new A.B();
	
	public static void main(String[] args) {
		aB.message();
	}
}