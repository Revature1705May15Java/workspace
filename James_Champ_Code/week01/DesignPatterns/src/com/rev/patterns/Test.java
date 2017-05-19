package com.rev.patterns;

public class Test {
	public static void main(String[] args) {
		Singleton s = Singleton.getInstance();
		s.storeInt(7);
		s.storeInt(8);
		
		System.out.println(s.getInt(0));
	}
}
