package com.randomexercises.nested;


public class A {
	
	static int data=30;
	
	static class B{
//		static int data=0;
		void message(){
//			System.out.println("In my inner class! Data is "+data);
//			System.out.println(x);//cannot reference x because it is not static
		}
	}
	
	public static void main(String[] args) {

		A.B objectOfB=new A.B();
		B objB = new B();
		//in order to create an object of B, we must use [outerclass].[innerclass]
		
//		objB.message();
//		objectOfB.message();
	}

}
class C{
	A a = new A();
	static A.B ob = new A.B();
	public static void main(String[] args) {
//		ob.message();
		byte numbyte=;
		
	}
}
