package factorial;

public class factorial {
	
	public static int getFactorial(int n){
		int result = 1;
		int length = n;
		
		for(int i = 0; i < length; i++) result *= n--;

		return result;
	}

}
