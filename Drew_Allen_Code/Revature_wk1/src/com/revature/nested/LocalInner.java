package com.revature.nested;

public class LocalInner 
{
	private int data = 45;
	
	void display()
	{
		class Local
		{
			void message()
			{
				System.out.println("In inner class method. Data is " + data);
			}
		}
		
		Local l = new Local();
		l.message();
	}
	
	public static void main(String[] args) 
	{
		LocalInner outer = new LocalInner();
		outer.display();
	}
}
