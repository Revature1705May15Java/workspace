package nestedPractice;

public class MemberInner //non static inner class
{
	int data = 50; 
	static int ex = 44; 
	
	class Inner
	{
		void message() 
		{
			System.out.println("inner member class says data is " + data); //this works
			System.out.println("static ex is " + ex);  //static members from enclosing class also work 
		}
	}
	
	public static void main(String[] args) 
	{
		MemberInner mi = new MemberInner();
		Inner mii = mi.new Inner(); 
		
		mii.message();
	}

}
