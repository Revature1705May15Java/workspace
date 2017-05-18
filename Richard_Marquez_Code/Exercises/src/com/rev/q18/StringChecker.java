package com.rev.q18;

public class StringChecker extends StringCheckerAbs {

	public static void main(String[] args) {
		StringChecker sc = new StringChecker();
		String str = "asDf";
		
		//System.out.println(sc.toUpper(str));
		System.out.println(sc.toIntPlus10("-1"));
	}
	@Override
	public boolean hasUpper(String str) {
		if (str == null) return false;
		
		boolean result = false;
		
		for (int i = 0; i < str.length(); i++) {
			int charVal = (int) str.charAt(i);
			if (charVal >= 65 && charVal <= 90) {
				result = true;
				break;
			}
		}
		
		return result;
	}

	@Override
	public String toUpper(String str) {
		if (str == null) return null;
		
		StringBuilder result = new StringBuilder("");
		
		for (int i = 0; i < str.length(); i++) {
			int charVal = (int) str.charAt(i);

			if (charVal >= 97 && charVal <= 122) {
				charVal -= 32; // Convert char to uppercase equivalent
			}
			
			result.append((char) charVal);
		}	
		
		return result.toString();
	}

	@Override
	public int toIntPlus10(String str) {
		str = str.trim();
		
		int n = Integer.parseInt(str);
		n += 10;

		return n;
	}

}
