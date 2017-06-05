/*
 * Q3. Reverse a string without using a temporary variable.  
 * Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.
 */
public class ReserveString {
	public static void main(String[] args) {
		String toReverse = "gnihtemoS";
		
		System.out.println("Reverse:");
		for(int i = toReverse.length(); i > 0; i--){
			System.out.print(toReverse.charAt(i-1));
		}
		
	}
}
