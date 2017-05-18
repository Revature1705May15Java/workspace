package exercise1;

public class CheckPrime {
	public static void main(String[] args) {
		
		for (int i = 0; i < 100; i++)
		{
			if(primeCheck(i+1)){
				System.out.print((i+1)+ ", ");
			}
		}

	}
	public static boolean primeCheck(int input){
		if(input == 1){return false;}
		else if(input == 2 || input == 3 ){ return true;}
		else{
			for(int i=2; i< input; i++){
				if(input%i ==0){
					//System.out.println("Number is not prime");
					return  false;
				}
			}
		}
		return true;
	}
}
