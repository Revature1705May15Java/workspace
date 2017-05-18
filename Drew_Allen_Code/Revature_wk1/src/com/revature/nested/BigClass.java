package com.revature.nested;

abstract class Box
{
	abstract void shape();
}

public class BigClass 
{
	int sides = 0;
	
	class Circle
	{
		void shape()
		{
			System.out.println("I HAVE " + sides + " SIDES!");
			System.out.println("I'M ROUND BITCH!");
		}
	}
	
	void math()
	{
		class PI
		{
			int returnPI(int PI)
			{
				PI = (int) Math.PI;
				System.out.println("I'm PI " + PI);
				return PI;
			}
		}
		
		PI pi = new PI();
		pi.returnPI((int)Math.PI);
	}
	
	public static void main(String[] args) 
	{
		Box box = new Box()
		{
			@Override
			void shape()
			{
				System.out.println("I'm a flat box");
			}
		};
		box.shape();
		
		BigClass bcPI = new BigClass();
		bcPI.math();
		
		BigClass bcCir = new BigClass();
		Circle c = bcCir.new Circle();
		c.shape();
		
	}

}
