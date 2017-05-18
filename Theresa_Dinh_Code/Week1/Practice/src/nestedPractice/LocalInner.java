package nestedPractice;

public class LocalInner 
{
	private int data = 50; 
	
	void display()
	{
		class Local
		{
			void message()
			{
				System.out.println("inner local method says " + data);
			}
		}
		Local l = new Local(); 
		l.message(); 
		
	}
	
	public static void main(String[] args)
	{
		LocalInner li = new LocalInner(); 
		li.display();
	}
}
