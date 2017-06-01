package com.rev.q15;

interface MathInt {
    int add(int x, int y);
    int sub(int x, int y);
    int mul(int x, int y);
    int div(int x, int y);
}

public class Q15 implements MathInt {
    public static void main(String[] args) {
        MathInt i = new Q15();
        int x = 20;
        int y = 4;

        System.out.println(i.div(x, y));
    }

    @Override
    public int add(int x, int y) {
        return x+y;
    }

    @Override
    public int sub(int x, int y) {
        return x-y;
    }

    @Override
    public int mul(int x, int y) {
        return x*y;
    }

    @Override
    public int div(int x, int y) {
        return x/y;
    }
}
