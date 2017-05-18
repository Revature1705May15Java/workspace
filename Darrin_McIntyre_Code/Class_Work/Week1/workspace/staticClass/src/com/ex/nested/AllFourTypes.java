package com.ex.nested;

// All 4 types of nested classes
abstract class AnonymousClass{
	abstract void display();
}

public class AllFourTypes {
	static int staticData = 41;
	int data = 17;
	
	
	static class StaticNested{
		static void message(){
			System.out.println("In StaticNested, data is " + staticData + "\n");
		}
	}
	
	class MemberInner{
		void message(){
			System.out.println("In MemberInner method, data is " + staticData);
			System.out.println("This method can also print non-static data: " + data + "\n");
		}
	}
	
	void LocalInner(){
		class Local{
			void message(){
				System.out.println("In LocalInner class method. data is " + staticData);
				System.out.println("This method can also print non-static data: " + data + "\n");
			}
		}
		
		Local l = new Local();
		l.message();
	}
	
	public static void main(String[] args) {
		AnonymousClass aC = new AnonymousClass(){ // anonymous class

			@Override
			void display() {
				System.out.println("In an anonymous class! \n");
			}
			
		};
		aC.display(); //anonymous class
		
		StaticNested sN = new StaticNested();
		sN.message();
		
		AllFourTypes aft = new AllFourTypes();
		MemberInner mI = aft.new MemberInner();
		mI.message();
		
		aft.LocalInner();
		
		
	}
	
}
