package com.rev.q17;

import java.util.Scanner;

public class Q17 {
    float principle;
    float rate;
    float time;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Q17 q = new Q17();

        System.out.print("Enter principle: ");
        q.principle = Float.parseFloat(scan.nextLine());

        System.out.print("Enter rate: ");
        q.rate = Float.parseFloat(scan.nextLine());

        System.out.print("Enter time: ");
        q.time = Float.parseFloat(scan.nextLine());

        System.out.println("\nYour interest: $" + q.principle);
        System.out.println("\nYour interest: $" + q.rate);
        System.out.println("\nYour interest: $" + q.time);
        System.out.println("\nYour interest: $" + q.getInterest());
    }

    public float getInterest() {
        return principle*rate*time;
    }
}
