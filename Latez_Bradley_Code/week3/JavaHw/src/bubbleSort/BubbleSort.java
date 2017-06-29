package bubbleSort;
 
public class BubbleSort {
	
	public int[] sort(int[] x) {
		  for(;;) {
		      boolean s = false;
		      for(int i=1; i<x.length; i++) {
		         int temp=0;
		         if(x[i-1] > x[i]) {
		            temp = x[i-1];
		            x[i-1] = x[i];
		            x[i] = temp;
		            s = true;
		         }
		      }
		      if (!s) return x;
		  }
		}
	
	int [] intput = {1,0,5,6,3,2,3,7,9,8,4};
	
	
}
