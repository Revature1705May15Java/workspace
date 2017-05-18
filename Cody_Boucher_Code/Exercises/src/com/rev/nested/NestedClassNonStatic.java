package com.rev.nested;

public class NestedClassNonStatic {
	int data = 50;
	static int staticData = 100;
	
	class Inner {
		void message() {
			System.out.println("in inner method data is " + data);
			System.out.println("static data is " + staticData);
		}
	}

	public static void main(String[] args) {
		NestedClassNonStatic n = new NestedClassNonStatic();
		NestedClassNonStatic.Inner i = n.new Inner();
		i.message();
	}

}
