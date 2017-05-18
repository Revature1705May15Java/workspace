package nestedPractice;

public class NestedClasses 
{
	static String str = "test"; 
	
	public static void main(String[] args)
	{
		NestedClasses.StaticClass ns = new NestedClasses.StaticClass(); 
		ns.hello();
		
		NestedClasses n = new NestedClasses(); 
		MemberClass m = n.new MemberClass(); 
		m.hi(); 
		
		n.display();
		
		AnonClass a = new AnonClass()
		{
			void whisper()
			{
				System.out.println("A n o n class");
			}
		};
		a.whisper(); 
	}
	
	static class StaticClass
	{
		void hello()
		{
			System.out.println("S t a t i c class");
		}
	}
	
	class MemberClass
	{
		void hi()
		{
			System.out.println("M e m b e r class");
		}
	}
	
	void display()
	{
		class Local
		{
			void greetings()
			{
				System.out.println("L o c a l class");
			}
		}
		Local l = new Local(); 
		l.greetings();
	}
	
}

class AnonClass
{
	void whisper()
	{
		System.out.println("...");
	}
}
