package com.rev.nested;

// inner non static class


public class MemberInner {

	int data = 50;
	static int staticData = 100;
	
	class Inner
	{
		
		int data = 25; //shadowing
		
		void message ()
		{
			System.out.println("in inner method data is "+data);
			System.out.println("static data is "+ staticData);
		}
	}
	
	
	public static void main(String[] args)
	{
		MemberInner m = new MemberInner();
		Inner i = m.new Inner();
		
		
		i.message();

	}

}
