package com.rev.q5;

public class Substr {
    public static void main(String[] args) {
        String s = "asdf";
        String sub = substr(s, 1, 4);
        System.out.println(sub);
    }

    static String substr(String s, int start, int end) {
        StringBuilder sb = new StringBuilder();

        for (int i = start; i < end; i++) {
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}
