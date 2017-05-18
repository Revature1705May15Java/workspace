package com.revature_wk1.nested;

public class MemberInner 
{
	int data = 50;
	
	static int staticdata = 30;
	
	class Inner
	{
		void message()
		{
			System.out.println("In inner method. Data is " + data);
			System.out.println("static data is " + staticdata);
		}
	}
	
	public static void main(String[] args)
	{
		MemberInner m = new MemberInner();
		Inner i = m.new Inner();
		
		i.message();
	}
}
