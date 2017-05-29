package com.ex.strings;

public class StringSBCompare {

	public static void main(String[] args) {
		String str = "hello";
		StringBuilder sbuild = new StringBuilder(str);
		StringBuffer sbuff = new StringBuffer(str);
		
		str = str.concat(" world");
		sbuild.append(" world");
		sbuff.append(" world");
		
		System.out.println(str);
		System.out.println(sbuild);
		System.out.println(sbuff);
		
		String a = "hi";
		String b = "hi";
		System.out.println(a==b);
		b = new String("hi");
		System.out.println(a==b);
		System.out.println(".equals" + (a.equals(b)));
		a=b;
		System.out.println(a==b);
		
		String orig = "aaaaaaaaaa";
		String x = orig.replace("aaa", "bbb");
		System.out.println(x);
		String sub = orig.substring(0, 4); // prints 4, stops at endindex
		System.out.println(sub);
		char x1 = 0;
		int y = x1; //implicit
		char z = (char) y;//explicit
	}

}