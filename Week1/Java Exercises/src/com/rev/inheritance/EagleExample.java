package com.rev.inheritance;
interface Flyer{
	String getName();
}
class Bird implements Flyer{
	public String name;
	public Bird (String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}	
}

class Eagle extends Bird{
	String name;
	public Eagle(String name){
		super(name);
	}}
// which three of the following lines of code will print the name of the Eagle object
public class EagleExample {
	public static void main(String[] args) throws Exception {
		Flyer f = new Eagle("Bald Eagle");
		//	System.out.println(f.name); //1
		//	System.out.println(f.getName());//2
		//	System.out.println(((Eagle)f).name); //3
		//	System.out.println(((Bird)f).getName()); //4
		//	System.out.println(Eagle.name); //5
		//	System.out.println(Eagle.getName(f)); //6




	}

	public void stop(){
		this.go();
	}

	public void go(){
		System.out.println("do stuff");
	}


}




/*
 * 1 = N 
 * 2 = Y
 * 3 = Y
 * 4 = Y
 * 5 = N - name is not a static field in class Eagle
 * 6 = N - no get name method in eagle
 * 
 * while accessing a method or variable, the compiler will only 
 * allow you to access a method or var that is visible through the class of the reference
 * so for option 1, the reference of f is Flyer, Flyer has no field named "name", thus it will not compile. 
 * But when you cast f to a bird or eagle, the compuler sees that it soes so the .name will work fine
 * 
 */






