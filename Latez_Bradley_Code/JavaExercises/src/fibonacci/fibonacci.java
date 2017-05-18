package fibonacci;

public class fibonacci {
	
	public int fibo(int n){
		if(n==0)
			return 0;
		else if(n==1)
			return 1;
		else
			//System.out.println(fibo(n-1)+fibo(n-2));
			return(fibo(n-1)+fibo(n-2));
	}
	
	public int [] fibList(int x){
		int [] flist = new int [x];
		for(int i=0;i<x;i++){
			flist[x]=fibo(x);
			//System.out.println(x);
		}
		for(int a=0;a>flist.length;a++)
			System.out.println(flist[a]);
		return flist;
	}
	
	

}
