package com.rev.nested;

public class NestedClass {
	
	static int data = 30;
	
	static class InnerClass {
		void message() {
			System.out.println("in my inner class, data is " + data);
		}
	}
	
	
	public static void main(String[] args) {
		NestedClass.InnerClass objectOfInnerClass = new NestedClass.InnerClass();
		InnerClass in = new InnerClass();
		
		in.message();
		
		objectOfInnerClass.message();
	}
}
