package com.rev.q13;

import java.util.ArrayList;

public class Q13 {
    public static void main(String[] args) {
        int numLines = 4;
        ArrayList<Integer> b = new ArrayList();
        b.add(0);

        boolean zero = true;
        for (int i = 1; i <= numLines; i++) {
            for (int j = 0; j < i; j++) {
                if (zero) {
                    System.out.print(0 + " ");
                } else {
                    System.out.print(1 + " ");
                }
                zero = !zero;
            }
            System.out.println();
        }
    }
}
