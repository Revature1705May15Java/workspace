package com.rev.patterns;

public class PatternTester {

	public static void main(String[] args) {
		Singleton s = Singleton.getInstance();
		System.out.println(s.getMsg());
	}

}
