package com.rev.q11.main;

import com.rev.q11.data.Data;

public class CrossPackageAccess {
	public static void main(String[] args) {
		System.out.println("Float A: " + Data.getFloatA());
		System.out.println("Float B: " + Data.getFloatB());
	}
}
