package p3;

public class ReverseString 
{
	public static void main(String[] args)
	{
		System.out.println(reverse("apple"));

	}
	
	//recursive call
	public static String reverse(String str)
	{
		int length = str.length(); // get/check string size 
		
		// if only one letter is left (from odd length strings), return it
		// no swap needed
		if(length == 1)	
			return str; 
		
		// if 2 letter left in split, swap 
		// add first to end, then cut off dupe first letter
		if(length == 2)
		{
			str = str.concat(str.substring(0,1));
			return str.substring(1);
		}
		
		// if string hasn't been broken down into smallest part then 
		// split the string in half, and then combine the reversed halves 
		int half = length/2; 
		
		return str = reverse(str.substring(half)) + reverse(str.substring(0, half)); 
	}
}
