package bubbleSort;

public class bubbleSort {
	public static void main(String[] args){
		int[] something = {10,1,2,3,3,4,5,6,7,8,9};
		sort(something);		
	}
	
	public static int[] sort(int[] A){
		int length = A.length;
		boolean swap = true;
		
		System.out.println("");
		
		while(swap){
			swap = false;
			for(int i = 1; i < length; i++){
				if(A[i-1] > A[i]){
					int temp = A[i-1];
					A[i-1] = A[i];
					A[i] = temp;
					swap = true;
				}
			}
		}
		return A;
	}
}
