package stringPractice;

public class StringBs 
{
	public static void main(String[] args)		
	{
		String str = "Hi"; 
		StringBuilder sbuilder = new StringBuilder(str); 
		StringBuffer sbuffer = new StringBuffer(str); 
		
		str.concat("bye"); 
		sbuilder.append("bye"); 
		sbuffer.append("bye"); 
		
		System.out.println(str + " " + sbuilder + " " + sbuffer);
	}
}	
