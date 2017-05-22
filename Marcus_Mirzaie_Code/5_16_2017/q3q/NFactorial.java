package q3q;

public class NFactorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	public int nFact(int n){
		if(n==1)	return 1;
		else return n*nFact(n-1);
	}

}
