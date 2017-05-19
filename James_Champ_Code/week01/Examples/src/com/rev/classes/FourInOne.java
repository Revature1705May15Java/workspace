package com.rev.classes;

public class FourInOne {
	static int intA = 22;
	private int intB = 33;
	
	static class StaticNested {
		void message() {
			System.out.println("In StaticNested class. intA is: " + intA);
		}
	}
	
	class MemberInner {
		void message() {
			System.out.println("In MemberInner class. intB is: " + intB);
		}
	}
	
    private static void doSomething() {
    	class LocalInner {
    		void message() {
    			System.out.println("In inner class method. intA is: " + intA);
    		}
    	}
    	
		LocalInner l = new LocalInner();
		l.message();
    }
    
	interface AnonTest {
		void anonMethod();
	}
	
	private static void anonMessage(AnonTest t) {
		System.out.println("In FourInOne.anonMessage()");
		t.anonMethod();
	}
	
	public static void main(String[] args) {
		anonMessage(new AnonTest() {
			public void anonMethod() {
				System.out.println("In anonymously created method");
			}
		});
		
		doSomething();
		
		FourInOne fio = new FourInOne();
		MemberInner mInner = fio.new MemberInner();
		mInner.message();
		
		FourInOne.StaticNested sn = new FourInOne.StaticNested();
		sn.message();
	}
}
