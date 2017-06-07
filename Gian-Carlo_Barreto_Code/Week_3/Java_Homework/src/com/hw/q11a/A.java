package com.hw.q11a;

import com.hw.q11b.B;

/**
 * Write a program that would access two float-variables from a class that exists in another package. 
 * Note, you will need to create two packages to demonstrate the solution.
 * @author Gian-Carlo
 *
 */
public class A {

	public static void main(String[] args) {
		B obj = new B();
		System.out.println(obj.a + " " + obj.b);
	}

}
