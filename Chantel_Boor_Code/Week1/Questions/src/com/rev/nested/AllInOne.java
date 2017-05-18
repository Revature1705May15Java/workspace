package com.rev.nested;

//create a class that has all nested class types
abstract class Stars
{
	void color() 
	{
	}
}

public class AllInOne 
{
	int size = 12;
	String type = "small";
	static int x = 12;
	
	
	class Inner
	{
		void data()
		{
			int size = 33;
			
			System.out.println("in Inner");
			System.out.println(size);
		}
	}
	
	static class StaticInner
	{
		void message()
		{
			System.out.println("in static " +x);
			
			//can't use non static here
		}
	}

	void display ()
	{
		class Local
		{
			void message()
			{
				System.out.println("in Local");
				System.out.println(type+ " ");
				
				
			}
		}
		
		//in display
		Local l = new Local();
		l.message();
	}
	
	
	
	public static void main(String[] args) 
	{
		
		Stars s = new Stars()
		{
			 void color()
			{
				System.out.println("in anon");
				System.out.println("blue");
			}
		};
		
		s.color();
		
		AllInOne a = new AllInOne();
		Inner i = a.new Inner();
		StaticInner si = new StaticInner();
		AllInOne b = new AllInOne();
		
		i.data();
		b.display();
		si.message();
		
		
		
		
				
				
	}
}
