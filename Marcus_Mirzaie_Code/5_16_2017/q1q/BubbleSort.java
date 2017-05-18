package q1q;

//import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	public int[] sort(int[] iarray){
		boolean outOfOrder;
		do{
			outOfOrder = false;
			//System.out.println(Arrays.toString(iarray));
			for(int i = 0;i<iarray.length;i++){
				if((i<iarray.length-1) && (iarray[i+1] < iarray[i])){
					outOfOrder = true;
					int tmp = iarray[i];
					iarray[i]=iarray[i+1];
					iarray[i+1]=tmp;
				}
			}
		}while(outOfOrder);
		return iarray;
	}

}
