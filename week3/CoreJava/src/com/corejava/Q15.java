package com.corejava;
/*
Write a program that defines an interface
 having the following methods: 
 addition, subtraction, multiplication, and division.  
 Create a class that implements this interface and 
 provides appropriate functionality to carry out the 
 required operations. Hard code two operands in a test 
 class having a main method that calls the 
implementing class.
 */
public class Q15 implements Q15I{

	public double addNums(double num1, double num2) {
		return num1+num2;
	}
	public double subNums(double num1, double num2) {
		return num1-num2;
	}
	public double multNums(double num1, double num2) {
		return num1*num2;
	}
	public double divNums(double num1, double num2) {
		return num1/num2;
	}
}
interface Q15I{
	double addNums(double num1,double num2);
	double subNums(double num1,double num2);
	double multNums(double num1,double num2);
	double divNums(double num1,double num2);
}
class Q15A{
	public static void main(String[] args) {
		double num1=3;
		double num2=5;
		Q15 q=new Q15();
		System.out.println(q.addNums(num1,num2));
		System.out.println(q.subNums(num1,num2));
		System.out.println(q.multNums(num1,num2));
		System.out.println(q.divNums(num1,num2));	
	}
}