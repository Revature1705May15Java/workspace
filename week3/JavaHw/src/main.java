import java.util.Scanner;

import bubbleSort.BubbleSort;
import factorial.factorial;
import fibonacci.fibo;
import iseven.evenCheck;
import mysubstring.mysubstr;
import reverse.rev;

public class main {

	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n=1;
		String q = "-----Question: ";
		
		System.out.println(q+n);
		
		BubbleSort b = new BubbleSort();
		int [] x ={1,0,5,6,3,2,7,9,8,4};
		x=b.sort(x);
		for(int i=0; i<x.length;i++){
			System.out.print(x[i]+", ");
			
		}
		System.out.println();
		++n;
		System.out.println(q+n);
		
		fibo f = new fibo();
		for(int i=0;i<25;i++){
			System.out.print(f.fibo(i)+" ");
		}
		System.out.println();
		++n;
		System.out.println(q+n);
		
		rev r = new rev();
		String s = "yellow";
		System.out.println(r.StringRev(s));
		
		System.out.println();
		++n;
		System.out.println(q+n);
		
		factorial fac = new factorial();
		System.out.println("Enter value to compute factorial");
		int facnum = scan.nextInt();
		System.out.println(fac.facto(facnum));
		scan.reset();
		
		System.out.println();
		++n;
		System.out.println(q+n);
		
		mysubstr subs = new mysubstr();
		subs.myss("YELLLLLLO", 4);
		
		System.out.println();
		++n;
		System.out.println(q+n);
		
		System.out.println("Enter a number to check if even: ");
		int e = scan.nextInt();
		
		evenCheck c = new evenCheck();
		if(c.iseven(e)){
			System.out.println("Number is even");
		}else{
			System.out.println("Number is not even");
		}
		
		
		System.out.println();
		++n;
		System.out.println(q+n);
		
		
		
		
		
		
		
		
		




		
		
		
	}

}