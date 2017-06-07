package com.hw.q13;

/**
 * Display the triangle on the console as follows using any type of loop.  
 * Do NOT use a simple group of print statements to accomplish this.
 *  0
 *  1 0
 *  1 0 1
 *  0 1 0 1
 * @author Gian-Carlo
 *
 */
public class Triangle {

	public static void main(String[] args) {
		int num = 0;
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(num + " ");
				if (num == 0)
					num++;
				else
					num--;
			}
			System.out.println();
		}
	}

}
