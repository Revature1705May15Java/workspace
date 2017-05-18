package com.randomexercises.nested;

public class MemberInner {
	int data=50;
	static int staticdata=100;
	class Inner{
		void message(){
			System.out.println("in inner method, data is "+data);
			System.out.println("static data is "+staticdata);
		}
	}
//	static class StaticInner{
//		void message(){
//			System.out.println("in inner method, data is "+data);
//			System.out.println("static data is "+staticdata);
//		}
//	}
	
	public static void main(String[] args) {
		MemberInner m = new MemberInner();
		Inner i= m.new Inner();
		i.message();
		
	}

}
