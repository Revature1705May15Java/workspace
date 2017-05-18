package nestedPractice;

public class OuterClass 
{
	static int data = 30; //this works in Inner unless overwritten 
	int x = 2; //this doesn't work in Inner
	
	static class InnerClass
	{
//		static int data = 0; //this works in Inner
		
		void message()
		{
			System.out.println("inner class says data is " + data);
		}
	}
	public static void main(String[] args)
	{
		OuterClass.InnerClass innerOb = new OuterClass.InnerClass(); 
		InnerClass i = new InnerClass(); 
		// to create objects of inner classe, you have to use [out].[in]
		
		innerOb.message(); 
		i.message();
	}
}

class AnotherOne
{
	OuterClass o = new OuterClass(); 
//	InnerClass i = new InnerClass(); //won't work 
	static OuterClass.InnerClass oi = new OuterClass.InnerClass(); 
	
	public static void main(String[] args) //this will never be run 
	{
		oi.message();
	}
}