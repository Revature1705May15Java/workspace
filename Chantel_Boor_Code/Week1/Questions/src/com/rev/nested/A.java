package com.rev.nested;

public class A 
{
	/*class A will be the outer class to a static class b
	 * 
	 * static inner class
	 */
	
	static int data = 30;
	
	int x = 5;
	
	static class B
	{
		static int data = 0;
		
		void messge()
		{
			System.out.println("In my inner class! Data is " + data);
			//System.out.println(x); // cannot reference x bc it is not static
		}
	}
	
	public static void main(String[] args) 
	{
		A.B objectOfB = new A.B();
		B objB = new B();
		//in order to create an object of B, we must us outerclass.innerclass
		
		
		objB.messge();
		objectOfB.messge();
	}

}

class C
{
	A a = new A();
	//B b = new B(); //can't access by itself outside of its outer class
	
	static A.B ab = new A.B();
	
	public static void main(String[] args) 
	{
		ab.messge();
	}
	
}
