package nestedPractice;

//the class must be outside the public class to be used anonymously 

abstract class Shh
{
	abstract void sneak(); 
}

class Animal
{
	void eat()
	{
		System.out.println("yay");
	}
}

public class AnonInner 
{
	public static void main(String[] args)
	{
		Shh s = new Shh() //anon 
		{
			@Override
			void sneak()
			{
				System.out.println("heh");
			}
		};
		
		s.sneak(); 
		
		Animal a = new Animal(); 
		a.eat();
		
		Animal b = new Animal()
		{
			void eat()
			{
				System.out.println("not yay");
			}
		};
		b.eat();
		
	}
}
