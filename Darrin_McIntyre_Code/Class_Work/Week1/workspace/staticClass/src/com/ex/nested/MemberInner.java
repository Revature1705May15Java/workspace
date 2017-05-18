package com.ex.nested;

//non-static inner class

public class MemberInner {
	int data = 50;
	static int staticdata = 50;
	
	class Inner{
		void message(){
			System.out.println("In inner method, data is " + data);
			System.out.println("In inner method, staticdata is " + staticdata);
		}
	}
	
//	static class StaticInner{
//		void message(){
//			System.out.println("In inner method, data is " + data); // Can't access non-static variable from static class.
//			System.out.println("In inner method, staticdata is " + staticdata);
//		}
//	}
	
	public static void main(String[] args) {
		MemberInner m = new MemberInner();
		
		Inner i = m.new Inner();
		// Outside of the class we would need to do MemberInner.Inner
		i.message();
		
	}

}
