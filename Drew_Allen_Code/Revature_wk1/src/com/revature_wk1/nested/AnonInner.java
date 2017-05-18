package com.revature_wk1.nested;

abstract class AnonPerson
{
	abstract void eat();
}


class Animal
{
	void eat() 
	{
		System.out.println("NOM NOM NOM");
	}
}

public class AnonInner {

	public static void main(String[] args) 
	{
		AnonPerson ap = new AnonPerson()
		{
			@Override
			void eat() 
			{
				System.out.println("yum");
				
			}
			
		};
				
		ap.eat();
		
		Animal ani = new Animal();
		ani.eat();
		
		Animal ano = new Animal()
		{
			void eat()
			{
				System.out.println("MUNCH MUNCH");
			}
		};
		ano.eat();
	}

}
