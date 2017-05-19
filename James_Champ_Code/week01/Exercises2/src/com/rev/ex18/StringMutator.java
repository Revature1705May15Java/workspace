package com.rev.ex18;

public abstract class StringMutator {
	public boolean hasUpperCase(String s) {
		boolean hasUpper = false;
		
		for(int i = 0; i < s.length() && !hasUpper; i++) {
			if(s.charAt(i) >= 65 && s.charAt(i) <= 90) {
				hasUpper = true;
			}
		}
		
		return hasUpper;
	}
	
	public String toUpperCase(String s) {
		String result = s.toUpperCase();
		return result;
	}
	
	public int toInt(String s) {
		return s.hashCode() + 10;
	}
}
