package com.rev.nested;
// non-static inner class example 
public class MemberInner {
	int data = 50;
	static int staticdata =100;
	class Inner{
		int data = 25;//shadowing
		void message() {
			System.out.println("in inner method data is " + data);
			System.out.println("static data is " + staticdata);
		}
	}
//	static class StaticInner{
//		void message() {
//			System.out.println("in inner method data is " + data);
//			System.out.println("static data is " + staticdata);
//		}
//	}
	
	public static void main(String[] args) {
		MemberInner m = new MemberInner();
		Inner i = m.new Inner();
		
		i.message();
	}
}
