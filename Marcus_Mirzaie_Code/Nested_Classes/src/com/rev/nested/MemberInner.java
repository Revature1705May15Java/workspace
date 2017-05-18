package com.rev.nested;

// non-static inner class example

public class MemberInner {
	int data = 50;
	static int staticdata = 100;
	class Inner{
		void message(){
			System.out.println("in iner method. data is " + data);
			System.out.println("static data is " + staticdata);
		}
	}
	

}
