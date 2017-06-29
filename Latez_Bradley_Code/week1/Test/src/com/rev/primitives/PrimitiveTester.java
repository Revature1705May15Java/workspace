package com.rev.primitives;

public class PrimitiveTester {
	int v;
	private int x;
	protected int y;
	public int z;
	
	
	public PrimitiveTester(){
		super();
	}

	public PrimitiveTester(int v, int x, int y, int z) {
		super();
		this.v = v;
		this.x = x;
		this.y = y;
		this.z = z;
	}


	public int getV() {
		return v;
	}

	public void setV(int v) {
		this.v = v;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	    int a = 1;
		char b = 'a';
		long c = 100L;
		double d = 1;
		byte e = 1;
		char f = 1;
		
		
		System.out.println(a +  " " + b + " " + c + " " + d + " " + e + " " + f);
		
	
		

	}

}


class Test{
	
	PrimitiveTester pt = new PrimitiveTester();
	
	
	
}
