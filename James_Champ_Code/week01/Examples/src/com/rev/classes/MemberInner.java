package com.rev.classes;
// non-static inner class example
public class MemberInner {
	private int data = 49;
	static int staticData = 33;
	
	class Inner {
		void message() {
			System.out.println("In inner method. Data is: " + data);
			System.out.println("Static data is: " + staticData);
		}
	}
	
	public static void main(String[] args) {
		MemberInner m = new MemberInner();
		Inner inner = m.new Inner();
		
		// This also works:
		MemberInner.Inner i = m.new Inner();
		
		inner.message();
		i.message();
	}
}
