package com.rev.nested;

public class MemberInner {
	int data = 50;
	static int staticdata = 100;
	
	class Inner{
		void message(){
			
			
			System.out.println("In inner method, data is: "+data);
			System.out.println("Static data is "+ staticdata);
		}
	}
	
	static class StaticInner{
		void message(){
			//System.out.println("In inner method, data is: "+data); CANT REFERENCE NON STATIC CONTENT
			System.out.println("Static data is "+ staticdata);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//OUTER INNER NOT SUPER AND SUB
		MemberInner m = new MemberInner();
		Inner i = m.new Inner();
		
		i.message();
		
		

	}

}
