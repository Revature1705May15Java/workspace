package com.rev.q6;

public class Evens {
    public static void main(String[] args) {
        int x = 6;
        boolean res = isEven(x);
        System.out.println(res);
    }

    static boolean isEven(int x) {
        boolean result = false;

        while (x > 0) {
            x -= 2;
        }

        return x == 0;
    }
}
