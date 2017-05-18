package com.rev.nested;

//non static inner class example
public class MemberInner {
	int data = 50;
	static int staticdata = 20;
	
	class inner{
		void message(){
			System.out.println("In my outer class! Data is " + data);
			System.out.println("staic Data is " + staticdata);
		}
	}
	
//	class staticinner{
//		void message(){
//			System.out.println("In my outer class! Data is " + data);
//			System.out.println("staic Data is " + staticdata);
//		}
//	}
	
	public static void main(String[] args) {
		// How to declare a non static inner class
		MemberInner m = new MemberInner();
		inner i = m.new inner();
		
		i.message();
	}

}
