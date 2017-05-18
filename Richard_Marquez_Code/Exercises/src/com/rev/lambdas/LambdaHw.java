package com.rev.lambdas;

public class LambdaHw {
	public static void main(String[] args) {
		StrDisplay sd = (String s) -> {
			StringBuffer sb = new StringBuffer(s);
			return sb.reverse().toString();
		};
		
		
		VarStrDisplay vsd = (String[] strs) -> {
			StringBuffer concat = new StringBuffer("");
			
			for (int i = 0; i < strs.length; i++) {
				concat.append(strs[i]);
			}
			
			return concat.reverse().toString();
		};
		
		System.out.println(sd.msg("asdf"));
		System.out.println(vsd.msg("asdf", "qwerty"));
	}

}

interface StrDisplay {
	String msg(String s);
}

interface VarStrDisplay {
	String msg(String...s);
}
