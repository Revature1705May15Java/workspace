package com.rev.ex18;

public class Main {

	public static void main(String[] args) {
		ConcreteStringMutator csm = new ConcreteStringMutator();
		
		String s = "MixedCase";
		System.out.println(csm.hasUpperCase(s));
		
		s = "same_case";
		System.out.println(csm.hasUpperCase(s));
		
		System.out.println(csm.toUpperCase(s));
		
		System.out.println(s.hashCode());
		System.out.println(csm.toInt(s));
	}
}
