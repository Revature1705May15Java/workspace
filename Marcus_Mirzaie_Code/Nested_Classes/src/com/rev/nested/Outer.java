package com.rev.nested;

public class Outer {
	/*  Class Outer will be the outer class to a static class Nested
	 * 
	 */
	
	static int data = 30;
	
	static class Nested{
		void message(){
			System.out.println("In my inner class! Data is " + data);
		}
	}
	
	public static void main(String[] args){
		Outer.Nested obj = new Outer.Nested();
		
		obj.message();
	}
}
