package com.rev.myNested;

//Local Anonymous
abstract class Glow{
	abstract void shine();
	
}

public class Z {
	
	static int newData = 20;
	int dataa = 10;
	
	//MemberInner
	class inside{
		void go(){
			System.out.println("This is a member Inner call");
		}
		
	}
	
	//Local Inner Class
	void show(){
	class Local{
		void tell(){
			System.out.println("This is the LOCAL inner class, data value: "+dataa);
		}
		
	}
	
	Local l = new Local();
	l.tell();
	}
	
	//STATIC NESTED CLASS
	static class Y{
		void message(){
			System.out.println("In my inner class, Data = "+newData+"...and this is an example of ");
			//System.out.println(this.getClass());
		}
		
		
		public static void main(String [] args){
			//STATIC NESTED
			Z.Y INSO = new Z.Y();//INSO = Inner Static Object
			INSO.message();
			
			
			
			//LOCAL ANON EXAMPLE
			Glow g = new Glow(){
				@Override
				void shine(){
					System.out.println("Brightness = 100 this is an example of LOCAL ANON");
					
				}
			};
		//LocalInner
		Z outer = new Z();
		
		outer.show();
		System.out.println("By the way this is a local inenr non-static class call...");	
		
		//MemberInner
		
		Z memberInner = new Z();
		inside i = memberInner.new inside();
		i.go();
		
		}
		
	}

}
