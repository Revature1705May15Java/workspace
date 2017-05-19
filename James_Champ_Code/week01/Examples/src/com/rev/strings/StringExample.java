package com.rev.strings;

public class StringExample {
	public static void main(String[] args) {
		String str = "hello";
		StringBuilder sb = new StringBuilder(str);
		StringBuffer sBuff = new StringBuffer(str);
		
		str.concat(" world");
		sb.append(" world");
		sBuff.append(" world");
		
		System.out.println(str);
		System.out.println(sb);
		System.out.println(sBuff);
	}
}
