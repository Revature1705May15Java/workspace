package com.rev.q10;

public class Min {
    public static float f1 = 2.3f;
    public static float f2 = 4.5f;

    public static void main(String[] args) {
        int n = 15;
        int m = 10;

        System.out.println(min(n, m));
    }

    static int min(int n, int m) {
        return (n < m ? n : m);
    }

}
