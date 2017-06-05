package com.corejava;
/*
Reverse a string without using a
 temporary variable.  Do NOT use 
 reverse() in the StringBuffer or the 
 StringBuilder APIs.
 */
public class Q3 {
	
	public Q3() {
	}
	public static String Q3m(String str){
		String strout=new String();
		for(int i=str.length()-1;i>-1;i--){
			strout=strout+str.charAt(i);
		}
		return strout;
	}
	public static void main(String[] args) {
		System.out.println(Q3m("wasps"));
	}
}
