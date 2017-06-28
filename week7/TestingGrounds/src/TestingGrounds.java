import java.util.*;
class TestingGrounds{

	public static void main(String []argh)
	{
		Integer[] arr = {1,2,3};
		String[] arr2 = {"Hello", "World"};
		
		printArray(arr);
		printArray(arr2);
	}
	
	public static <T> void printArray(T[] theArray){
		for(int i = 0; i < theArray.length; i++) System.out.println(theArray[i]);
	}
}