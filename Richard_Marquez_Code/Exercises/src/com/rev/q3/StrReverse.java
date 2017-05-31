package com.rev.q3;

public class StrReverse {
    public static void main(String[] args) {
        String s = "asdf";
        String rs = rev(s);
        System.out.println(rs);
    }

    static String rev(String s) {
        String result = "";

        for (int i = s.length()-1; i >= 0; i--) {
            result += s.charAt(i);
        }

        return result;
    }
}
