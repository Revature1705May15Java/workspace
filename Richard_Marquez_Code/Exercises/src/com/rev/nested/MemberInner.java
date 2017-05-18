package com.rev.nested;

// non-static inner

public class MemberInner {
	int data = 50;
	static int staticData = 100;
	
	class Inner {
		int data = 25; // shadow of outer data; THIS is the value used
		void message() {
			System.out.println("in inner method data is: " + data);
			System.out.println("static data is: " + staticData);
		}
	}
	
	static class StaticInner {
		void message() {
			// System.out.println("in inner method data is: " + data); // cannot access non-static instance var
			System.out.println("static data is: " + staticData);
		}
	}
	
	public static void main(String[] args) {
		MemberInner m = new MemberInner(); // outer class
		MemberInner.Inner n = m.new Inner(); // inner class
		
		n.message();
	}
}
