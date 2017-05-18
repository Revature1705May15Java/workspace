package com.rev.nested;

/*
 * a class that has no name is known as the anomynous class
 * it should be used if you have to override the method 
 * of a class or an interface
 */

abstract class Person
{
	abstract void eat ();
}

class Animals
{
	void eat()
	{
		System.out.println("animals eat");
	}
}


public class AnonInner 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		Person p = new Person()
				{

					@Override
					void eat()
					{
						System.out.println("yum");
						
						
					}
			
				};
				
		p.eat();
		
		Animals a = new Animals();
		a.eat();
		
		Animals b = new Animals()
		{
			void eat()
			{
				System.out.println("munch munch");
				
				super.eat();
			}
		};
		
		b.eat();

	}

}
