package com.rev.nested;

public class A {
	//Class a will be the outer class to a static class B
	
	static int sdata = 30;
	static int data = 30;
	
	static class B{
		
		//static int data = 10; //this will overwrite the original THIS IS CALLED SHADOWING
		 void message(){
			System.out.println("In my inner class, Data = "+sdata);
			System.out.println(this.getClass());
		}
	}
	
	public static void main(String[] args){
		A.B objB = new A.B();
		//B objB = new B();
		//in order to create an object of B, we must use A.B NAMING CONVENTION [OUTER CLASS].[INNER CLASS]
		
		objB.message();
		
	}

}

class C {
	A a = new A();
	//B b = new B(); DOES NOT WORK
	A.B aa = new A.B();
	
	public static void main(String[] args) {
		A.B t = new A.B();
		//System.out.println(getClass());
		t.message();
		
	}
}
